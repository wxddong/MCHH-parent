package com.threefiveninetong.mchh.sys.common;

import java.util.Map;

/**
 * 代码字典类
 * @author chenr
 *
 */
public interface CodeDict {

	/**
	 * 获取一个代码类别下代码键的值
	 * @param category 代码类别
	 * @param code 代码键
	 * @return
	 */
	public String getCode(String category, String code);
	
	/**
	 * 获取一个代码类别下所有代码
	 * @param category
	 * @return
	 */
	public Map<String, String> getCodes(String category);
	
	/**
	 * 获取所有代码定义
	 * @return
	 */
	public Map<String, Map<String, String>> getAllCodes();
	
}
