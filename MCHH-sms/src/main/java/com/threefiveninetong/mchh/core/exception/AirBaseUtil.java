package com.threefiveninetong.mchh.core.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

public class AirBaseUtil {

	public AirBaseUtil() {
	}

	/***************************************************************************
	 * P R I N T S T A C K T R A C E 将异常的栈信息打印到字符串中
	 * 
	 * @param t
	 *            异常
	 * @return String 字符串
	 **************************************************************************/
	public synchronized static String printStackTrace(Throwable t) {
		StringWriter sw = null;
		PrintWriter pw = null;
		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			t.printStackTrace(pw);
			pw.close();
			sw.close();
		} catch (Exception e) {
		}
		return sw.toString();
	}
}
