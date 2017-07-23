/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppParentingBabyDentitionRecordPO.java
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
 * @ClassName: AppParentingBabyDentitionRecordPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:09 
 */
public class AppParentingBabyDentitionRecordPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 育儿期基本信息ID **/ 
	private String parId;
	
    /** 0：左1
            1：左2
            2：左3
            3：左4
            4：左5
            5：左6
            6：左7
            7：左8
            8：左9
            9：左10
            10：右1
            11：右2
            12：右3
            13：右4
            14：右5
            15：右6
            16：右7
            17：右8
            18：右9
            19：右10
            
             **/ 
	private String position;
	
    /** 出牙日期 **/ 
	private Date toothingDate;
	
    /** 记录时间 **/ 
	private Date createTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	

	/**
	 * 构造 
	 */
	public AppParentingBabyDentitionRecordPO() {
	}
	
	public AppParentingBabyDentitionRecordPO( String id,  String parId, String position, Date toothingDate, Date createTime, Date updateTime) {
				this.parId = parId;
				this.position = position;
				this.toothingDate = toothingDate;
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
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	public Date getToothingDate() {
		return toothingDate;
	}

	public void setToothingDate(Date toothingDate) {
		this.toothingDate = toothingDate;
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