/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppPrenatalSelfRecordSpecialPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appPrenatal.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:50:45 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appPrenatal.po;

import java.io.Serializable;
import java.util.Date;
/**
 * @ClassName: AppPrenatalSelfRecordSpecialPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:50:45 
 */
public class AppPrenatalSelfRecordSpecialPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 孕产自我记录表ID **/ 
	private String fatId;
	
    /** 0：阴道流血 1：腹痛 2：发热 3：剧烈呕吐，不能进食 4：头晕、头痛、视物不清
            5：心慌、憋气 6：血压>=140/90mmHg 7：短时间体重增加过多 8：胎动异常 9：孕周>=41周 **/ 
	private String symptom;
	
    /** 0：取消，1：点亮 **/ 
	private String sign;
	
    /** 创建时间 **/ 
	private Date createTime;
	

	/**
	 * 构造 
	 */
	public AppPrenatalSelfRecordSpecialPO() {
	}
	
	public AppPrenatalSelfRecordSpecialPO( String id,  String fatId, String symptom, String sign, Date createTime) {
				this.fatId = fatId;
				this.symptom = symptom;
				this.sign = sign;
				this.createTime = createTime;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getFatId() {
		return fatId;
	}

	public void setFatId(String fatId) {
		this.fatId = fatId;
	}
}