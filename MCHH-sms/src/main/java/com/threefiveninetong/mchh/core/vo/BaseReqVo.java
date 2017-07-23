/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: BaseReqVo.java 
 * @Prject: MCHH-api
 * @Package: com.threefiveninetong.mchh.core.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016年1月8日 上午10:40:03 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.core.vo;

/** 
 * @ClassName: BaseReqVo 
 * @Description: TODO
 * @author: zhanght
 * @date: 2016年1月8日 上午10:40:03  
 */
public class BaseReqVo {
	
	private String terminalNo;
	
	private String sign;
	
	public String getTerminalNo() {
		return terminalNo;
	}
	public void setTerminalNo(String terminalNo) {
		this.terminalNo = terminalNo;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
}
