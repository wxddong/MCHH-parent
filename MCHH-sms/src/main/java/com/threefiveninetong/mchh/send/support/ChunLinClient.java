package com.threefiveninetong.mchh.send.support;

import java.io.ByteArrayInputStream;
import java.net.URLEncoder;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.threefiveninetong.mchh.send.util.ClunDictionary;
import com.threefiveninetong.mchh.send.util.InitDictionary;
import com.threefiveninetong.mchh.send.vo.CLQueryMoney;
import com.threefiveninetong.mchh.send.vo.CLSendMsgResult;
import com.threefiveninetong.mchh.core.exception.AppException;
import com.threefiveninetong.mchh.core.util.SendurlUtil;


public class ChunLinClient {

	Logger log=LoggerFactory.getLogger(ChunLinClient.class);
	
	private String kvalue;
	
	public ChunLinClient(String kvalue){
		this.kvalue=kvalue;
	}
	
	public CLSendMsgResult SendSms(String mobilePhone, String content) throws Exception{
		CLSendMsgResult cls=null;
		String param="k="+kvalue
		+"&r="+ClunDictionary.rvalue
		+"&p="+ClunDictionary.pvalue
		+"&t="+mobilePhone
		+"&"+ClunDictionary.cname+"="+URLEncoder.encode(content,InitDictionary.CL_CHARSET);
		String resultUnitopTer=SendurlUtil.postSendUrl(ClunDictionary.SENDURL, param,InitDictionary.CL_CHARSET);
/*		<?xml version="1.0" encoding="utf-8"?>
		<result>
		<err_code>0</err_code>
		<err_msg>操作成功！</err_msg>
		<sms_count>1</sms_count>
		<tick_ids>22378033</tick_ids>
		<remain_count>73635</remain_count>
		<server_time>2013-12-31 15:41:51</server_time>
		</result>*/

		SAXReader saxReader = new SAXReader();
		try {
			if(resultUnitopTer!=null&&!"".equals(resultUnitopTer)){
				cls=new CLSendMsgResult();
				Document document = saxReader.read(new ByteArrayInputStream(resultUnitopTer.getBytes("UTF-8")));
				Element ele=document.getRootElement();
				String errCode = ele.selectSingleNode("err_code").getText();
				log.info("春霖正常返回结果"+errCode+" "+"  发送短信内容："+content+"  手机号："+mobilePhone);
				String errMsg =  ele.selectSingleNode("err_msg").getText();
				String serverTime = ele.selectSingleNode("server_time").getText();
				Node elesmsCount =  ele.selectSingleNode("sms_count");
				Node eleremainCount = ele.selectSingleNode("remain_count");
				String smsCount="没有返回查询结果";
				String remainCount="没有返回查询结果";
				if(elesmsCount!=null){
					smsCount=elesmsCount.getText();
				}
				if(eleremainCount!=null){
					remainCount=eleremainCount.getText();
				}
				
				List tick_ids = ele.selectNodes("tick_ids");
				cls.setErrCode(errCode);
				cls.setErrMsg(errMsg);
				cls.setSmsCount(smsCount);
				cls.setRemainCount(remainCount);
				cls.setServerTime(serverTime);
				String [] ids=null;
				if(tick_ids!=null&&tick_ids.size()>0){
			    ids=new String[tick_ids.size()];
				for (int i = 0; i < tick_ids.size(); i++) {
					ids[i]=((Element)tick_ids.get(i)).getText();
				}
				}
				cls.setIds(ids);
			}
			
		} catch (Exception e) {
			log.info("春霖异常返回结果"+resultUnitopTer+"*******************");
			log.info("春霖异常返回结果"+e.getMessage());
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		return cls;
	}

	
	public void controlReceive() {
		// TODO Auto-generated method stub
		
	}

	
	public void controlReport() {
		// TODO Auto-generated method stub
		
	}

	
	public CLQueryMoney getBalance() {
		CLQueryMoney clr=null;
		String param="k="+kvalue+
		"&r="+ClunDictionary.rvalue;
		String resultUnitopTer=SendurlUtil.postSendUrl(ClunDictionary.QUERYMONEY, param,InitDictionary.CL_CHARSET);
		SAXReader saxReader = new SAXReader();
		try {
			if(resultUnitopTer!=null&&!"".equals(resultUnitopTer)){
			clr=new CLQueryMoney();
			Document document = saxReader.read(new ByteArrayInputStream(resultUnitopTer.getBytes("UTF-8")));
			Element ele=document.getRootElement();
			String errCode = ele.selectSingleNode("err_code").getText();
			String errMsg =  ele.selectSingleNode("err_msg").getText();
			String count1 =  ele.selectSingleNode("count1").getText();
			String count2 =  ele.selectSingleNode("count2").getText();
			String serverTime = ele.selectSingleNode("server_time").getText();
			clr.setErrCode(errCode);
			clr.setErrMsg(errMsg);
			clr.setServerTime(serverTime);
			clr.setCount1(count1);
			clr.setCount2(count2);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clr;
	}

	public void warnSms() {
		// TODO Auto-generated method stub
		
	}

	

}
