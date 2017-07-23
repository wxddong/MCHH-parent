package com.threefiveninetong.mchh.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

public class MapUtil {

	/**
	 * <code>MapUtils</code> should not normally be instantiated.
	 */
	public MapUtil() {
	}

	// Type safe getters
	//-------------------------------------------------------------------------
	/**
	 * Gets from a Map in a null-safe manner.
	 * @param map the map to use
	 * @param key the key to look up
	 * @return the value in the Map, <code>null</code> if null map input
	 */
	public static Object getObject(final Map<?, ?> map, final Object key) {
		if (map != null) {
			return map.get(key);
		}
		return null;
	}

	/**
	 * Gets a String from a Map in a null-safe manner.
	 * <p>
	 * The String is obtained via <code>toString</code>.
	 * @param map the map to use
	 * @param key the key to look up
	 * @return the value in the Map as a String, <code>null</code> if null map input
	 */
	public static String getString(final Map<?, ?> map, final Object key) {
		if (map != null) {
			Object answer = map.get(key);
			if (answer != null) {
				return answer.toString();
			}
		}
		return null;
	}

	/**
	 * Gets a Boolean from a Map in a null-safe manner.
	 * <p>
	 * If the value is a <code>Boolean</code> it is returned directly. If the value is a <code>String</code> and it equals 'true' ignoring
	 * case then <code>true</code> is returned, otherwise <code>false</code>. If the value is a <code>Number</code> an integer zero value
	 * returns <code>false</code> and non-zero returns <code>true</code>. Otherwise, <code>null</code> is returned.
	 * @param map the map to use
	 * @param key the key to look up
	 * @return the value in the Map as a Boolean, <code>null</code> if null map input
	 */
	public static Boolean getBoolean(final Map<?, ?> map, final Object key) {
		Boolean value = null;
		if (map != null) {
			Object answer = map.get(key);
			if (answer != null) {
				if (answer instanceof Boolean) {
					value = (Boolean) answer;
				} else if (answer instanceof String) {
					value = Boolean.valueOf((String) answer);

				} else if (answer instanceof Number) {
					Number n = (Number) answer;
					value = (n.intValue() != 0) ? Boolean.TRUE : Boolean.FALSE;
				}
			}
		}
		return value;
	}

	/**
	 * Gets a Number from a Map in a null-safe manner.
	 * <p>
	 * If the value is a <code>Number</code> it is returned directly. If the value is a <code>String</code> it is converted using
	 * {@link NumberFormat#parse(String)} on the system default formatter returning <code>null</code> if the conversion fails. Otherwise,
	 * <code>null</code> is returned.
	 * @param map the map to use
	 * @param key the key to look up
	 * @return the value in the Map as a Number, <code>null</code> if null map input
	 */
	public static Number getNumber(final Map<?, ?> map, final Object key) {
		if (map != null) {
			Object answer = map.get(key);
			if (answer != null) {
				if (answer instanceof Number) {
					return (Number) answer;

				} else if (answer instanceof String) {
					try {
						String text = (String) answer;
						return NumberFormat.getInstance().parse(text);

					} catch (ParseException e) {
						logInfo(e);
					}
				}
			}
		}
		return null;
	}

	/**
	 * Gets a Byte from a Map in a null-safe manner.
	 * <p>
	 * The Byte is obtained from the results of {@link #getNumber(Map,Object)}.
	 * @param map the map to use
	 * @param key the key to look up
	 * @return the value in the Map as a Byte, <code>null</code> if null map input
	 */
	public static Byte getByte(final Map<?, ?> map, final Object key) {
		Number answer = getNumber(map, key);
		if (answer == null) {
			return null;
		} else if (answer instanceof Byte) {
			return (Byte) answer;
		}
		return new Byte(answer.byteValue());
	}

	/**
	 * Gets a Short from a Map in a null-safe manner.
	 * <p>
	 * The Short is obtained from the results of {@link #getNumber(Map,Object)}.
	 * @param map the map to use
	 * @param key the key to look up
	 * @return the value in the Map as a Short, <code>null</code> if null map input
	 */
	public static Short getShort(final Map<?, ?> map, final Object key) {
		Number answer = getNumber(map, key);
		if (answer == null) {
			return null;
		} else if (answer instanceof Short) {
			return (Short) answer;
		}
		return new Short(answer.shortValue());
	}

