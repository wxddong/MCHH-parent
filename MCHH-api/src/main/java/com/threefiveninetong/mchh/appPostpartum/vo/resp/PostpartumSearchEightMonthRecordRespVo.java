package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询育儿期八月龄记录
 * @author zhanght
 */
public class PostpartumSearchEightMonthRecordRespVo extends BaseVo {
	
	//添加肉类时间
	private String addMeatTime = "";
	
	//添加蛋类时间
	private String addEggTime = "";
	
	//第一颗牙时间
	private String firstToothTime = "";
	
	//是否玩躲猫猫
	private String hideAndSeek = "";
	
	//听见声有应答
	private String soundAnswer = "";
	
	//区分生人熟人
	private String distinguishPeople = "";
	
	//双手传递玩具
	private String bothHandsToys = "";
	
	//会独坐
	private String sitAlone = "";

	public String getAddMeatTime() {
		return addMeatTime;
	}

	public void setAddMeatTime(String addMeatTime) {
		this.addMeatTime = addMeatTime;
	}

	public String getAddEggTime() {
		return addEggTime;
	}

	public void setAddEggTime(String addEggTime) {
		this.addEggTime = addEggTime;
	}

	public String getFirstToothTime() {
		return firstToothTime;
	}

	public void setFirstToothTime(String firstToothTime) {
		this.firstToothTime = firstToothTime;
	}

	public String getHideAndSeek() {
		return hideAndSeek;
	}

	public void setHideAndSeek(String hideAndSeek) {
		this.hideAndSeek = hideAndSeek;
	}

	public String getSoundAnswer() {
		return soundAnswer;
	}

	public void setSoundAnswer(String soundAnswer) {
		this.soundAnswer = soundAnswer;
	}

	public String getDistinguishPeople() {
		return distinguishPeople;
	}

	public void setDistinguishPeople(String distinguishPeople) {
		this.distinguishPeople = distinguishPeople;
	}

	public String getBothHandsToys() {
		return bothHandsToys;
	}

	public void setBothHandsToys(String bothHandsToys) {
		this.bothHandsToys = bothHandsToys;
	}

	public String getSitAlone() {
		return sitAlone;
	}

	public void setSitAlone(String sitAlone) {
		this.sitAlone = sitAlone;
	}
}
