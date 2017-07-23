package com.threefiveninetong.mchh.util;

import java.util.Collection;
import java.util.List;

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
		return t==null?"":String.valueOf(t);
	}
	
	/**
	 * Unicode 转中文
	 * @param theString
	 * @author zhanght
	 * @return
	 */
	public static String decodeUnicode(String theString) {  
        char aChar;  
        int len = theString.length();  
        StringBuffer outBuffer = new StringBuffer(len);  
        for (int x = 0; x < len;) {  
            aChar = theString.charAt(x++);  
            if (aChar == '\\') {  
                aChar = theString.charAt(x++);  
                if (aChar == 'u') {  
                    // Read the xxxx  
                    int value = 0;  
                    for (int i = 0; i < 4; i++) {  
                        aChar = theString.charAt(x++);  
                        switch (aChar) {  
                        case '0':  
                        case '1':  
                        case '2':  
                        case '3':  
                        case '4':  
                        case '5':  
                        case '6':  
                        case '7':  
                        case '8':  
                        case '9':  
                            value = (value << 4) + aChar - '0';  
                            break;  
                        case 'a':  
                        case 'b':  
                        case 'c':  
                        case 'd':  
                        case 'e':  
                        case 'f':  
                            value = (value << 4) + 10 + aChar - 'a';  
                            break;  
                        case 'A':  
                        case 'B':  
                        case 'C':  
                        case 'D':  
                        case 'E':  
                        case 'F':  
                            value = (value << 4) + 10 + aChar - 'A';  
                            break;  
                        default:  
                            throw new IllegalArgumentException(  
                                    "Malformed   \\uxxxx   encoding.");  
                        }  
      
                    }  
                    outBuffer.append((char) value);  
                } else {  
                    if (aChar == 't')  
                        aChar = '\t';  
                    else if (aChar == 'r')  
                        aChar = '\r';  
                    else if (aChar == 'n')  
                        aChar = '\n';  
                    else if (aChar == 'f')  
                        aChar = '\f';  
                    outBuffer.append(aChar);  
                }  
            } else  
                outBuffer.append(aChar);  
        }  
        return outBuffer.toString();  
    }
	
	/**
	 * wangxd 将集合转化为逗号隔开的字符串
	 * @param stringList
	 * @return
	 */
	public static String listToString(List<String> stringList){
        if(stringList==null) {
            return null;
        }
        StringBuilder result=new StringBuilder();
        boolean flag=false;
        for(String string : stringList) {
            if(flag) {
                result.append(",");
            }else{
                flag=true;
            }
            result.append(string);
        }
        return result.toString();
    }
}
