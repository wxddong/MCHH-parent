/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PremaritalAbnormalOptionPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.config.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:35 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.config.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: PremaritalAbnormalOptionPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:35 
 */
public class PremaritalAbnormalOptionPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 名称 **/ 
	private String name;
	
    /** 0：指定传染病
            1：严重遗传病
            2：精神病
            3：生殖系统疾病
            4：内科疾病 **/ 
	private String type;
	
    /** 备注描述 **/ 
	private String remark;
	
    /** 创建时间 **/ 
	private Date creatTime;
	
    /** 最后修改时间 **/ 
	private Date updateTime;
	
	private String selected;
	

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	/**
	 * 构造 
	 */
	public PremaritalAbnormalOptionPO() {
	}
	
	public PremaritalAbnormalOptionPO( String id,  String name, String type, String remark, Date creatTime, Date updateTime) {
				this.name = name;
				this.type = type;
				this.remark = remark;
				this.creatTime = creatTime;
				this.updateTime = updateTime;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}