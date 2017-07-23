package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询育儿期两岁六月龄记录
 * @author zhanght
 */
public class PostpartumSearchTwoYearSixRecordRespVo extends BaseVo {
	
	//说出身体部位数
	private String bodyPartsNum = "";
	
	//出牙数量
	private String teethNum = "";
	
	//是否挑食
	private String picky = "";
	
	//不爱吃
	private String doNotLike = "";
	
	//经常看图画
	private String lookPicture = "";
	
	//会说短语
	private String sayPhrase = "";
	
	//兴趣单一
	private String singleInterest = "";
	
	//会示意大小便
	private String signalToilet = "";
	
	//是否会跑
	private String run = "";

	public String getBodyPartsNum() {
		return bodyPartsNum;
	}

	public void setBodyPartsNum(String bodyPartsNum) {
		this.bodyPartsNum = bodyPartsNum;
	}

	public String getTeethNum() {
		return teethNum;
	}

	public void setTeethNum(String teethNum) {
		this.teethNum = teethNum;
	}

	public String getPicky() {
		return picky;
	}

	public void setPicky(String picky) {
		this.picky = picky;
	}

	public String getDoNotLike() {
		return doNotLike;
	}

	public void setDoNotLike(String doNotLike) {
		this.doNotLike = doNotLike;
	}

	public String getLookPicture() {
		return lookPicture;
	}

	public void setLookPicture(String lookPicture) {
		this.lookPicture = lookPicture;
	}

	public String getSayPhrase() {
		return sayPhrase;
	}

	public void setSayPhrase(String sayPhrase) {
		this.sayPhrase = sayPhrase;
	}

	public String getSingleInterest() {
		return singleInterest;
	}

	public void setSingleInterest(String singleInterest) {
		this.singleInterest = singleInterest;
	}

	public String getSignalToilet() {
		return signalToilet;
	}

	public void setSignalToilet(String signalToilet) {
		this.signalToilet = signalToilet;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}
}
