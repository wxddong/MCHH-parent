package com.threefiveninetong.mchh.core.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {

	public static boolean sendMail(String emailList, String content) {
		try {
			Properties properties = new Properties();		
			properties.put("mail.smtp.host", "smtp.mxhichina.com");//设置邮件服务器
			properties.put("mail.smtp.auth", "true");//验证
			
			//根据属性新建一个邮件会话
			Session mailSession = Session.getInstance(properties, new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("dingjianhua@devsource.com.cn", "DingJH55");
				}
			});
			mailSession.setDebug(true);
			MimeMessage mailMessage = new MimeMessage(mailSession);//建立消息对象
			mailMessage.setFrom(new InternetAddress("dingjianhua@devsource.com.cn"));//发件人
            //收件人
//			mailMessage.setRecipient(MimeMessage.RecipientType.TO, new
//			InternetAddress("yucd@itkt.com"));

			List list = new ArrayList();//不能使用string类型的类型，这样只能发送一个收件人
			String[] emailArr = emailList.split(",");//对输入的多个邮件进行逗号分割
			for (int i = 0; i < emailArr.length; i++) {
				list.add(new InternetAddress(emailArr[i]));
			}
			InternetAddress[] address = (InternetAddress[])list.toArray(new InternetAddress[list.size()]);

			mailMessage.setRecipients(MimeMessage.RecipientType.TO, address);			
			mailMessage.setSubject("短信平台余额不足报警");//主题			
			mailMessage.setText(content);//邮件内容			
			mailMessage.setSentDate(new Date());//发信时间		
			mailMessage.saveChanges();//存储信息
			Transport trans = mailSession.getTransport("smtp");
			trans.send(mailMessage);//发送
			trans.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String aa="dingjianhua@devsource.com.cn";
		String content="测试";
		if(aa.contains("@")){//发报警邮件
			MailUtils.sendMail(aa, content);
		}else{//发报警短信
			System.out.println("发短信");
		}
	}

}
