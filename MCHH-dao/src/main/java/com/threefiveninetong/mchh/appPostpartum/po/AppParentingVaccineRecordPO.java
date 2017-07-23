/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingVaccineRecordPO.java
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
 * @ClassName: AppParentingVaccineRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public class AppParentingVaccineRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 育儿期基本信息ID **/ 
	private String parId;
	
    /** 0：乙肝疫苗，
            1：卡介苗，
            2：脊灰减毒活疫苗，
            3：百白破疫苗 **/ 
	private String vaccineType;
	
    /** 记录时间 **/ 
	private Date createTime;
	

	/**
	 * 构造 
	 */
	public AppParentingVaccineRecordPO() {
	}
	
	public AppParentingVaccineRecordPO( String id,  String parId, String vaccineType, Date createTime) {
				this.parId = parId;
				this.vaccineType = vaccineType;
				this.createTime = createTime;
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
	public String getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}