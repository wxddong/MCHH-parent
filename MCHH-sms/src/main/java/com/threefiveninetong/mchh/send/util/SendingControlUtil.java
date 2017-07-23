package com.threefiveninetong.mchh.send.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author liyg
 *
 */
public class SendingControlUtil {

       
	/**
	 * 将手机号字符串匹配为满足最大发送量的多个字符串
	 * regex需要的分隔符
	 * @return
	 */
	public static String[] ConverToManyPhone(String phone,int maxSize,String regex){
		List<String> list=new ArrayList<String>();
		if(StringUtils.isNotEmpty(phone)){
			String[] phongStr=phone.split(",");
			if(phongStr.length>maxSize){
				StringBuffer sb=new StringBuffer();
				int j=1;
				for (int i = 0; i < phongStr.length; i++) {
					if(j%(maxSize+1)==0){
						if(StringUtils.isNotEmpty(sb.toString())){
						list.add(sb.toString());
						}
						sb=new StringBuffer();
						j=1;
					}
					sb.append(phongStr[i].trim()+regex);
					j++;
				}
				list.add(sb.toString().trim().substring(0,sb.length()-1));
		    	return	(String[])list.toArray(new String[list.size()]);
			}else{
				StringBuffer sb=new StringBuffer();
				for (int i = 0; i < phongStr.length; i++) {
					sb.append(phongStr[i].trim()+regex);
				}
				return new String[]{sb.toString().trim().substring(0,sb.length()-1)};
			}
		}
		return null;
	}
	/**
	 * 将手机号字符串匹配为满足最大发送量的多个数组
	 * 
	 * @return
	 */
	public static String[][] ConverToManyPhone(String phone,int maxSize){
		List<String[]> resultList=new ArrayList<String[]>();
		List<String> list=new ArrayList<String>();
		if(StringUtils.isNotEmpty(phone)){
			String[] phongStr=phone.split(",");
			if(phongStr.length>maxSize){
				int j=1;
				for (int i = 0; i < phongStr.length; i++) {
					if(j%(maxSize+1)==0){
						resultList.add((String[])list.toArray(new String[list.size()]));
						list=new ArrayList<String>();
						j=1;
					}
					if(StringUtils.isNotEmpty(phongStr[i])){
						list.add(phongStr[i].trim());
					}
					j++;
				}
				resultList.add((String[])list.toArray(new String[list.size()]));
                return resultList.toArray(new String[resultList.size()][]);
			}else{
				for (int i = 0; i < phongStr.length; i++) {
					list.add(phongStr[i].trim());
				}
				resultList.add((String[])list.toArray(new String[list.size()]));
				return resultList.toArray(new String[resultList.size()][]);
			}
		}
		return null;
	}
	 /**
     * 
     * 方法: cutSmsContent 
     * 描述: 处理短信后缀问题 
     * 作者: dingjh
     * 时间: 2016-1-29 下午02:01:17
     * @param preOrBack  当为false的时候，为前缀，当为true的时候，变后缀
     * @return
     */
    public  static String cutSmsContent(String content,boolean  preOrBack){
    	if(preOrBack){
    		content=content+InitDictionary.SMS_MCHH_SUFFIX;
    	}else{
    		content=InitDictionary.SMS_MCHH_SUFFIX + content;
    	}
    	
    	return content;
    }

}
