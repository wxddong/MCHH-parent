package com.threefiveninetong.mchh.sys.po;

import java.util.Date;

/**
 * 
 * @author xuyh
 * @date 2013-7-16上午11:19:37
 * @description 操作日志持久化对象
 */
public class OperateLogPO {
	private String id;
	private String operatorId;// 操作员id
	private Date operateTime;// 操作时间
	private String resId;// 操作资源
	private int operateResult;// 操作结果
	private String operateData;// 操作数据
	private String logMac;// 日志mac
	private String loginName;// 操作员名称
	private String resName;// 操作资源名称

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}
	
	public int getOperateResult() {
		return operateResult;
	}

	public void setOperateResult(int operateResult) {
		this.operateResult = operateResult;
	}

	public String getOperateData() {
		return operateData;
	}

	public void setOperateData(String operateData) {
		this.operateData = operateData;
	}

	public String getLogMac() {
		return logMac;
	}

	public void setLogMac(String logMac) {
		this.logMac = logMac;
	}

}
