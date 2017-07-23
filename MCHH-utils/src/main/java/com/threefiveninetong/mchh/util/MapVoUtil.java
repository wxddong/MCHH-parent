package com.threefiveninetong.mchh.util;

import java.util.HashMap;
import java.util.Map;

/** 
 * @ClassName: MapVoUtil 
 * @Description: TODO map相应VO
 * @author: jixf
 * @date: 2016年1月15日 上午11:11:02  
 */
public class MapVoUtil {
	
	/** 
	 * @Title: getSuccessMapRespVo 
	 * @Description: TODO 获取成功的mapBaseVo
	 * @param: @return
	 * @return: Map<String,Object>
	 */
	public static Map<String,Object> getSuccessMapRespVo(){
		Map<String,Object> respVo = new HashMap<String,Object>();
		respVo.put("statusCode", "0000");
		respVo.put("message", "");
		return respVo;
	}
	
	public static Map<String,Object> getFailMapRespVo(String reason){
		Map<String,Object> respVo = new HashMap<String,Object>();
		respVo.put("statusCode", "-1001");
		respVo.put("message", reason);
		return respVo;
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
