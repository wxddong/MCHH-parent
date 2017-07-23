package com.threefiveninetong.mchh.send.util;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;


public class YiMeiUniqueNumUtil {
	// 易美的缓存
	// 15978783695 <yyyy-MM-dd HH:mm:ss>
	public static Map<String, LinkedList<String>> phoneCash = new LinkedHashMap<String, LinkedList<String>>() {
		private static final long serialVersionUID = 1245759000290596652L;

		@Override
		protected boolean removeEldestEntry(Entry<String, LinkedList<String>> eldest) {
			return size() > 100;
		}
	};// 50

	public static int CashMintes = 10;
	private static Date date = new Date();
	private static StringBuilder buf = new StringBuilder();
	private static int seq = 0;
	private static final int ROTATION = 99999;

	public static synchronized long next() {
		if (seq > ROTATION)
			seq = 0;
		buf.delete(0, buf.length());
		date.setTime(System.currentTimeMillis());
		String str = String.format("%1$tY%1$tm%1$td%1$tk%1$tM%1$tS%2$05d", date, seq++);
		return Long.parseLong(str);

	}

}
