package com.threefiveninetong.mchh.core.util;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class NumberUtil {

	public static boolean isNumber(String value) {
		if (value == null || value.isEmpty()) {
			return false;
		}
		value = value.trim();
		char[] chars = value.toCharArray();

		int index = 0;
		if (chars[0] == '+' || chars[0] == '-') {
			index = 1;
		}

		boolean hasDecPoint = false;
		boolean hasExp = false;
		int len = chars.length;
		{
			boolean hasSign = false;
			int w = len - 1;
			while (index < w) {
				if (chars[index] >= '0' && chars[index] <= '9') {
				} else if (chars[index] == '.' && !hasExp && !hasDecPoint) {
					hasDecPoint = true;
				} else if ((chars[index] == 'E' || chars[index] == 'e') && !hasExp) {
					hasExp = true;
				} else if (hasExp && (chars[index] == '+' || chars[index] == '-') && !hasSign) {
					hasSign = true;
				} else {
					return false;
				}
				index++;
			}
		}
		if (chars[index] >= '0' && chars[index] <= '9') {
			return true;
		} else if (chars[index] == 'D' || chars[index] == 'd' || chars[index] == 'F' || chars[index] == 'f') {
			return true;
		} else if (chars[index] == 'l' || chars[index] == 'L') {
			return (!hasDecPoint) && (!hasExp);
		}

		return false;
	}

	public static short toShort(String value) {
		if (value == null || value.isEmpty()) {
			return 0;
		}
		value = value.trim();
		char[] chars = value.toCharArray();

		int index = 0;
		if (chars[0] == '+' || chars[0] == '-') {
			index = 1;
		}
		int len = chars.length;
		short n = 0;
		while (index < len) {
			if (chars[index] >= '0' && chars[index] <= '9') {
				n = (short) (n * 10 + (chars[index++] - '0'));
				if (n < 0) {
					return chars[0] == '-' && n == -32768 ? (short) -32768 : 0;
				}
			} else {
				break;
			}
		}
		if (chars[0] == '-') {
			n = (short) -n;
		}
		return n;
	}

	public static short toShort(String value, boolean isLenient) {
		if (isLenient) {
			return toShort(value);
		}
		try {
			return Short.parseShort(value);
		} catch (Exception e) {
		}
		return 0;
	}

	public static int toInt(String value) {
		if (value == null || value.isEmpty()) {
			return 0;
		}
		value = value.trim();
		char[] chars = value.toCharArray();

		int index = 0;
		if (chars[0] == '+' || chars[0] == '-') {
			index = 1;
		}
		int len = chars.length;
		int n = 0;
		while (index < len) {
			if (chars[index] >= '0' && chars[index] <= '9') {
				n = n * 10 + (chars[index++] - '0');
				if (n < 0) {
					return chars[0] == '-' && n == -2147483648 ? -2147483648 : 0;
				}
			} else {
				break;
			}
		}
		if (chars[0] == '-') {
			n = -n;
		}
		return n;
	}

	public static int toInt(String value, boolean isLenient) {
		if (isLenient) {
			return toInt(value);
		}
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
		}
		return 0;
	}

	public static long toLong(String value) {
		if (value == null || value.isEmpty()) {
			return 0;
		}
		value = value.trim();
		char[] chars = value.toCharArray();

		int index = 0;
		if (chars[0] == '+' || chars[0] == '-') {
			index = 1;
		}
		int len = chars.length;
		long n = 0;
		while (index < len) {
			if (chars[index] >= '0' && chars[index] <= '9') {
				n = n * 10 + (chars[index++] - '0');
				if (n < 0) {
					return chars[0] == '-' && n == -9223372036854775808L ? -9223372036854775808L : 0;
				}
			} else {
				break;
			}
		}
		if (chars[0] == '-') {
			n = -n;
		}
		return n;
	}

	public static long toLong(String value, boolean isLenient) {
		if (isLenient) {
			return toLong(value);
		}
		try {
			return Long.parseLong(value);
		} catch (Exception e) {
		}
		return 0;
	}

	public static float toFloat(String value) {
		float f = (float) toDouble(value);
		if (f != Float.POSITIVE_INFINITY && f != Float.NEGATIVE_INFINITY) {
			return f;
		}
		return 0F;
	}

	public static float toFloat(String value, boolean isLenient) {
		if (isLenient) {
			return toFloat(value);
		}
		try {
			return Float.parseFloat(value);
		} catch (Exception e) {
		}
		return 0F;
	}

	public static double toDouble(String value) {
		if (value == null || value.isEmpty()) {
			return 0D;
		}
		value = value.trim();
		char[] chars = value.toCharArray();
		int len = chars.length;
		char[] charsNew = new char[len];
		int index = 0;

		if (chars[0] == '+' || chars[0] == '-') {
			index = 1;
			charsNew[0] = chars[0];
		}

		{
			boolean hasDecPoint = false;
			boolean hasExp = false;
			boolean hasSign = false;
			boolean isNotNumber = false;
			while (index < len) {
				if (chars[index] >= '0' && chars[index] <= '9') {
				} else if (chars[index] == '.' && !hasExp && !hasDecPoint) {
					hasDecPoint = true;
				} else if ((chars[index] == 'E' || chars[index] == 'e') && !hasExp) {
					hasExp = true;
				} else if (hasExp && (chars[index] == '+' || chars[index] == '-') && !hasSign) {
					hasSign = true;
				} else {
					isNotNumber = true;
					break;
				}
				charsNew[index] = chars[index];
				index++;
			}
			if (index == len - 1) {
				if (chars[index] == 'D' || chars[index] == 'd' || chars[index] == 'F' || chars[index] == 'f') {
					isNotNumber = false;
				}
			}
			value = String.valueOf(charsNew);
			if (isNotNumber && hasExp) {
				int i = value.indexOf("E");
				if (i == -1) {
					i = value.indexOf("e");
				}
				value = value.substring(0, i);
			}
		}
		try {
			return Double.parseDouble(value);
		} catch (Exception e) {
		}
		return 0D;
	}

	public static double toDouble(String value, boolean isLenient) {
		if (isLenient) {
			return toDouble(value);
		}
		try {
			return Double.parseDouble(value);
		} catch (Exception e) {
		}
		return 0D;
	}

	public static BigInteger toBigInteger(String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		value = value.trim();
		char[] chars = value.toCharArray();
		int len = chars.length;
		char[] charsNew = new char[len];
		int index = 0;
		int indexNew = 0;
		if (chars[0] == '+' || chars[0] == '-') {
			index = 1;
			if (chars[0] == '-') {
				indexNew = 1;
				charsNew[0] = chars[0];
			}
		}
		while (index < len) {
			if (chars[index] >= '0' && chars[index] <= '9') {
				charsNew[indexNew++] = chars[index];
				index++;
			} else {
				break;
			}
		}
		value = String.valueOf(charsNew).substring(0, indexNew);
		try {
			return new BigInteger(value);
		} catch (Exception e) {
		}
		return null;
	}

	public static BigInteger toBigInteger(String value, boolean isLenient) {
		if (isLenient) {
			return toBigInteger(value);
		}
		try {
			return new BigInteger(value);
		} catch (Exception e) {
		}
		return null;
	}

	public static BigDecimal toBigDecimal(String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		value = value.trim();
		char[] chars = value.toCharArray();
		int len = chars.length;
		char[] charsNew = new char[len];
		int index = 0;

		if (chars[0] == '+' || chars[0] == '-') {
			index = 1;
			charsNew[0] = chars[0];
		}

		{
			boolean hasDecPoint = false;
			boolean hasExp = false;
			boolean hasSign = false;
			boolean isNotNumber = false;
			while (index < len) {
				if (chars[index] >= '0' && chars[index] <= '9') {
				} else if (chars[index] == '.' && !hasExp && !hasDecPoint) {
					hasDecPoint = true;
				} else if ((chars[index] == 'E' || chars[index] == 'e') && !hasExp) {
					hasExp = true;
				} else if (hasExp && (chars[index] == '+' || chars[index] == '-') && !hasSign) {
					hasSign = true;
				} else {
					isNotNumber = true;
					break;
				}
				charsNew[index] = chars[index];
				index++;
			}
			value = String.valueOf(charsNew);
			if (index == len - 1) {
				if (chars[index] == 'D' || chars[index] == 'd' || chars[index] == 'F' || chars[index] == 'f') {
					isNotNumber = false;
					value = value.substring(0, index);
				}
			}
			if (isNotNumber) {
				int i = index;
				if (hasExp) {
					i = value.indexOf("E");
					if (i == -1) {
						i = value.indexOf("e");
					}
				}
				value = value.substring(0, i);
			}
		}
		try {
			return new BigDecimal(value);
		} catch (Exception e) {
		}
		return null;
	}

	public static BigDecimal toBigDecimal(String value, boolean isLenient) {
		if (isLenient) {
			return toBigDecimal(value);
		}
		try {
			return new BigDecimal(value);
		} catch (Exception e) {
		}
		return null;
	}

	public static Number toNumber(String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		value = value.trim();
		{
			int plusSignIndex = value.indexOf('+');
			if (plusSignIndex == 0) {
				char sign = value.charAt(1);
				if (sign == '+' || sign == '-') {
					return null;
				}
				value = value.substring(plusSignIndex + 1);
			}
		}
		int len = value.length();
		char lastChar = value.charAt(len - 1);
		switch (lastChar) {
		case 'l':
		case 'L':
			try {
				return Long.parseLong(value.substring(0, len - 1));
			} catch (Exception e) {
			}
			break;
		case 'f':
		case 'F':
			try {
				return Float.parseFloat(value);
			} catch (Exception e) {
			}
			break;
		case 'd':
		case 'D':
			try {
				return Double.parseDouble(value);
			} catch (Exception e) {
			}
			break;
		default:
			break;
		}
		int desIndex = value.indexOf('.');
		int expIndex = value.indexOf('E') + value.indexOf('e') + 1;
		if (desIndex == -1 && expIndex == -1) {
			try {
				return Integer.parseInt(value);
			} catch (Exception e) {
			}
			try {
				return Long.parseLong(value);
			} catch (Exception e) {
			}
			try {
				return new BigInteger(value);
			} catch (Exception e) {
			}
		} else {
			if (expIndex > len || lastChar == 'L' || lastChar == 'l') {
				return null;
			}
			try {
				return Float.parseFloat(value);
			} catch (Exception e) {
			}
			try {
				return Double.parseDouble(value);
			} catch (Exception e) {
			}
			try {
				return new BigDecimal(value);
			} catch (Exception e) {
			}
		}
		return null;
	}
}
