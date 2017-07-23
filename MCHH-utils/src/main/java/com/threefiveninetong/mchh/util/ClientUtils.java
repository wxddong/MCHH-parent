package com.threefiveninetong.mchh.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ClientUtils {
//	public static final int PAGE_SIZE=20;  //客户端列表分页，每页显示的记录数
	public static final int PAGE_SIZE=7;  //客户端列表分页，每页显示的记录数
	
	
	/**
	 * 生成html
	 * @return
	 */
	public static String generateHtml(String content){
		if(StringUtil.isNullOrBlank(content)){  //不为空
			return "";
		}
		content=TextUtil.ueditorReduction(content);
		StringBuilder head = new StringBuilder();
		head.append("<!DOCTYPE html>");
		head.append( "<html lang=\"en\">");
		head.append(content).append("</html>");
		content = head.toString(); 
		return content;
	}
	
}