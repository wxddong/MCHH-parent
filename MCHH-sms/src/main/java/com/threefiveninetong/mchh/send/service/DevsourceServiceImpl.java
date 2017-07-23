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
import com.threefiveninetong.mchh.send.support.DevsourceSingletonClient;
import com.threefiveninetong.mchh.send.support.YiMeiSingletonClient;
import com.threefiveninetong.mchh.send.util.InitDictionary;
import com.threefiveninetong.mchh.send.util.SendingControlUtil;
import com.threefiveninetong.mchh.send.util.YiMeiUniqueNumUtil;
import com.threefiveninetong.mchh.send.vo.devsource.OverageReturnsms;
import com.threefiveninetong.mchh.send.vo.devsource.SendReturnsms;
import com.threefiveninetong.mchh.po.SmsDownstatePO;
import com.threefiveninetong.mchh.po.SmsSendingPO;
import com.threefiveninetong.mchh.core.util.DateUtil;
import com.threefiveninetong.mchh.core.util.StringUtil;


@Service("DY")
public class DevsourceServiceImpl implements BaseService {

	Logger log = LoggerFactory.getLogger(DevsourceServiceImpl.class);

	@Override
	public BaseVoExp SendSms(BaseVoExp baseVoExp) {
		SmsSendingPO po = baseVoExp.getSendingPo();
//		po.setContent(SendingControlUtil.cutSmsContent(po.getContent(), false));//签名处理
//		long msId = YiMeiUniqueNumUtil.next();
		String result = "0";
		try {
			String[] phoneNums = SendingControlUtil.ConverToManyPhone(po.getReceiver(), baseVoExp.getMaxSendNum(),InitDictionary.DEVSOURCE_REGEX);
			String[] contentResult = cutSmsContent(po.getContent());//签名处理
			po.setContent(contentResult[0]);
			if (phoneNums != null && contentResult != null&& contentResult[1] != null) {
				for (int i = 0; i < phoneNums.length; i++) {
//					String telephoneList="";
//					for (int j = 0; j < phoneNums[i].length; j++) {
//						/**//******** 加入缓存开始，100个手机号超过3次的返回失败 ******************/
//						/*if (!addCash(YiMeiUniqueNumUtil.phoneCash
//								.get(phoneNums[i][j]), phoneNums[i][j])) {
//							log.error("易美发送超过3次：" + "  发送短信内容："
//									+ po.getContent() + "  手机号："
//									+ phoneNums[i][j]);
//							vo.setErrorCode(InitDictionary.EXCEPTIONID);
//							vo.setErrorMsg("10分钟内易美发送超过3次");
//							return vo;
//						}*/
//						/******** 添加缓存结束 ************************************/
//						telephoneList += phoneNums[i][j]+",";
//					}
					
					SendReturnsms sendReturnsms=DevsourceSingletonClient.getClient().sendSMS(phoneNums[i], po.getContent());
	
					String errorCode=sendReturnsms.getReturnstatus();
					baseVoExp.setStatusCode(errorCode);
					baseVoExp.setMessage(sendReturnsms.getMessage());
					if(errorCode.equals("Success")){//成功
						baseVoExp.setStatusCode(baseVoExp.Success);
					}
					String[][] phoneAndDownIds=new String[1][2];
					phoneAndDownIds[0][0]=phoneNums[i];
					phoneAndDownIds[0][1]=sendReturnsms.getTaskID();
					baseVoExp.addPhoneAndDownIds(phoneAndDownIds);
					
					result=baseVoExp.getStatusCode();
					log.info("返回结果：" + result + "  发送短信内容："+ contentResult[0] + "  手机号："+ ArrayUtils.toString(phoneNums[i]));
//					if (result == 17) {// 发送信息失败
//						log.error("发送信息失败，返回码：" + result);
//					} else if (result == 101) {// 客户端网络故障
//						log.error("客户端网络故障：" + result);
//					} else if (result == 305) {// 服务器端返回错误，错误的返回值（返回值不是数字字符串）
//						log.error("服务器端返回错误，错误的返回值（返回值不是数字字符串）：" + result);
//					} else if (result == 307) {// 目标电话号码不符合规则，电话号码必须是以0、1开头
//						log.error("目标电话号码不符合规则，电话号码必须是以0、1开头：" + result);
//					} else if (result == 997) {// 平台返回找不到超时的短信，该信息是否成功无法确定
//						log.error("平台返回找不到超时的短信，该信息是否成功无法确定：" + result);
//					} else if (result == 998) {// 由于客户端网络问题导致信息发送超时，该信息是否成功下发无法确定
//						log.error("由于客户端网络问题导致信息发送超时，该信息是否成功下发无法确定：" + result);
//					}
				}
				Thread.sleep(2000);
				;// 每执行一次睡眠2秒钟
			} else {
				log.error("返回结果：" + result + "  发送短信内容：" + po.getContent()
						+ "  手机号：" + po.getReceiver() + "转换结果" + contentResult);
			}
		} catch (Exception e) {
			baseVoExp.setStatusCode(InitDictionary.EXCEPTIONID);
			baseVoExp.setMessage(InitDictionary.EXCEPTIONMSG);
			e.printStackTrace();
		}
		return baseVoExp;//
	}

