package com.threefiveninetong.mchh.sys.common;

import java.util.Date;

import javax.annotation.Resource;

import com.threefiveninetong.mchh.sys.service.OperateLogService;
import com.threefiveninetong.mchh.sys.vo.OperateLogVO;


/**
 * 操作日志记录辅助接口实现类
 * @author xuyh
 * @date 2013-7-26上午10:18:14
 * @description
 */
public class OperateLogImpl implements OperateLog {
	
	@Resource
	private OperateLogService logService;
	
	public OperateLogImpl(){
	}
	public OperateLogImpl(OperateLogService logService){
		this.logService = logService;
	}
	private String operatorId;
	private Date operateTime;
	private String resId;
	private int operateResult;
	private String logMac;
	private String operateData;
	
	
	public void doLog(String message, boolean success) {
		if(success){
			this.setOperateResult(1);
		}else{
			this.setOperateResult(0);
		}
		if(!message.equals("")){
			this.operateData+=";\r\nOTHER: "+message;
		}
		OperateLogVO log = new OperateLogVO();
		log.setOperatorId(this.operatorId);
		log.setResId(this.resId);
		log.setOperateData(this.operateData);
		log.setOperateTime(this.operateTime);
		log.setOperateResult(operateResult);
//		try {
//			this.logMac = MacUtil.md5(this.operatorId+this.resId+this.operateResult+this.operateTime);
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
		log.setLogMac(this.logMac);
		logService.addOperateLog(log);
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
	public void setResId(String funcId) {
		this.resId = funcId;
	}
	public int getOperateResult() {
		return operateResult;
	}
	public void setOperateResult(int operateResult) {
		this.operateResult = operateResult;
	}
	public String getLogMac() {
		return logMac;
	}
	public void setLogMac(String logMac) {
		this.logMac = logMac;
	}

	public String getOperateData() {
		return operateData;
	}

	public void setOperateData(String operateData) {
		this.operateData = operateData;
	}
	
	

}
