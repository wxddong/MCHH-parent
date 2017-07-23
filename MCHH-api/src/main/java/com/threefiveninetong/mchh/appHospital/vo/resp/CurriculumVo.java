package com.threefiveninetong.mchh.appHospital.vo.resp;

/**
 * 课程信息
 * @author zhanght
 */
public class CurriculumVo {

	//开课日期
	private String startDate;
	
	//课程开始时间
	private String startTime;
	
	//课程结束时间
	private String endTime;
	
	//课题
	private String topic;
	
	//课程内容
	private String courseContent;
	
	//主讲人
	private String speaker;

	public String getStartDate() {
		return startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getTopic() {
		return topic;
	}

	public String getCourseContent() {
		return courseContent;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public void setCourseContent(String courseContent) {
		this.courseContent = courseContent;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
}
