package com.threefiveninetong.mchh.appPostpartum.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 保存育儿期六岁龄记录
 * @author zhanght
 */
public class PostpartumSixYearRecordSaveReqVo extends BaseReqVo {
	
	@NotEmpty(field="账户ID")
	private String memberId;
	
	@NotEmpty(field="宝宝ID")
	private String babyInfoId;
	
	//做简单家务
	private String simpleHousework;
	
	//分享食物
	private String shareFood;
	
	//遵守游戏规则
	private String complyGameRule;
	
	//写自己名字
	private String writeOwnName;
	
	//表达想法
	private String expressIdeas;
	
	//玩角色扮演游戏
	private String playCosplayGame;
	
	//画方形
	private String drawSquare;
	
	//奔跑
	private String run;

	public String getBabyInfoId() {
		return babyInfoId;
	}

	public void setBabyInfoId(String babyInfoId) {
		this.babyInfoId = babyInfoId;
	}

	public String getSimpleHousework() {
		return simpleHousework;
	}

	public void setSimpleHousework(String simpleHousework) {
		this.simpleHousework = simpleHousework;
	}

	public String getShareFood() {
		return shareFood;
	}

	public void setShareFood(String shareFood) {
		this.shareFood = shareFood;
	}

	public String getComplyGameRule() {
		return complyGameRule;
	}

	public void setComplyGameRule(String complyGameRule) {
		this.complyGameRule = complyGameRule;
	}

	public String getWriteOwnName() {
		return writeOwnName;
	}

	public void setWriteOwnName(String writeOwnName) {
		this.writeOwnName = writeOwnName;
	}

	public String getExpressIdeas() {
		return expressIdeas;
	}

	public void setExpressIdeas(String expressIdeas) {
		this.expressIdeas = expressIdeas;
	}

	public String getPlayCosplayGame() {
		return playCosplayGame;
	}

	public void setPlayCosplayGame(String playCosplayGame) {
		this.playCosplayGame = playCosplayGame;
	}

	public String getDrawSquare() {
		return drawSquare;
	}

	public void setDrawSquare(String drawSquare) {
		this.drawSquare = drawSquare;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
