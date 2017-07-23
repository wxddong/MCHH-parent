package com.threefiveninetong.mchh.send.vo;

public class CLStatusInfo implements java.io.Serializable{

//	<status>
//	<id>5406731</id>
//	<request_time>Wed, 27 Jun 2012 09:05:12 GMT</request_time>
//	<process_flag>2</process_flag>
//	<process_time>Wed, 27 Jun 2012 09:05:13 GMT</process_time>
//	<success>1</success>
//	<count>1</count>
//	<memo></memo>
//	</status>
	public String id;
	public String  requestTime;
	public String processFlag;//// 0: �յ����� ; 1: ׼������ ; 2: �������
	public String processTime;
	public String success;// 1: �ɹ� ; 0: ʧ��
	public String count;
	public String memo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	public String getProcessFlag() {
		return processFlag;
	}
	public void setProcessFlag(String processFlag) {
		this.processFlag = processFlag;
	}
	public String getProcessTime() {
		return processTime;
	}
	public void setProcessTime(String processTime) {
		this.processTime = processTime;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	
	
}
