package com.threefiveninetong.mchh.sys.common;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.threefiveninetong.mchh.sys.service.CodeDictService;


public class CodeDictImpl implements CodeDict {
	
	@Resource
	private  CodeDictService  codeDictService;
	
	public String getCode(String category, String code) {
		Map<String,Object> conds = new HashMap<String,Object>();
		conds.put("categoryId", category);
		conds.put("codeKey", code);
		List<Map<String, Object>> codelist = codeDictService.queryForList(conds);
		if(codelist.size() > 0){
			return (String)codelist.get(0).get("CODE_VALUE");
		}
		return null;
	}

	public Map<String, String> getCodes(String category) {
		Map<String,Object> conds = new HashMap<String,Object>();
		conds.put("categoryId", category);
		List<Map<String, Object>> codelist = codeDictService.queryForList(conds);
		Map<String, String> codemap = new HashMap<String, String>();
		if(codelist.size() > 0){
			for(Map<String, Object> code : codelist){
				codemap.put((String)code.get("code_key"), (String)code.get("code_value"));
			}
		}
		return codemap;
	}

	public Map<String, Map<String, String>> getAllCodes() {
		Map<String,Object> conds = new HashMap<String,Object>();
		List<Map<String, Object>> categorylist = codeDictService.queryCategoryForList(conds);
		List<Map<String, Object>> codelist = codeDictService.queryForList(conds);
		
		Map<String, Map<String, String>> codes0 = new HashMap<String, Map<String, String>>();
		for(Map<String, Object> category : categorylist){
			String categoryId = (String) category.get("category_name");
			codes0.put(categoryId, new LinkedHashMap<String, String>());
		}
		for(Map<String, Object> code : codelist){
			String categoryId = (String) code.get("category_name");
			String codeKey = (String) code.get("code_key");
			String codeValue = (String) code.get("code_value");
			if(codes0.containsKey(categoryId)){
				codes0.get(categoryId).put(codeKey, codeValue);
			}
		}
		return codes0;
	}

}