	/**
	 * Gets a Integer from a Map in a null-safe manner.
	 * <p>
	 * The Integer is obtained from the results of {@link #getNumber(Map,Object)}.
	 * @param map the map to use
	 * @param key the key to look up
	 * @return the value in the Map as a Integer, <code>null</code> if null map input
	 */
	public static Integer getInteger(final Map<?, ?> map, final Object key) {
		Number answer = getNumber(map, key);
		if (answer == null) {
			return null;
		} else if (answer instanceof Integer) {
			return (Integer) answer;
		}
		return new Integer(answer.intValue());
	}

	/**
	 * Gets a Long from a Map in a null-safe manner.
	 * <p>
	 * The Long is obtained from the results of {@link #getNumber(Map,Object)}.
	 * @param map the map to use
	 * @param key the key to look up
	 * @return the value in the Map as a Long, <code>null</code> if null map input
	 */
	public static Long getLong(final Map<?, ?> map, final Object key) {
		Number answer = getNumber(map, key);
		if (answer == null) {
			return null;
		} else if (answer instanceof Long) {
			return (Long) answer;
		}
		return new Long(answer.longValue());
	}

	/**
	 * Gets a Float from a Map in a null-safe manner.
	 * <p>
	 * The Float is obtained from the results of {@link #getNumber(Map,Object)}.
	 * @param map the map to use
	 * @param key the key to look up
	 * @return the value in the Map as a Float, <code>null</code> if null map input
	 */
	public static Float getFloat(final Map<?, ?> map, final Object key) {
		Number answer = getNumber(map, key);
		if (answer == null) {
			return null;
		} else if (answer instanceof Float) {
			return (Float) answer;
		}
		return new Float(answer.floatValue());
	}

	/**
	 * Gets a Double from a Map in a null-safe manner.
	 * <p>
	 * The Double is obtained from the results of {@link #getNumber(Map,Object)}.
	 * @param map the map to use
	 * @param key the key to look up
	 * @return the value in the Map as a Double, <code>null</code> if null map input
	 */
	public static Double getDouble(final Map<?, ?> map, final Object key) {
		Number answer = getNumber(map, key);
		if (answer == null) {
			return null;
		} else if (answer instanceof Double) {
			return (Double) answer;
		}
		return new Double(answer.doubleValue());
	}

	/**
	 * Gets a Map from a Map in a null-safe manner.
	 * <p>
	 * If the value returned from the specified map is not a Map then <code>null</code> is returned.
	 * @param map the map to use
	 * @param key the key to look up
	 * @return the value in the Map as a Map, <code>null</code> if null map input
	 */
	public static Map<?, ?> getMap(final Map<?, ?> map, final Object key) {
		if (map != null) {
			Object answer = map.get(key);
			if (answer != null && answer instanceof Map<?, ?>) {
				return (Map<?, ?>) answer;
			}
		}
		return null;
	}

	// Type safe getters with default values
	//-------------------------------------------------------------------------
	/**
	 * Looks up the given key in the given map, converting null into the given default value.
	 * @param map the map whose value to look up
	 * @param key the key of the value to look up in that map
	 * @param defaultValue what to return if the value is null
	 * @return the value in the map, or defaultValue if the original value is null or the map is null
	 */
	public static Object getObject(Map<?, ?> map, Object key, Object defaultValue) {
		if (map != null) {
			Object answer = map.get(key);
			if (answer != null) {
				return answer;
			}
		}
		return defaultValue;
	}

	/**
	 * Looks up the given key in the given map, converting the result into a string, using the default value if the the conversion fails.
	 * @param map the map whose value to look up
	 * @param key the key of the value to look up in that map
	 * @param defaultValue what to return if the value is null or if the conversion fails
	 * @return the value in the map as a string, or defaultValue if the original value is null, the map is null or the string conversion
	 *         fails
	 */
	public static String getString(Map<?, ?> map, Object key, String defaultValue) {
		String answer = getString(map, key);
		if (answer == null) {
			answer = defaultValue;
		}
		return answer;
	}

