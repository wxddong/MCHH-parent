/**   
 * Copyright © 2016 鼎源科技. All rights reserved.
 * @Title: AppMemberPO.java
 * @Prject: MyUniversity-dao
 * @Package: com.threefiveninetong.mchh.appMember.po 
 * @Description: TODO
 * @author: zhouzhao   
 * @date: 2016-10-31 10:31:06 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.appMember.po;

import java.io.Serializable;
import java.util.Date;

import com.threefiveninetong.mchh.appHospital.po.AppAffiliatedHospitalInfoPO;
import com.threefiveninetong.mchh.appHospital.po.AppHospitalInfoPO;




/**
 * @ClassName: AppMemberPO 
 * @Description: TODO
 * @author: zhouzhao
 * @date: 2016-10-31 10:31:06 
 */
public class AppMemberPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 会员ID **/ 
	private String id;
	
    /** 用户名 **/ 
	private String userName;
	
    /** 手机号码 **/ 
	private String phone;
	
    /** 密码 **/ 
	private String pwd;
	
    /** 昵称 **/ 
	private String nickName;
	
    /** 0：女 ；1：男 **/ 
	private String sex;
	
    /** 出生日期(生日) **/ 
	private Date birthday;
	
    /** 会员头像 **/ 
	private String imageUrl;
	
    /** 个性签名 **/ 
	private String signature;
	
    /** 0：O型血，1：A型血，2：B型血，3：AB型血，4：其他 **/ 
	private String bloodType;
	
    /** 真实姓名 **/ 
	private String mbrName;
	
    /** 会员级别  **/ 
	private String stars;
	
    /** 推荐码 **/ 
	private String recommendCode;
	
    /** 手机号码归属地 **/ 
	private String phoneHome;
	
    /** 注册时间 **/ 
	private Date createTime;
	
    /** 完善资料时间 **/ 
	private Date updateTime;
	
    /** 最后登录时间 **/ 
	private Date loginTime;
	
    /** 0：无效； 1：有效 **/ 
	private String status;
	
    /** 0：备孕期，1：孕产期，2：育儿期 **/ 
	private String currentStage;
	
    /** 育儿期--上次操作的儿童ID **/ 
	private String parId;
	
	/**
	 * 会员关联医院表
	 */
	private AppAffiliatedHospitalInfoPO appAffiliatedHospitalInfoPO;

	public AppAffiliatedHospitalInfoPO getAppAffiliatedHospitalInfoPO() {
		return appAffiliatedHospitalInfoPO;
	}

	public void setAppAffiliatedHospitalInfoPO(AppAffiliatedHospitalInfoPO appAffiliatedHospitalInfoPO) {
		this.appAffiliatedHospitalInfoPO = appAffiliatedHospitalInfoPO;
	}

	/**
	 * 构造 
	 */
	public AppMemberPO() {
	}
	
	public AppMemberPO( String id,  String userName, String phone, String pwd, String nickName, String sex, Date birthday, String imageUrl, String signature, String bloodType, String mbrName, String stars, String recommendCode, String phoneHome, Date createTime, Date updateTime, Date loginTime, String status, String currentStage, String parId) {
				this.userName = userName;
				this.phone = phone;
				this.pwd = pwd;
				this.nickName = nickName;
				this.sex = sex;
				this.birthday = birthday;
				this.imageUrl = imageUrl;
				this.signature = signature;
				this.bloodType = bloodType;
				this.mbrName = mbrName;
				this.stars = stars;
				this.recommendCode = recommendCode;
				this.phoneHome = phoneHome;
				this.createTime = createTime;
				this.updateTime = updateTime;
				this.loginTime = loginTime;
				this.status = status;
				this.currentStage = currentStage;
				this.parId = parId;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getMbrName() {
		return mbrName;
	}

	public void setMbrName(String mbrName) {
		this.mbrName = mbrName;
	}
	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}
	public String getRecommendCode() {
		return recommendCode;
	}

	public void setRecommendCode(String recommendCode) {
		this.recommendCode = recommendCode;
	}
	public String getPhoneHome() {
		return phoneHome;
	}

	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
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
	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getCurrentStage() {
		return currentStage;
	}

	public void setCurrentStage(String currentStage) {
		this.currentStage = currentStage;
	}
	public String getParId() {
		return parId;
	}

	public void setParId(String parId) {
		this.parId = parId;
	}

}