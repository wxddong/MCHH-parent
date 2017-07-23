package com.threefiveninetong.mchh.send.support;


import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.threefiveninetong.mchh.send.vo.base.BaseVoExp;
import com.threefiveninetong.mchh.send.util.InitDictionary;
import com.threefiveninetong.mchh.send.util.JuXinTongDictionary;
import com.threefiveninetong.mchh.send.vo.SendResultVo;
import com.threefiveninetong.mchh.core.util.SendurlUtil;


public class JuXinTongClient {
	Logger smslog= LoggerFactory.getLogger(JuXinTongClient.class);
	private String userName;
	private String userPwd;
	

	
	public JuXinTongClient(String userName, String userPwd) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
	}


	/**
	 * 国都发送短信类
	 * @param phone
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public List<SendResultVo> SendSms(String phone,String content) throws Exception{
				
				StringBuffer sb=new StringBuffer();
				sb.append("username="+userName);
				sb.append("&pwd="+userPwd);
				sb.append("&msg="+URLEncoder.encode(content, InitDictionary.JX_CHARSET));
				sb.append("&mobile="+phone);
				sb.append("&gwid="+JuXinTongDictionary.smsId);
		        String result=SendurlUtil.getSendUrl(JuXinTongDictionary.SENDING_URL,sb.toString(),InitDictionary.JX_CHARSET);
				result=result.replace("\r\n","");
				smslog.info("聚信通发送短信后返回结果："+result);
				return convert2ListVo(result);
	}
	/**
	 * 获取国都短信剩余条数
	 * @return
	 */
	public  String getBalance()throws Exception{
		  StringBuffer sb=new StringBuffer();
		  sb.append("username="+userName);
		  sb.append("&pwd="+userPwd);
		  String result=SendurlUtil.postSendUrl(JuXinTongDictionary.BALANCE_URL,sb.toString(),InitDictionary.JX_CHARSET);
		  result=result.replace("\r\n","");
		  return result;
	}
	public String controlReport() {
		    StringBuffer sb=new StringBuffer();
	        sb.append("username="+userName);
	        sb.append("&pwd="+userPwd);
     	    String result=SendurlUtil.postSendUrl(JuXinTongDictionary.REPORT_URL,sb.toString(),InitDictionary.JX_CHARSET);
     	    result=result.replace("\r\n","");
     	    if(StringUtils.isNotEmpty(result)&&!result.contains("-")){
     	    smslog.info("聚信通下行返回结果："+result);
     	    return result; 
     	    }
     	   return null;
		
	}
	
	private List<SendResultVo> convert2ListVo(String result){
		List<SendResultVo> list=null;
//		result返回结果13466781961:134667819611406251506062370998,18210057468:182100574681406251506062370998
		if(StringUtils.isNotEmpty(result)){
			list=new ArrayList<SendResultVo>();
			if(result.indexOf(":")!=-1){
			    String[]phoneAndStates=result.split(",");
			    for (int i = 0; i < phoneAndStates.length; i++) {
				     if(StringUtils.isNotEmpty(phoneAndStates[i])
				    		 &&phoneAndStates[i].indexOf(":")!=-1){
				    	 String[] ps=phoneAndStates[i].split(":");
				    	        if(ps!=null&&ps.length==2&&StringUtils.isNotEmpty(ps[0])&&StringUtils.isNotEmpty(ps[1])){
				    			SendResultVo vo=new SendResultVo();
								vo.setStatusCode(BaseVoExp.Success);
				                vo.setMessage(JuXinTongDictionary.JuXinTongErrorMap.get(BaseVoExp.Success));
				                vo.setPhone(ps[0]);
				                vo.setMasDownId(ps[1]);
				                list.add(vo);
				    	     }
				     }	
				}
				
			}else{
				SendResultVo vo=new SendResultVo();
				vo.setStatusCode(result);
                vo.setMessage(JuXinTongDictionary.JuXinTongErrorMap.get(result));
                vo.setMasDownId("");
                list.add(vo);
			}
		}
		return list;
		
	}
	
	

}
