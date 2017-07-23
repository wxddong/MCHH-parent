/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingEightMonthRecordPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPostpartum.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:09 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPostpartum.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: AppParentingEightMonthRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public class AppParentingEightMonthRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 育儿期基本信息ID **/ 
	private String parId;
	
    /** 给宝宝添加肉类的时间 **/ 
	private Date addMeatTime;
	
    /** 给宝宝添加蛋类的时间 **/ 
	private Date addEggTime;
	
    /** 宝宝出第一颗牙的时间 **/ 
	private Date firstToothTime;
	
    /** 0：否，1：是 **/ 
	private String hideAndSeek;
	
    /** 0：否，1：是 **/ 
	private String soundAnswer;
	
    /** 0：否，1：是 **/ 
	private String distinguishPeople;
	
    /** 0：否，1：是 **/ 
	private String bothHandsToys;
	
    /** 0：否，1：是 **/ 
	private String sitAlone;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppParentingEightMonthRecordPO() {
	}
	
	public AppParentingEightMonthRecordPO( String id,  String parId, Date addMeatTime, Date addEggTime, Date firstToothTime, String hideAndSeek, String soundAnswer, String distinguishPeople, String bothHandsToys, String sitAlone, Date createTime, Date updateTime) {
				this.parId = parId;
				this.addMeatTime = addMeatTime;
				this.addEggTime = addEggTime;
				this.firstToothTime = firstToothTime;
				this.hideAndSeek = hideAndSeek;
				this.soundAnswer = soundAnswer;
				this.distinguishPeople = distinguishPeople;
				this.bothHandsToys = bothHandsToys;
				this.sitAlone = sitAlone;
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
	public Date getAddMeatTime() {
		return addMeatTime;
	}

	public void setAddMeatTime(Date addMeatTime) {
		this.addMeatTime = addMeatTime;
	}
	public Date getAddEggTime() {
		return addEggTime;
	}

	public void setAddEggTime(Date addEggTime) {
		this.addEggTime = addEggTime;
	}
	public Date getFirstToothTime() {
		return firstToothTime;
	}

	public void setFirstToothTime(Date firstToothTime) {
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