	/**
	 * Looks up the given key in the given map, converting the result into a boolean, using the default value if the the conversion fails.
	 * @param map the map whose value to look up
	 * @param key the key of the value to look up in that map
	 * @param defaultValue what to return if the value is null or if the conversion fails
	 * @return the value in the map as a boolean, or defaultValue if the original value is null, the map is null or the boolean conversion
	 *         fails
	 */
	public static Boolean getBoolean(Map<?, ?> map, Object key, Boolean defaultValue) {
		Boolean answer = getBoolean(map, key);
		if (answer == null) {
			answer = defaultValue;
		}
		return answer;
	}

	/**
	 * Looks up the given key in the given map, converting the result into a number, using the default value if the the conversion fails.
	 * @param map the map whose value to look up
	 * @param key the key of the value to look up in that map
	 * @param defaultValue what to return if the value is null or if the conversion fails
	 * @return the value in the map as a number, or defaultValue if the original value is null, the map is null or the number conversion
	 *         fails
	 */
	public static Number getNumber(Map<?, ?> map, Object key, Number defaultValue) {
		Number answer = getNumber(map, key);
		if (answer == null) {
			answer = defaultValue;
		}
		return answer;
	}

	/**
	 * Looks up the given key in the given map, converting the result into a byte, using the default value if the the conversion fails.
	 * @param map the map whose value to look up
	 * @param key the key of the value to look up in that map
	 * @param defaultValue what to return if the value is null or if the conversion fails
	 * @return the value in the map as a number, or defaultValue if the original value is null, the map is null or the number conversion
	 *         fails
	 */
	public static Byte getByte(Map<?, ?> map, Object key, Byte defaultValue) {
		Byte answer = getByte(map, key);
		if (answer == null) {
			answer = defaultValue;
		}
		return answer;
	}

	/**
	 * Looks up the given key in the given map, converting the result into a short, using the default value if the the conversion fails.
	 * @param map the map whose value to look up
	 * @param key the key of the value to look up in that map
	 * @param defaultValue what to return if the value is null or if the conversion fails
	 * @return the value in the map as a number, or defaultValue if the original value is null, the map is null or the number conversion
	 *         fails
	 */
	public static Short getShort(Map<?, ?> map, Object key, Short defaultValue) {
		Short answer = getShort(map, key);
		if (answer == null) {
			answer = defaultValue;
		}
		return answer;
	}

	/**
	 * Looks up the given key in the given map, converting the result into an integer, using the default value if the the conversion fails.
	 * @param map the map whose value to look up
	 * @param key the key of the value to look up in that map
	 * @param defaultValue what to return if the value is null or if the conversion fails
	 * @return the value in the map as a number, or defaultValue if the original value is null, the map is null or the number conversion
	 *         fails
	 */
	public static Integer getInteger(Map<?, ?> map, Object key, Integer defaultValue) {
		Integer answer = getInteger(map, key);
		if (answer == null) {
			answer = defaultValue;
		}
		return answer;
	}

	/**
	 * Looks up the given key in the given map, converting the result into a long, using the default value if the the conversion fails.
	 * @param map the map whose value to look up
	 * @param key the key of the value to look up in that map
	 * @param defaultValue what to return if the value is null or if the conversion fails
	 * @return the value in the map as a number, or defaultValue if the original value is null, the map is null or the number conversion
	 *         fails
	 */
	public static Long getLong(Map<?, ?> map, Object key, Long defaultValue) {
		Long answer = getLong(map, key);
		if (answer == null) {
			answer = defaultValue;
		}
		return answer;
	}

	/**
	 * Looks up the given key in the given map, converting the result into a float, using the default value if the the conversion fails.
	 * @param map the map whose value to look up
	 * @param key the key of the value to look up in that map
	 * @param defaultValue what to return if the value is null or if the conversion fails
	 * @return the value in the map as a number, or defaultValue if the original value is null, the map is null or the number conversion
	 *         fails
	 */
	public static Float getFloat(Map<?, ?> map, Object key, Float defaultValue) {
		Float answer = getFloat(map, key);
		if (answer == null) {
			answer = defaultValue;
		}
		return answer;
	}

	/**
	 * Looks up the given key in the given map, converting the result into a double, using the default value if the the conversion fails.
	 * @param map the map whose value to look up
	 * @param key the key of the value to look up in that map
	 * @param defaultValue what to return if the value is null or if the conversion fails
	 * @return the value in the map as a number, or defaultValue if the original value is null, the map is null or the number conversion
	 *         fails
	 */
	public static Double getDouble(Map<?, ?> map, Object key, Double defaultValue) {
		Double answer = getDouble(map, key);
		if (answer == null) {
			answer = defaultValue;
		}
		return answer;
	}

