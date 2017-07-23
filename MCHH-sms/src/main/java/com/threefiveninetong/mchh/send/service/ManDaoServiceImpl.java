package com.threefiveninetong.mchh.send.service;


import java.util.List;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.threefiveninetong.mchh.send.vo.base.BaseService;
import com.threefiveninetong.mchh.send.vo.base.BaseVoExp;
import com.threefiveninetong.mchh.send.support.JuXinTongSingletonClient;
import com.threefiveninetong.mchh.send.support.ManDaoSingletonClient;
import com.threefiveninetong.mchh.send.util.InitDictionary;
import com.threefiveninetong.mchh.send.util.ManDaoDictionary;
import com.threefiveninetong.mchh.send.util.SendingControlUtil;
import com.threefiveninetong.mchh.send.util.UniqueNumUtil;
import com.threefiveninetong.mchh.send.util.YiMeiUniqueNumUtil;
import com.threefiveninetong.mchh.send.vo.SendResultVo;
import com.threefiveninetong.mchh.core.util.StringUtil;
import com.threefiveninetong.mchh.po.SmsDownstatePO;
import com.threefiveninetong.mchh.po.SmsSendingPO;
@Service("MD")
public class ManDaoServiceImpl implements BaseService {

	Logger log= LoggerFactory.getLogger(ManDaoServiceImpl.class);
	@Override
	public BaseVoExp SendSms(BaseVoExp vo){
		try {
			SmsSendingPO po=vo.getSendingPo();
			long msId = UniqueNumUtil.next();
//			po.setContent(SendingControlUtil.cutSmsContent(po.getContent(),true));//当为false的时候，为前缀， 当为true的时候，变后缀
			String[] contentResult = cutSmsContent(po.getContent().trim(),true);
			po.setContent(contentResult[0]);
			String[] phoneNums=SendingControlUtil.ConverToManyPhone(po.getReceiver(), vo.getMaxSendNum(),InitDictionary.MANDAO_REGEX);
			if (phoneNums != null && contentResult != null
					&& contentResult[1] != null) {
		    for (int i = 0; i < phoneNums.length; i++) {
			    String result=ManDaoSingletonClient.getClient().mdgxsendIng(phoneNums[i],po.getContent(), contentResult[1],msId+"");
			    log.info("漫道科技返回结果：" + result + "  发送短信内容："
						+ contentResult[0] +";转换码："+contentResult[1]+ "  手机号："
						+ ArrayUtils.toString(phoneNums[i]));
			    if((msId+"").equals(result)){
					 vo.setStatusCode(vo.Success);
					 vo.setMessage(ManDaoDictionary.ManDaoErrorMap.get(vo.Success));
				}else{
				   log.info("漫道科技发送失败，返回结果：" + result + ";返回消息："+ManDaoDictionary.ManDaoErrorMap.get(result)+"  发送短信内容："
								+ contentResult[0] + "  手机号："
								+ ArrayUtils.toString(phoneNums[i]));
				   vo.setStatusCode(result);
				   vo.setMessage(ManDaoDictionary.ManDaoErrorMap.get(result));
				}
		        String[] phones=phoneNums[i].split(InitDictionary.MANDAO_REGEX);
				String[][] phoneAndIds=new String[phones.length][2];
				for (int j = 0; j <phones.length; j++) {
//					log.info("漫道科技返回结果："+rvo.getCode()+";返回错误消息："+rvo.getMsg()+"  ;发送短信内容："+po.getContent()+"  ；手机号："+rvo.getPhone()+"  ;downId:"+rvo.getMasDownId());
				    phoneAndIds[j][0]=phones[j];
				    phoneAndIds[j][1]=msId+"";
				}
				 vo.addPhoneAndDownIds(phoneAndIds);
					 
			}
		    Thread.sleep(2000);;//没执行一次睡眠2秒钟
			}
		} catch (Exception e) {
			vo.setStatusCode(InitDictionary.EXCEPTIONID);
		    vo.setMessage(InitDictionary.EXCEPTIONMSG);
			e.printStackTrace();
		}
		return vo;//
	}

