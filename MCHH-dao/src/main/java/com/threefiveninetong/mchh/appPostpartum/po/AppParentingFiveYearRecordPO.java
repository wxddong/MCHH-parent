/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingFiveYearRecordPO.java
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
 * @ClassName: AppParentingFiveYearRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:10 
 */
public class AppParentingFiveYearRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 育儿期基本信息ID **/ 
	private String parId;
	
    /** 0：否，1：是 **/ 
	private String holdPenDraw;
	
    /** 0：否，1：是 **/ 
	private String distinguishColour;
	
    /** 0：否，1：是 **/ 
	private String habitCollectiveLife;
	
    /** 0：否，1：是 **/ 
	private String ownDisrobe;
	
    /** 0：否，1：是 **/ 
	private String briefThings;
	
    /** 0：否，1：是 **/ 
	private String knowSex;
	
    /** 0：否，1：是 **/ 
	private String useChopsticks;
	
    /** 0：否，1：是 **/ 
	private String singleFootJump;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppParentingFiveYearRecordPO() {
	}
	
	public AppParentingFiveYearRecordPO( String id,  String parId, String holdPenDraw, String distinguishColour, String habitCollectiveLife, String ownDisrobe, String briefThings, String knowSex, String useChopsticks, String singleFootJump, Date createTime, Date updateTime) {
				this.parId = parId;
				this.holdPenDraw = holdPenDraw;
				this.distinguishColour = distinguishColour;
				this.habitCollectiveLife = habitCollectiveLife;
				this.ownDisrobe = ownDisrobe;
				this.briefThings = briefThings;
				this.knowSex = knowSex;
				this.useChopsticks = useChopsticks;
				this.singleFootJump = singleFootJump;
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