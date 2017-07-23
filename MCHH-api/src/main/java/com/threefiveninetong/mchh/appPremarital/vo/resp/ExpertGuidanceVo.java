package com.threefiveninetong.mchh.appPremarital.vo.resp;

/**
 * 专家健康指导信息
 * @author zhanght
 */
public class ExpertGuidanceVo {
	
	//标题
	private String title;
	
	//内容
	private String content;
	
	//小图片URL
	private String smallImageUrl;
	
	//大图片URL
	private String bigImageUrl;
	
	//发布时间
	private String releaseTime;

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

	public String getSmallImageUrl() {
		return smallImageUrl;
	}

	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}

	public String getBigImageUrl() {
		return bigImageUrl;
	}

	public void setBigImageUrl(String bigImageUrl) {
		this.bigImageUrl = bigImageUrl;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
}
