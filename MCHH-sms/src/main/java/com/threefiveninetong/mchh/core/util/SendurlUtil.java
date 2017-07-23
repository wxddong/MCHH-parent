package com.threefiveninetong.mchh.core.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.threefiveninetong.mchh.core.exception.AppException;


public class SendurlUtil {
	public static String postSendUrl(String url,String param,String charSet)throws AppException{
		//发送请求
		URL requestUrl;
		String result="";
		try {
			requestUrl = new URL(url);
			//打开URL 
			HttpURLConnection httpConn = (HttpURLConnection) requestUrl.openConnection();		
			httpConn.setDoOutput(true);//http正文内，因此需要设为true, 默认情况下是false
			httpConn.setDoInput(true);//设置是否从httpUrlConnection读入，默认情况下是true
			httpConn.setUseCaches(false); //Post 请求不能使用缓存   
			httpConn.setRequestMethod("POST");//设定请求的方法为"POST"，默认是GET 
			PrintWriter out = new PrintWriter(httpConn.getOutputStream());//写入请求参数
			out.print(param);
			out.flush();
			out.close();

			InputStream inputStream=httpConn.getInputStream();
			InputStreamReader inputStreamReader=new InputStreamReader(inputStream,charSet);
			BufferedReader in = new BufferedReader(inputStreamReader);
			String lineStr;
		
			while ((lineStr = in.readLine())!= null)
			{
				result += lineStr; 
				result+="\r\n";
			}
			result=URLDecoder.decode(result,charSet);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
           throw new AppException(e.getMessage(),e);
		}
		return result;
	}
	
	public static  String getCurrentTime(){
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=sdf.format(date);
		return time;
	}
	
	public static  Date string2Date(String time) throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");//YYYYMMDDHHMMSS
		Date date=sdf.parse(time);
		return date;
		
	}
	public static String getSendUrl(String myurl,String param,String charSet) throws Exception {
		URL url = new URL(myurl+"?"+param);
//		System.out.println(myurl+"?"+param);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("user-agent",
				"mozilla/4.0 (compatible; msie 6.0; windows 2000)");
		connection.connect();
		StringBuffer sb = new StringBuffer();
		if (connection.getResponseCode() == 200) {
			InputStream in = connection.getInputStream();
			BufferedReader breader = new BufferedReader(new InputStreamReader(
					in, charSet));
			String str = breader.readLine();
			while (str != null) {
				sb.append(str);
				str = breader.readLine();
			}
			in.close();
		}
		connection.disconnect();
		connection = null;
		url = null;
		return sb.toString();
	}
}