	/**
	 * Looks up the given key in the given map, converting the result into a map, using the default value if the the conversion fails.
	 * @param map the map whose value to look up
	 * @param key the key of the value to look up in that map
	 * @param defaultValue what to return if the value is null or if the conversion fails
	 * @return the value in the map as a number, or defaultValue if the original value is null, the map is null or the map conversion fails
	 */
	public static Map<?, ?> getMap(Map<?, ?> map, Object key, Map<?, ?> defaultValue) {
		Map<?, ?> answer = getMap(map, key);
		if (answer == null) {
			answer = defaultValue;
		}
		return answer;
	}

	// Type safe primitive getters
	//-------------------------------------------------------------------------
	/**
	 * Gets a boolean from a Map in a null-safe manner.
	 * <p>
	 * If the value is a <code>Boolean</code> its value is returned. If the value is a <code>String</code> and it equals 'true' ignoring
	 * case then <code>true</code> is returned, otherwise <code>false</code>. If the value is a <code>Number</code> an integer zero value
	 * returns <code>false</code> and non-zero returns <code>true</code>. Otherwise, <code>false</code> is returned.
	 * @param map the map to use
	 * @param key the key to look up
	 * @return the value in the Map as a Boolean, <code>false</code> if null map input
	 */
	public static boolean getBooleanValue(final Map<?, ?> map, final Object key) {
		Boolean booleanObject = getBoolean(map, key);
		if (booleanObject == null) {
			return false;
		}
		return booleanObject.booleanValue();
	}

	/**
	 * Gets a byte from a Map in a null-safe manner.
	 * <p>
	 * The byte is obtained from the results of {@link #getNumber(Map,Object)}.
	 * @param map the map to use
	 * @param key the key to look up
	 * @return the value in the Map as a byte, <code>0</code> if null map input
	 */
	public static byte getByteValue(final Map<?, ?> map, final Object key) {
		Byte byteObject = getByte(map, key);
		if (byteObject == null) {
			return 0;
		}
		return byteObject.byteValue();
	}

	/**
	 * Gets a short from a Map in a null-safe manner.
	 * <p>
	 * The short is obtained from the results of {@link #getNumber(Map,Object)}.
	 * @param map the map to use
	 * @param key the key to look up
	 * @return the value in the Map as a short, <code>0</code> if null map input
	 */
	public static short getShortValue(final Map<?, ?> map, final Object key) {
		Short shortObject = getShort(map, key);
		if (shortObject == null) {
			return 0;
		}
		return shortObject.shortValue();
	}

	/**
	 * Gets an int from a Map in a null-safe manner.
	 * <p>
	 * The int is obtained from the results of {@link #getNumber(Map,Object)}.
	 * @param map the map to use
	 * @param key the key to look up
	 * @return the value in the Map as an int, <code>0</code> if null map input
	 */
	public static int getIntValue(final Map<?, ?> map, final Object key) {
		Integer integerObject = getInteger(map, key);
		if (integerObject == null) {
			return 0;
		}
		return integerObject.intValue();
	}

	/**
	 * Gets a long from a Map in a null-safe manner.
	 * <p>
	 * The long is obtained from the results of {@link #getNumber(Map,Object)}.
	 * @param map the map to use
	 * @param key the key to look up
	 * @return the value in the Map as a long, <code>0L</code> if null map input
	 */
	public static long getLongValue(final Map<?, ?> map, final Object key) {
		Long longObject = getLong(map, key);
		if (longObject == null) {
			return 0L;
		}
		return longObject.longValue();
	}

	/**
	 * Gets a float from a Map in a null-safe manner.
	 * <p>
	 * The float is obtained from the results of {@link #getNumber(Map,Object)}.
	 * @param map the map to use
	 * @param key the key to look up
	 * @return the value in the Map as a float, <code>0.0F</code> if null map input
	 */
	public static float getFloatValue(final Map<?, ?> map, final Object key) {
		Float floatObject = getFloat(map, key);
		if (floatObject == null) {
			return 0f;
		}
		return floatObject.floatValue();
	}