	@Override
	public double getBalance(){
		try {
			return  InitDictionary.NOBALANCE;
		} catch (Exception e) {
			e.printStackTrace();
			return InitDictionary.EXCEPTIONBALANCE;
		}
	}

	@Override
	public List<SmsDownstatePO> controlReport(Object obj){
		return null;
	}

	@Override
	public void warnSms() {

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
	 * @param isPre false前缀，true 后缀
	 * @return  
	 */
	private static  String[] cutSmsContent(String content,boolean isPre) {
		String[] result = new String[2];
		result[1] = "1";
		if (!StringUtil.isNull(content)) {
			// 【 前面有签名情况
			String[] fixContent=spiltFix(content);
         if(!isPre){
		     if(!StringUtil.isNull(fixContent[1])){
		    	 result[0]=fixContent[1]+ fixContent[0];
		     }else if(!StringUtil.isNull(fixContent[2])){
		    	 result[0]=fixContent[2]+ fixContent[0];
		     }else{
		    	 result[0]=InitDictionary.SMS_ONE_SUFFIX+ fixContent[0];
		     }
		 }else{
            if(!StringUtil.isNull(fixContent[2])){
            	result[0]= fixContent[0]+fixContent[2]; 
		     }else if(!StringUtil.isNull(fixContent[1])){
		    	 result[0]=fixContent[0]+ fixContent[1];
		     }else{
		    	 result[0]= fixContent[0]+InitDictionary.SMS_ONE_SUFFIX;
		     }
		}
			if (result[0].indexOf(InitDictionary.SMS_ONE_SUFFIX) != -1) {
				result[1] = "1";
			}else if (result[0].indexOf(InitDictionary.SMS_TWO_SUFFIX) != -1) {
				result[1] = "";
			}else{
				if(!isPre){
					result[0]=InitDictionary.SMS_ONE_SUFFIX+spiltFix(result[0])[0];	
				}else{
					result[0]=spiltFix(result[0])[0]+InitDictionary.SMS_ONE_SUFFIX;
				}
			}
			return result;
	  }
		return null;
	}
	//除去空格，获取前缀及后缀
	public static String[] spiltFix(String content){
		String[] result = new String[3];
		if (!StringUtil.isNull(content)) {
		 String preFix="";
		 String suffix="";
		// 【 前面有签名情况
		if (content.substring(0, 1).equals("【")) {
			    preFix=content.substring(0,content.indexOf("】")+1);
			    content=content.substring(content.indexOf("】")+1);
		}
		//如果后面有签名
		if (content.substring(content.length() - 1).equals("】")) {
				suffix =content.substring(content.lastIndexOf("【"));
                content=content.substring(0, content.lastIndexOf("【"));
	   } 
		result[0]=content;
		result[1]=preFix;
		result[2]=suffix;
		if(content.indexOf("【")!=-1){
			result=spiltFix(content);
		}
		}
		return result;
	}
	
	
	
    public static void main(String[] args) {
	
//	   String aa="【隆畅达科技】【掌上航旅】abcd【掌上航旅】";
//    	String aa="bb";
//    	String aa="【隆畅达科技】abcd【掌上航旅】";
    	String aa="仲伟合 2015年04月03日 南方航空 CZ3257 白云国际机场 /16:50起飞 白塔埠机场  /20:35到达 票号:7848585418481,航班起飞前45分钟停止办理登机手续,请提前到机场办理登机手续以免造成误机，祝您旅途愉快！热线4006858999将随时为您服务.友情提示：据315曝光，近期短信诈 骗较多，若收到退改签机票等可疑信息，请致电隆畅达官方电话400-6858-999核实.";
      System.out.println( cutSmsContent(aa,false)[0]+"   "+cutSmsContent(aa,false)[1]);
	  System.out.println( cutSmsContent(aa,true)[0]+"   "+cutSmsContent(aa,true)[1]);
	
//	 System.out.println(aa.length()+" "+aa.substring(2));
}	
}
