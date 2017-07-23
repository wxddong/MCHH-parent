package com.threefiveninetong.mchh.appPrenatal.vo.resp;

/**
 * 孕产期胎动信息
 * @author zhanght
 */
public class FetalMovementVo {
	
	//胎动次数
	private String moveNum;
	
	//记录时间
	private String createTime;

	public String getMoveNum() {
		return moveNum;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setMoveNum(String moveNum) {
		this.moveNum = moveNum;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
