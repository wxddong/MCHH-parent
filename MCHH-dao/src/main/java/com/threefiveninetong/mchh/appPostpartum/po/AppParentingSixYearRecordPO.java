/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingSixYearRecordPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPostpartum.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:10 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPostpartum.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: AppParentingSixYearRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:10 
 */
public class AppParentingSixYearRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 育儿期基本信息ID **/ 
	private String parId;
	
    /** 0：否，1：是 **/ 
	private String simpleHousework;
	
    /** 0：否，1：是 **/ 
	private String shareFood;
	
    /** 0：否，1：是 **/ 
	private String complyGameRule;
	
    /** 0：否，1：是 **/ 
	private String writeOwnName;
	
    /** 0：否，1：是 **/ 
	private String expressIdeas;
	
    /** 0：否，1：是 **/ 
	private String playCosplayGame;
	
    /** 0：否，1：是 **/ 
	private String drawSquare;
	
    /** 0：否，1：是 **/ 
	private String run;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppParentingSixYearRecordPO() {
	}
	
	public AppParentingSixYearRecordPO( String id,  String parId, String simpleHousework, String shareFood, String complyGameRule, String writeOwnName, String expressIdeas, String playCosplayGame, String drawSquare, String run, Date createTime, Date updateTime) {
				this.parId = parId;
				this.simpleHousework = simpleHousework;
				this.shareFood = shareFood;
				this.complyGameRule = complyGameRule;
				this.writeOwnName = writeOwnName;
				this.expressIdeas = expressIdeas;
				this.playCosplayGame = playCosplayGame;
				this.drawSquare = drawSquare;
				this.run = run;
				this.createTime = createTime;
				this.updateTime = updateTime;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParId() {
		return parId;
	}

	public void setParId(String parId) {
		this.parId = parId;
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
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}