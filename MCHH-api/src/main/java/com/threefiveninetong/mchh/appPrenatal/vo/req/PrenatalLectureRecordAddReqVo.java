package com.threefiveninetong.mchh.appPrenatal.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 添加孕产期孕妇学校听课记录
 * @author zhanght
 */
public class PrenatalLectureRecordAddReqVo extends BaseReqVo {
	
	@NotEmpty(field="会员ID")
	private String memberId;
	
	@NotEmpty(field="科目")
	private String subjects;
	
	@NotEmpty(field="内容")
	private String content;
	
	@NotEmpty(field="听课时间")
	private String lectureTime;
	
	private String remark;

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLectureTime() {
		return lectureTime;
	}

	public void setLectureTime(String lectureTime) {
		this.lectureTime = lectureTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
