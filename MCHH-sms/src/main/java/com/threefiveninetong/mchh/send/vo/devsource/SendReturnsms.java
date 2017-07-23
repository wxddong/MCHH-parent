package com.threefiveninetong.mchh.send.vo.devsource;

public class SendReturnsms extends BaseReturnsms{

	private String remainpoint;
	private String taskID;
	private String successCounts;
	
	public String getRemainpoint() {
		return remainpoint;
	}
	public void setRemainpoint(String remainpoint) {
		this.remainpoint = remainpoint;
	}
	public String getTaskID() {
		return taskID;
	}
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	public String getSuccessCounts() {
		return successCounts;
	}
	public void setSuccessCounts(String successCounts) {
		this.successCounts = successCounts;
	}

}
