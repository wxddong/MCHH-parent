package com.threefiveninetong.mchh.appMember.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;
/**
 * 会员登录响应参数
 * @author zhanght
 */
public class MemberLoginRespVo extends BaseVo {
	
	//会员ID
	private String memberId = "";
	
	//会员当前所处阶段：0-备孕期  1-孕产期  2-育儿期
	private String currentStage = "";
	
	//育儿期时的儿童ID
	private String parId = "";
	
	//昵称
	private String nickName = "";
	
	//头像
	private String imageUrl = "";

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
