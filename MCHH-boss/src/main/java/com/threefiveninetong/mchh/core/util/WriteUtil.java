package com.threefiveninetong.mchh.core.util;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.threefiveninetong.mchh.core.page.Model;
import com.threefiveninetong.mchh.util.JsonUtil;


public class WriteUtil {
    /**
     *   将对象转换成JSON字符串并输出到前台
     * @param response
     * @param model
     */
	public static void writeJson(HttpServletResponse response,Model model) {
		try {
			response.setHeader("Content-Type","text/html; charset=utf-8");
			PrintWriter w = response.getWriter();
			String res = JsonUtil.toJson(model);
			w.write(res);
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将文件输出到前台，下载操作
	 * 
	 * @param filepath
	 *            相对路径
	 * @param newFileName
	 *            新文件名
	 * @throws Exception
	 */

	public static void writeFile(HttpServletRequest request,HttpServletResponse response,String filepath, String newFileName,String type)
			throws Exception {
		File file = new File(filepath);
		InputStream ins = new BufferedInputStream(new FileInputStream(file));
		byte[] buffer = new byte[ins.available()];
		ins.read(buffer);
		ins.close();
		response.reset();
		if(type.equals("apk")){
			newFileName=encodeFilename(newFileName+".apk", request);// 处理中文文件名
		}else if(type.equals("pdf")){
			newFileName=encodeFilename(newFileName+".pdf", request);// 处理中文文件名	
		}
		response.addHeader("Content-Disposition", "attachment;filename="+ new String(newFileName.getBytes()));
		response.addHeader("Content-Length", "" + file.length());
		OutputStream ous = new BufferedOutputStream(response.getOutputStream());
		response.setContentType("application/octet-stream");
		ous.write(buffer);
		ous.flush();
		ous.close();
	}
	
	
	
 /**
     * 设置下载文件中文件的名称
     * 
     * @param filename
     * @param request
     * @return
     */
    public static String encodeFilename(String filename, HttpServletRequest request){
        if(filename == null || "".equals(filename.trim()))
             return filename;
       
        String agent = request.getHeader("USER-AGENT");
        try {
             //ie6.7.8.9.10
             if ((agent != null) && (-1 != agent.indexOf("MSIE"))){
                  String newFileName = URLEncoder.encode(filename, "UTF-8");
                  newFileName = newFileName.replace("+", "%20");
                  if(newFileName.length() > 150) {
                       newFileName = new String(filename.getBytes("GB2312"), "ISO8859-1");
                       newFileName = newFileName.replace("+", "%20");
                  }
                  return newFileName;
             }
             else if ((agent != null) && (-1 != agent.indexOf("Firefox")))//Firefox
                return MimeUtility.encodeText(filename, "UTF-8", "B");
             else
                  return new String(filename.getBytes("GBK"),"ISO-8859-1");
        } catch (Exception e) {
             return filename;
        }
   }

}
