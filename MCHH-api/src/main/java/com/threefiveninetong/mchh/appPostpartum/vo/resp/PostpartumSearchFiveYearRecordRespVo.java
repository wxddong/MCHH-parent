package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询育儿期五岁龄记录
 * @author zhanght
 */
public class PostpartumSearchFiveYearRecordRespVo extends BaseVo {
	
	//握笔画画
	private String holdPenDraw = "";
	
	//辨别颜色
	private String distinguishColour = "";
	
	//习惯集体生活
	private String habitCollectiveLife = "";
	
	//自己脱衣服
	private String ownDisrobe = "";
	
	//简述事情
	private String briefThings = "";
	
	//知道性别
	private String knowSex = "";
	
	//用筷子
	private String useChopsticks = "";
	
	//单脚跳
	private String singleFootJump = "";

	public String getHoldPenDraw() {
		return holdPenDraw;
	}

	public String getDistinguishColour() {
		return distinguishColour;
	}

	public String getHabitCollectiveLife() {
		return habitCollectiveLife;
	}

	public String getOwnDisrobe() {
		return ownDisrobe;
	}

	public String getBriefThings() {
		return briefThings;
	}

	public String getKnowSex() {
		return knowSex;
	}

	public String getUseChopsticks() {
		return useChopsticks;
	}

	public String getSingleFootJump() {
		return singleFootJump;
	}

	public void setHoldPenDraw(String holdPenDraw) {
		this.holdPenDraw = holdPenDraw;
	}

	public void setDistinguishColour(String distinguishColour) {
		this.distinguishColour = distinguishColour;
	}

	public void setHabitCollectiveLife(String habitCollectiveLife) {
		this.habitCollectiveLife = habitCollectiveLife;
	}

	public void setOwnDisrobe(String ownDisrobe) {
		this.ownDisrobe = ownDisrobe;
	}

	public void setBriefThings(String briefThings) {
		this.briefThings = briefThings;
	}

	public void setKnowSex(String knowSex) {
		this.knowSex = knowSex;
	}

	public void setUseChopsticks(String useChopsticks) {
		this.useChopsticks = useChopsticks;
	}

	public void setSingleFootJump(String singleFootJump) {
		this.singleFootJump = singleFootJump;
	}
}
