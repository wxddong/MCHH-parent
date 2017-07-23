package com.threefiveninetong.mchh.sys.common;

/**
 * 操作日志记录辅助接口
 * @author xuyh
 * @date 2013-7-26上午10:17:48
 * @description
 */
public interface OperateLog {
	
	 /**
	  * 记录操作日志
	 * @param message 操作相关信息
	 * @param success 操作成功或失败
	 */
	void doLog(String message, boolean success);
	 
}
