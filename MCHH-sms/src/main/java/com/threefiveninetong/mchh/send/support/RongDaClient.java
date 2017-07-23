package com.threefiveninetong.mchh.send.support;


import java.net.URLEncoder;

import com.threefiveninetong.mchh.send.util.InitDictionary;
import com.threefiveninetong.mchh.send.util.RongDaDictionary;
import com.threefiveninetong.mchh.send.util.UniqueNumUtil;
import com.threefiveninetong.mchh.send.vo.SendResultVo;
import com.threefiveninetong.mchh.core.util.ParseEncoding;
import com.threefiveninetong.mchh.core.util.SendurlUtil;


public class RongDaClient {

	private String userName;
	private String userPwd;
	

	
	public RongDaClient(String userName, String userPwd) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
	}


	/**
	 * 荣大发送短信类
	 * @param phone
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public SendResultVo SendSms(String phone,String content) throws Exception{
		        ParseEncoding parse=new ParseEncoding();
				SendResultVo vo=new SendResultVo();
				long batchId=UniqueNumUtil.next();
				StringBuffer sb=new StringBuffer();
				sb.append("username="+userName);
				sb.append("&password="+userPwd);
				sb.append("&content="+URLEncoder.encode(content, InitDictionary.RD_CHARSET));
				sb.append("&mobile="+phone);
				sb.append("&extcode="+RongDaDictionary.EXT_CODE);
				sb.append("&senddate=");//,13011850141,15810300420,18210057468
				sb.append("&batchID="+batchId);
				System.out.println(parse.getEncoding(sb.toString().getBytes()));
				String result=SendurlUtil.postSendUrl(RongDaDictionary.SENDING_URL,sb.toString(),InitDictionary.RD_CHARSET);
				result=result.replace("\r\n","");
				vo.setStatusCode(result);
                vo.setMessage(RongDaDictionary.RongErrorMap.get(result));
                vo.setMasDownId(batchId+"");
				return vo;
	}


	/**
	 * 获取荣大短信剩余条数
	 * @return
	 */
	public  String getBalance()throws Exception{
		StringBuffer sb=new StringBuffer();
		  sb.append("username="+userName);
		  sb.append("&password="+userPwd);
		  String result=   SendurlUtil.postSendUrl(RongDaDictionary.BALANCE_URL,sb.toString(),InitDictionary.RD_CHARSET);
		  result=result.replace("\r\n","");
		  return result;
	}
	/**
	 * 修改密码
	 * @throws Exception
	 */
	public void MotifyPassword()throws Exception{
}
	
	public void controlReport() {
		// TODO Auto-generated method stub
		
	}
	
	public void controlReceive() {
		// TODO Auto-generated method stub
		
	}
	
	public void warnSms() {
		// TODO Auto-generated method stub
		
	}

}
