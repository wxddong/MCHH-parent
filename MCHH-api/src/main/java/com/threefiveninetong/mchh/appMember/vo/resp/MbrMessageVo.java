package com.threefiveninetong.mchh.appMember.vo.resp;

/**
 * 查询会员接受的通知
 * @author zhanght
 */
public class MbrMessageVo {
	
	//消息标题
	private String title;
	
	//消息内容
	private String content;
	
	//收到时间
	private String receiveTime;
	
	//消息类型  0-医院通知  1-系统通知
	private String type;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
