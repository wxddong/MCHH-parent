package com.threefiveninetong.mchh.appMember.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询会员的详细信息
 * @author zhanght
 */
public class MemberSearchBasicInfoRespVo extends BaseVo {
	
	//头像图片地址
	private String imageUrl = "";
	
	//用户名
	private String userName = "";
	
	//昵称
	private String nickName = "";
	
	//性别
	private String sex = "";
	
	//血型
	private String bloodType = "";
	
	//生日
	private String birthday = "";
	
	//个性签名
	private String signature = "";

	public String getImageUrl() {
		return imageUrl;
	}

	public String getUserName() {
		return userName;
	}

	public String getNickName() {
		return nickName;
	}

	public String getSex() {
		return sex;
	}

	public String getBloodType() {
		return bloodType;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getSignature() {
		return signature;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
}