	/**
	 * Gets a double from a Map in a null-safe manner.
	 * <p>
	 * The double is obtained from the results of {@link #getNumber(Map,Object)}.
	 * @param map the map to use
	 * @param key the key to look up
	 * @return the value in the Map as a double, <code>0.0</code> if null map input
	 */
	public static double getDoubleValue(final Map<?, ?> map, final Object key) {
		Double doubleObject = getDouble(map, key);
		if (doubleObject == null) {
			return 0d;
		}
		return doubleObject.doubleValue();
	}

	// Type safe primitive getters with default values
	//-------------------------------------------------------------------------
	/**
	 * Gets a boolean from a Map in a null-safe manner, using the default value if the the conversion fails.
	 * <p>
	 * If the value is a <code>Boolean</code> its value is returned. If the value is a <code>String</code> and it equals 'true' ignoring
	 * case then <code>true</code> is returned, otherwise <code>false</code>. If the value is a <code>Number</code> an integer zero value
	 * returns <code>false</code> and non-zero returns <code>true</code>. Otherwise, <code>defaultValue</code> is returned.
	 * @param map the map to use
	 * @param key the key to look up
	 * @param defaultValue return if the value is null or if the conversion fails
	 * @return the value in the Map as a Boolean, <code>defaultValue</code> if null map input
	 */
	public static boolean getBooleanValue(final Map<?, ?> map, final Object key, boolean defaultValue) {
		Boolean booleanObject = getBoolean(map, key);
		if (booleanObject == null) {
			return defaultValue;
		}
		return booleanObject.booleanValue();
	}

	/**
	 * Gets a byte from a Map in a null-safe manner, using the default value if the the conversion fails.
	 * <p>
	 * The byte is obtained from the results of {@link #getNumber(Map,Object)}.
	 * @param map the map to use
	 * @param key the key to look up
	 * @param defaultValue return if the value is null or if the conversion fails
	 * @return the value in the Map as a byte, <code>defaultValue</code> if null map input
	 */
	public static byte getByteValue(final Map<?, ?> map, final Object key, byte defaultValue) {
		Byte byteObject = getByte(map, key);
		if (byteObject == null) {
			return defaultValue;
		}
		return byteObject.byteValue();
	}

	/**
	 * Gets a short from a Map in a null-safe manner, using the default value if the the conversion fails.
	 * <p>
	 * The short is obtained from the results of {@link #getNumber(Map,Object)}.
	 * @param map the map to use
	 * @param key the key to look up
	 * @param defaultValue return if the value is null or if the conversion fails
	 * @return the value in the Map as a short, <code>defaultValue</code> if null map input
	 */
	public static short getShortValue(final Map<?, ?> map, final Object key, short defaultValue) {
		Short shortObject = getShort(map, key);
		if (shortObject == null) {
			return defaultValue;
		}
		return shortObject.shortValue();
	}

	/**
	 * Gets an int from a Map in a null-safe manner, using the default value if the the conversion fails.
	 * <p>
	 * The int is obtained from the results of {@link #getNumber(Map,Object)}.
	 * @param map the map to use
	 * @param key the key to look up
	 * @param defaultValue return if the value is null or if the conversion fails
	 * @return the value in the Map as an int, <code>defaultValue</code> if null map input
	 */
	public static int getIntValue(final Map<?, ?> map, final Object key, int defaultValue) {
		Integer integerObject = getInteger(map, key);
		if (integerObject == null) {
			return defaultValue;
		}
		return integerObject.intValue();
	}

	/**
	 * Gets a long from a Map in a null-safe manner, using the default value if the the conversion fails.
	 * <p>
	 * The long is obtained from the results of {@link #getNumber(Map,Object)}.
	 * @param map the map to use
	 * @param key the key to look up
	 * @param defaultValue return if the value is null or if the conversion fails
	 * @return the value in the Map as a long, <code>defaultValue</code> if null map input
	 */
	public static long getLongValue(final Map<?, ?> map, final Object key, long defaultValue) {
		Long longObject = getLong(map, key);
		if (longObject == null) {
			return defaultValue;
		}
		return longObject.longValue();
	}

