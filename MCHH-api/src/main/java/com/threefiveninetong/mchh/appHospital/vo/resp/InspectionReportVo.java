package com.threefiveninetong.mchh.appHospital.vo.resp;

/**
 * 检查信息
 * @author zhanght
 */
public class InspectionReportVo {
	
	//报告标题
	private String title;
	
	//报告内容
	private String content;
	
	//收到时间
	private String receiveTime;
	
	//报告图片url
	private String imageUrl;

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getReceiveTime() {
		return receiveTime;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
