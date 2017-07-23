package com.threefiveninetong.mchh.sys.common;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.threefiveninetong.mchh.sys.service.CodeDictService;




public class CodeDictCacheImpl implements CodeDict, Reloadable {

	@Resource
	private CodeDictService codeDictService;

	private Map<String, Map<String, String>> codes = new HashMap<String, Map<String, String>>();
	private long lastmodify = -1L;// 上一次修改时间
	private Object lock = new Object();

	public String getCode(String category, String code) {
		if (lastmodify<0)
			reload();
		return this.codes.get(category).get(code);
	}

	public Map<String, String> getCodes(String category) {
		if (lastmodify<0)
			reload();
		Map<String, String> codemap = this.codes.get(category);
		return codemap;
	}

	public Map<String, Map<String, String>> getAllCodes() {
		if (lastmodify<0)
			reload();
		return codes;
	}

	@Override
	public long lastModify() {
		return this.lastmodify;
	}

	@Override
	public void reload() {
		Map<String, Map<String, String>> codes0 = new HashMap<String, Map<String, String>>();

		Map<String, Object> conds = new HashMap<String, Object>();
		List<Map<String, Object>> categorylist = codeDictService.queryCategoryForList(conds);// 类别列表
		List<Map<String, Object>> codelist = codeDictService.queryForList(conds);// 代码列表

		for (Map<String, Object> category : categorylist) {
			String categoryId = (String) category.get("category_name");
			codes0.put(categoryId, new LinkedHashMap<String, String>());
		}
		for (Map<String, Object> code : codelist) {
			String categoryId = (String) code.get("category_name");
			String codeKey = (String) code.get("code_key");
			String codeValue = (String) code.get("code_value");
			if (codes0.containsKey(categoryId)) {
				codes0.get(categoryId).put(codeKey, codeValue);
			}
		}

		synchronized (lock) {
			this.codes = codes0;
			this.lastmodify = System.currentTimeMillis();
		}

	}

}
