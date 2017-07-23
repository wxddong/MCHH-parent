package com.threefiveninetong.mchh.core.util;

import java.util.Collection;

public final class StringUtil {
	public static boolean isNull(String str) {
		if (str == null || str.isEmpty()|| str.trim().length()<=0) {
			return true;
		}
		return false;
	}

	public static boolean isNullOrBlank(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		char[] chars = str.toCharArray();
		for (int i = 0, len = chars.length; i < len; ++i) {
			if (!Character.isWhitespace(chars[i])) {
				return false;
			}
		}
		return true;
	}

	public static String unite(String[] strs, String regex) {
		if (strs == null || regex == null) {
			return null;
		}
		StringBuffer buffer = new StringBuffer();
		for (String str : strs) {
			if (str == null) {
				str = "";
			}
			buffer.append(str).append(regex);
		}
		int regexIndex = buffer.lastIndexOf(regex);
		int len = buffer.length();
		if (regexIndex == len - 1) {
			buffer.delete(regexIndex, len);
		}
		return len > 0 ? buffer.toString() : null;
	}

	public static String unite(Collection<String> strs, String regex) {
		if (strs == null || regex == null) {
			return null;
		}
		StringBuffer buffer = new StringBuffer();
		for (String str : strs) {
			if (str == null) {
				str = "";
			}
			buffer.append(str).append(regex);
		}
		int regexIndex = buffer.lastIndexOf(regex);
		int len = buffer.length();
		if (regexIndex == len - 1) {
			buffer.delete(regexIndex, len);
		}
		return len > 0 ? buffer.toString() : null;
	}

	public static boolean equalsAny(String str, String[] strs) {
		if (str != null && strs != null) {
			for (String strTmp : strs) {
				if (str.equals(strTmp)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean containsIgnoreCase(String str, String searchStr) {
		if (str == null || searchStr == null) {
			return false;
		}
		for (int i = 0, len = str.length() - searchStr.length(); i <= len; i++) {
			if (str.regionMatches(true, i, searchStr, 0, searchStr.length())) {
				return true;
			}
		}
		return false;
	}

	public static boolean startsWithIgnoreCase(String str, String prefix) {
		if (str == null || prefix == null) {
			return false;
		}
		return str.regionMatches(true, 0, prefix, 0, prefix.length());
	}

	public static boolean startsWithIgnoreCase(String str, int toffset, String prefix) {
		if (str == null || prefix == null) {
			return false;
		}
		return str.regionMatches(true, toffset, prefix, 0, prefix.length());
	}

	public static boolean endsWithIgnoreCase(String str, String suffix) {
		if (str == null || suffix == null) {
			return false;
		}
		int len = suffix.length();
		return str.regionMatches(true, str.length() - len, suffix, 0, len);
	}
	
	/** 
	 * @Title: valueOf 
	 * @Description: TODO 对象toString,null对象为""
	 * @param: @param t
	 * @param: @return
	 * @return: String
	 */
	public static String valueOf(Object t){
		return t==null?"":t.toString();
	}
}
