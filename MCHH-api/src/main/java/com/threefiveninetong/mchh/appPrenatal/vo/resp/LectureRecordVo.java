package com.threefiveninetong.mchh.appPrenatal.vo.resp;

/**
 * 听课记录
 * @author zhanght
 */
public class LectureRecordVo {

	//课目
	private String subjects;
	
	//内容
	private String content;
	
	//听课时间
	private String lectureTime;
	
	//备注
	private String remark;
	
	//记录时间
	private String createTime;

	public String getSubjects() {
		return subjects;
	}

	public String getContent() {
		return content;
	}

	public String getLectureTime() {
		return lectureTime;
	}

	public String getRemark() {
		return remark;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setLectureTime(String lectureTime) {
		this.lectureTime = lectureTime;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