	/**
	 * Gets a float from a Map in a null-safe manner, using the default value if the the conversion fails.
	 * <p>
	 * The float is obtained from the results of {@link #getNumber(Map,Object)}.
	 * @param map the map to use
	 * @param key the key to look up
	 * @param defaultValue return if the value is null or if the conversion fails
	 * @return the value in the Map as a float, <code>defaultValue</code> if null map input
	 */
	public static float getFloatValue(final Map<?, ?> map, final Object key, float defaultValue) {
		Float floatObject = getFloat(map, key);
		if (floatObject == null) {
			return defaultValue;
		}
		return floatObject.floatValue();
	}

	/**
	 * Gets a double from a Map in a null-safe manner, using the default value if the the conversion fails.
	 * <p>
	 * The double is obtained from the results of {@link #getNumber(Map,Object)}.
	 * @param map the map to use
	 * @param key the key to look up
	 * @param defaultValue return if the value is null or if the conversion fails
	 * @return the value in the Map as a double, <code>defaultValue</code> if null map input
	 */
	public static double getDoubleValue(final Map<?, ?> map, final Object key, double defaultValue) {
		Double doubleObject = getDouble(map, key);
		if (doubleObject == null) {
			return defaultValue;
		}
		return doubleObject.doubleValue();
	}

	// Conversion methods
	//-------------------------------------------------------------------------
	/**
	 * Gets a new Properties object initialised with the values from a Map. A null input will return an empty properties object.
	 * @param map the map to convert to a Properties object, may not be null
	 * @return the properties object
	 */
	public static Properties toProperties(final Map<?, ?> map) {
		Properties answer = new Properties();
		if (map != null) {
			for (Iterator<?> iter = map.entrySet().iterator(); iter.hasNext();) {
				Map.Entry<?, ?> entry = (Map.Entry<?, ?>) iter.next();
				Object key = entry.getKey();
				Object value = entry.getValue();
				answer.put(key, value);
			}
		}
		return answer;
	}

	/**
	 * Creates a new HashMap using data copied from a ResourceBundle.
	 * @param resourceBundle the resource bundle to convert, may not be null
	 * @return the hashmap containing the data
	 * @throws NullPointerException if the bundle is null
	 */
	public static Map<String, Object> toMap(final ResourceBundle resourceBundle) {
		Enumeration<String> enumeration = resourceBundle.getKeys();
		Map<String, Object> map = new HashMap<String, Object>();

		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			Object value = resourceBundle.getObject(key);
			map.put(key, value);
		}

		return map;
	}

	// Implementation methods
	//-------------------------------------------------------------------------
	/**
	 * Logs the given exception to <code>System.out</code>.
	 * <p>
	 * This method exists as Jakarta Collections does not depend on logging.
	 * @param ex the exception to log
	 */
	protected static void logInfo(final Exception ex) {
		System.out.println("INFO: Exception: " + ex);
	}

	//-----------------------------------------------------------------------
	/**
	 * Null-safe check if the specified map is empty.
	 * <p>
	 * Null returns true.
	 * @param map the map to check, may be null
	 * @return true if empty or null
	 * @since Commons Collections 3.2
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		return (map == null || map.isEmpty());
	}

	/**
	 * Null-safe check if the specified map is not empty.
	 * <p>
	 * Null returns false.
	 * @param map the map to check, may be null
	 * @return true if non-null and non-empty
	 * @since Commons Collections 3.2
	 */
	public static boolean isNotEmpty(Map<?, ?> map) {
		return !MapUtil.isEmpty(map);
	}
	
	/**
	 * 接口项目
	 * @return
	 */
	public static Map<String,Object> getResultSuccess() {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("statusCode", "0000");
		resultMap.put("message", "");
		return resultMap;
	}
	
	public static Map<String,Object> getResultFail  (String msg) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("statusCode", "-1000");
		resultMap.put("message", msg);
		return resultMap;
	}
	
	/**
	 * 支付项目通知
	 * @return
	 */
	public static Map<String,Object> getSuccessPayRespVo(){
		Map<String,Object> respVo = new HashMap<String,Object>();
		respVo.put("status", "0");
		respVo.put("message", "");
		return respVo;
	}
	
	/**
	 * 支付项目通知
	 * @return
	 */
	public static Map<String,Object> getFailPayRespVo(){
		Map<String,Object> respVo = new HashMap<String,Object>();
		respVo.put("status", "1");
		respVo.put("message", "");
		return respVo;
	}
}
