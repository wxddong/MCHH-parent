package com.threefiveninetong.mchh.appPostpartum.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 保存育儿期五岁龄记录
 * @author zhanght
 */
public class PostpartumFiveYearRecordSaveReqVo extends BaseReqVo {
	
	@NotEmpty(field="账户ID")
	private String memberId;
	
	@NotEmpty(field="宝宝ID")
	private String babyInfoId;
	
	//握笔画画
	private String holdPenDraw;
	
	//辨别颜色
	private String distinguishColour;
	
	//习惯集体生活
	private String habitCollectiveLife;
	
	//自己脱衣服
	private String ownDisrobe;
	
	//简述事情
	private String briefThings;
	
	//知道性别
	private String knowSex;
	
	//用筷子
	private String useChopsticks;
	
	//单脚跳
	private String singleFootJump;
	

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBabyInfoId() {
		return babyInfoId;
	}

	public void setBabyInfoId(String babyInfoId) {
		this.babyInfoId = babyInfoId;
	}

	public String getHoldPenDraw() {
		return holdPenDraw;
	}

	public void setHoldPenDraw(String holdPenDraw) {
		this.holdPenDraw = holdPenDraw;
	}

	public String getDistinguishColour() {
		return distinguishColour;
	}

	public void setDistinguishColour(String distinguishColour) {
		this.distinguishColour = distinguishColour;
	}

	public String getHabitCollectiveLife() {
		return habitCollectiveLife;
	}

	public void setHabitCollectiveLife(String habitCollectiveLife) {
		this.habitCollectiveLife = habitCollectiveLife;
	}

	public String getOwnDisrobe() {
		return ownDisrobe;
	}

	public void setOwnDisrobe(String ownDisrobe) {
		this.ownDisrobe = ownDisrobe;
	}

	public String getBriefThings() {
		return briefThings;
	}

	public void setBriefThings(String briefThings) {
		this.briefThings = briefThings;
	}

	public String getKnowSex() {
		return knowSex;
	}

	public void setKnowSex(String knowSex) {
		this.knowSex = knowSex;
	}

	public String getUseChopsticks() {
		return useChopsticks;
	}

	public void setUseChopsticks(String useChopsticks) {
		this.useChopsticks = useChopsticks;
	}

	public String getSingleFootJump() {
		return singleFootJump;
	}

	public void setSingleFootJump(String singleFootJump) {
		this.singleFootJump = singleFootJump;
	}
}