	@Override
	public double getBalance() {
		try {
			OverageReturnsms overageReturnsms=DevsourceSingletonClient.getClient().getBalance();
			return Double.valueOf(overageReturnsms.getOverage());
		} catch (RemoteException e) {
			e.printStackTrace();
			return InitDictionary.EXCEPTIONBALANCE;
		}
	}

	@Override
	public List<SmsDownstatePO> controlReport(Object obj) {
		return null;
	}

	@Override
	public void warnSms() {
		try {
//			double balace = YiMeiSingletonClient.getClient().getBalance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void controlReceive(Object obj) {

	}

	/**
	 * 
	 * 方法: cutSmsContent <br>
	 * 描述: 处理短信后缀问题 <br>
	 * 作者: liyg@itkt.com <br>
	 * 时间: 2014-5-23 下午02:01:17
	 * 
	 * @param
	 * @return
	 */
	private  String[] cutSmsContent(String content) {
		String[] result = new String[2];
		result[0] = content;
		result[1] = "1";
		boolean isFaSong = false;
		if (!StringUtil.isNull(content)) {
			// 全角【 前面有签名情况
			if (content.substring(0, 1).equals("【")) {
				//去掉前面的签名
				result[0] = content.substring(content.indexOf("】")+1,content.length());	
				// 后面若果有签名，删掉
				if (content.substring(content.length() - 1).equals("】")) {
					result[0] = content.substring(0, content.lastIndexOf("【"));
				}
			} 
//			else {// 前面没有签名
//				// 判断后面有没有签名，如果没有签名
//				if (content.substring(content.length() - 1).equals("】")) {
//					content = content.substring(content.indexOf("【"))
//							+ content.substring(0, content.indexOf("【"));
//				} else {
//					content = InitDictionary.SMS_ONE_SUFFIX + content;
//				}
//				result[0] = content;
//			}
//			if (result[0].indexOf(InitDictionary.SMS_ONE_SUFFIX) != -1) {
//				result[1] = "1";
//				isFaSong = true;
//			}
//			if (result[0].indexOf(InitDictionary.SMS_TWO_SUFFIX) != -1) {
//				result[1] = "2";
//				isFaSong = true;
//			}
//			if (!isFaSong) {
//				result[0] = InitDictionary.SMS_ONE_SUFFIX
//						+ content.substring(content.indexOf("】") + 1);
//			}
			return result;
		}
		return null;
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

	public static void main(String[] args) {

		String aa = "您好！民生信用卡中心提交了改期申请单，票号:8765276772237，请及时处理。";
		/*System.out.println(cutSmsContent(aa)[0] + "          "
				+ cutSmsContent(aa)[1]);*/
		
		System.out.println(new DevsourceServiceImpl().cutSmsContent("【隆畅达科技】仲伟合 2015年04月03日 南方航空 CZ3257 白云国际机场 /16:50起飞 白塔埠机场  /20:35到达 票号:7848585418481,航班起飞前45分钟停止办理登机手续,请提前到机场办理登机手续以免造成误机，祝您旅途愉快！热线4006858999将随时为您服务.友情提示：据315曝光，近期短信诈 骗较多，若收到退改签机票等可疑信息，请致电隆畅达官方电话400-6858-999核实.")[0]);

	}

}
