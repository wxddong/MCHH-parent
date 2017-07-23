package com.threefiveninetong.mchh.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 类: PropertiesUtil <br>
 * 描述: 资源文件工具类 <br>
 * 作者: 周照 <br>
 * 时间: 2013-1-29 下午04:35:49
 */
public final class PropertiesUtil {

	private String path;

	private Properties properties;

	public PropertiesUtil(String path) throws RuntimeException {
		this.path = path;
		File file = new File(path);
		properties = new Properties();
		FileInputStream inpf = null;
		try {
			inpf = new FileInputStream(file);
			properties.load(inpf);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String get(String key) {
		return properties.getProperty(key);
	}

	public Set<String> getValues() {
		Set<String> values = new HashSet<String>();
		for (Object value : properties.values()) {
			values.add((String)value);
		}
		return values;
	}

	public Set<String> keySet() {
		Set<String> keys = new HashSet<String>();
		for (Object key : properties.keySet()) {
			keys.add((String)key);
		}
		return keys;
	}

	public boolean containsKey(String key) {
		return properties.containsKey(key);
	}

	public boolean containsValue(String value) {
		return properties.containsValue(value);
	}

	public Set<Entry<String, String>> entrySet() {
		Set<Entry<String, String>> keys = new HashSet<Entry<String, String>>();
		for (final Entry<Object, Object> entry : properties.entrySet()) {
			Entry<String, String> entryTmp = new Entry<String, String>() {

				
				public String setValue(String value) {
					return (String) entry.setValue(value);
				}

				
				public String getValue() {
					return (String) entry.getValue();
				}

				
				public String getKey() {
					return (String) entry.getKey();
				}
			};
			keys.add(entryTmp);
		}
		return keys;
	}

	public void put(String key, String value) throws RuntimeException {
		try {
			OutputStream out = new FileOutputStream(this.path);
			properties.setProperty(key, value);
			properties.store(out, "Update '" + key + "' value");
			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String getPath(String fileName) {
		return PropertiesUtil.class.getResource("/").getPath() + fileName;
	}
}
