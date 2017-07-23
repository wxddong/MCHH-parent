package com.threefiveninetong.mchh.send.service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.threefiveninetong.mchh.send.vo.base.BaseService;
import com.threefiveninetong.mchh.send.vo.base.BaseVoExp;
import com.threefiveninetong.mchh.send.support.YiMeiSingletonClient;
import com.threefiveninetong.mchh.send.util.InitDictionary;
import com.threefiveninetong.mchh.send.util.SendingControlUtil;
import com.threefiveninetong.mchh.send.util.YiMeiUniqueNumUtil;
import com.threefiveninetong.mchh.po.SmsDownstatePO;
import com.threefiveninetong.mchh.po.SmsSendingPO;
import com.threefiveninetong.mchh.send.webservice.yimei.Mo;
import com.threefiveninetong.mchh.send.webservice.yimei.StatusReport;
import com.threefiveninetong.mchh.core.exception.AppException;
import com.threefiveninetong.mchh.core.util.DateUtil;
import com.threefiveninetong.mchh.core.util.IdUtil;
import com.threefiveninetong.mchh.core.util.PropertyUtil;
import com.threefiveninetong.mchh.core.util.StringUtil;

@Service("YM")
public class YimeiServiceImpl implements BaseService {

	Logger log = LoggerFactory.getLogger(YimeiServiceImpl.class);

	@Override
	public BaseVoExp SendSms(BaseVoExp vo) {
		SmsSendingPO po = vo.getSendingPo();
		String smsContent=SendingControlUtil.cutSmsContent(po.getContent(), false);
		po.setContent(smsContent);
		long msId = YiMeiUniqueNumUtil.next();
		int result = 0;
		try {
			String[][] phoneNums = SendingControlUtil.ConverToManyPhone(po.getReceiver(), vo.getMaxSendNum());
			if (phoneNums != null && smsContent != null) {
				for (int i = 0; i < phoneNums.length; i++) {
					String[][] phoneAndDownIds = new String[phoneNums[i].length][2];// 下行id列表
					//注销2015-3-26 by ccc
					for (int j = 0; j < phoneNums[i].length; j++) {
						/**//******** 加入缓存开始，100个手机号超过3次的返回失败 ******************/
						/*if (!addCash(YiMeiUniqueNumUtil.phoneCash
								.get(phoneNums[i][j]), phoneNums[i][j])) {
							log.error("易美发送超过3次：" + "  发送短信内容："
									+ po.getContent() + "  手机号："
									+ phoneNums[i][j]);
							vo.setErrorCode(InitDictionary.EXCEPTIONID);
							vo.setErrorMsg("10分钟内易美发送超过3次");
							return vo;
						}*/
						/******** 添加缓存结束 ************************************/
						phoneAndDownIds[j][0] = phoneNums[i][j];
						phoneAndDownIds[j][1] = msId + "";
					}
					result = YiMeiSingletonClient.getClient().sendSMS(
							phoneNums[i], smsContent, po.getSmstype(),msId + i);
					vo.setStatusCode(result + "");
					if(result==0){
						vo.setStatusCode(BaseVoExp.Success);
					}

					vo.addPhoneAndDownIds(phoneAndDownIds);
					log.info("易美返回结果：" + result + "  发送短信内容："
							+ smsContent + "  手机号："+ ArrayUtils.toString(phoneNums[i]));
				}
				Thread.sleep(2000);//每执行一次睡眠2秒钟
			} else {
				log.error("易美返回结果：" + result + "  发送短信内容：" + po.getContent()
						+ "  手机号：" + po.getReceiver());
			}
		} catch (Exception e) {
			vo.setStatusCode(InitDictionary.EXCEPTIONID);
			vo.setMessage(InitDictionary.EXCEPTIONMSG);
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public double getBalance() {
		try {
			return YiMeiSingletonClient.getClient().getBalance() * 10;
		} catch (RemoteException e) {
			e.printStackTrace();
			return InitDictionary.EXCEPTIONBALANCE;
		}
	}

	@Override
	public List<SmsDownstatePO> controlReport(Object obj) {
		List<SmsDownstatePO> downList = null;

		try {
			// 手机号码:13898175351 状态:0 信息ID：1387334743824
			List<StatusReport> statusReport = YiMeiSingletonClient.getClient()
					.getReport();
			if (statusReport != null && statusReport.size() > 0) {
				downList = new ArrayList<SmsDownstatePO>();
				for (int i = 0; i < statusReport.size(); i++) {
					StatusReport po = statusReport.get(i);
					SmsDownstatePO masDeliver = new SmsDownstatePO();
					masDeliver.setId(IdUtil.uuid());//ID
					masDeliver.setMasdownmsgid(po.getSeqID() + "");
					masDeliver.setPlatformCode(PropertyUtil.getProperty()
							.getString("YIMEIMARK"));// ("GuoDuDelever");
					if ("DELIVRD".equals(po.getErrorCode())
							|| "0".equals(po.getErrorCode())) {
						masDeliver.setDownstate("0");
					} else {
						log.error("非正常状态：   " + po.getReportStatus() + "；错误码："
								+ po.getErrorCode());
						masDeliver.setDownstate("1");
					}
					masDeliver.setIsresend("0");
//					提交时间：20140926081139	接受时间：20140926081143
					masDeliver.setReceivetime(DateUtil.stringToDate(po.getSubmitDate(),"yyyyMMddHHmmss"));
					masDeliver.setPhone(po.getMobile());
					masDeliver.setCreatetime(new Date());
					downList.add(masDeliver);
				}
			}
			return downList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void warnSms() {
		try {
			double balace = YiMeiSingletonClient.getClient().getBalance();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void controlReceive(Object obj) {

		try {
			List<Mo> mo = YiMeiSingletonClient.getClient().getMO();
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), e);
		}
	}

	public boolean addCash(LinkedList<String> histryList, String phoneNum) {
		boolean isFail = true;
		if (histryList != null) {
			if (histryList.size() < 3) {
				histryList.add(DateUtil.dateToString(new Date(),"yyyy-MM-dd HH:mm:ss"));
			} else {
				String currenTime = DateUtil.dateToString(new Date(),"yyyy-MM-dd HH:mm:ss");
				String firstTime = histryList.get(0);
				int minute = DateUtil.getMinutes(currenTime, firstTime);
				if (minute < YiMeiUniqueNumUtil.CashMintes) {
					log.error("易美发送10分钟内超过3次：" + "   " + "  手机号：" + phoneNum
							+ ",第一次发送时间" + firstTime + "=====" + currenTime);
					isFail = false;
				} else {
					histryList.remove(0);
					histryList.add(currenTime);
				}

			}
		} else {
			histryList = new LinkedList<String>();
			histryList.add(DateUtil.dateToString(new Date(),"yyyy-MM-dd HH:mm:ss"));
			YiMeiUniqueNumUtil.phoneCash.put(phoneNum, histryList);
		}
		return isFail;
	}

}
