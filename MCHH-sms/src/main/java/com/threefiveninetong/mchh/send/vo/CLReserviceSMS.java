package com.threefiveninetong.mchh.send.vo;

public class CLReserviceSMS implements java.io.Serializable {
//	<sms>
//	<id>749423</id>
//	<type>1</type>
//	<time>Thu, 28 Jun 2012 01:27:26 GMT</time>
//	<mobile>18210057468</mobile>
//	<content>�ã�лл��������</content>
//	</sms>

	public String id;
	public String type;
	public String time;
	public String mobile;
	public String content;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
