package com.threefiveninetong.mchh.appHospital.vo.resp;

/**
 * 特色服务信息
 * @author zhanght
 */
public class CharacteristicServiceVo {
	
	//名称
	private String name;
	
	//小图片URL
	private String smallImageUrl;
	
	//大图片URL
	private String bigImageUrl;
	
	//内容介绍
	private String content;
	
	//排序号
	private String sortNum;

	public String getName() {
		return name;
	}

	public String getSmallImageUrl() {
		return smallImageUrl;
	}

	public String getBigImageUrl() {
		return bigImageUrl;
	}

	public String getContent() {
		return content;
	}

	public String getSortNum() {
		return sortNum;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}

	public void setBigImageUrl(String bigImageUrl) {
		this.bigImageUrl = bigImageUrl;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setSortNum(String sortNum) {
		this.sortNum = sortNum;
	}
}
