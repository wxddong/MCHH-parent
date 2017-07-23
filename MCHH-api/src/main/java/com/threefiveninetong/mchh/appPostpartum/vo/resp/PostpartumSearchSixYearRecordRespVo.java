package com.threefiveninetong.mchh.appPostpartum.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询育儿期六岁龄记录
 * @author zhanght
 */
public class PostpartumSearchSixYearRecordRespVo extends BaseVo {
	
	//做简单家务
	private String simpleHousework = "";
	
	//分享食物
	private String shareFood = "";
	
	//遵守游戏规则
	private String complyGameRule = "";
	
	//写自己名字
	private String writeOwnName = "";
	
	//表达想法
	private String expressIdeas = "";
	
	//玩角色扮演游戏
	private String playCosplayGame = "";
	
	//画方形
	private String drawSquare = "";
	
	//奔跑
	private String run = "";

	public String getSimpleHousework() {
		return simpleHousework;
	}

	public String getShareFood() {
		return shareFood;
	}

	public String getComplyGameRule() {
		return complyGameRule;
	}

	public String getWriteOwnName() {
		return writeOwnName;
	}

	public String getExpressIdeas() {
		return expressIdeas;
	}

	public String getPlayCosplayGame() {
		return playCosplayGame;
	}

	public String getDrawSquare() {
		return drawSquare;
	}

	public String getRun() {
		return run;
	}

	public void setSimpleHousework(String simpleHousework) {
		this.simpleHousework = simpleHousework;
	}

	public void setShareFood(String shareFood) {
		this.shareFood = shareFood;
	}

	public void setComplyGameRule(String complyGameRule) {
		this.complyGameRule = complyGameRule;
	}

	public void setWriteOwnName(String writeOwnName) {
		this.writeOwnName = writeOwnName;
	}

	public void setExpressIdeas(String expressIdeas) {
		this.expressIdeas = expressIdeas;
	}

	public void setPlayCosplayGame(String playCosplayGame) {
		this.playCosplayGame = playCosplayGame;
	}

	public void setDrawSquare(String drawSquare) {
		this.drawSquare = drawSquare;
	}

	public void setRun(String run) {
		this.run = run;
	}
}
