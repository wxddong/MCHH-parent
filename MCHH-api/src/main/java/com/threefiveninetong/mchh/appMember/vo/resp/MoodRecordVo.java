package com.threefiveninetong.mchh.appMember.vo.resp;

/**
 * 心情语录实体
 * @author zhanght
 */
public class MoodRecordVo {
	
	//语录ID
	private String moodId;
	
	//语录内容
	private String content;
	
	//所处阶段 0-备孕期  1-孕产期  2-育儿期
	private String type;
	
	//创建时间
	private String createTime;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getMoodId() {
		return moodId;
	}

	public void setMoodId(String moodId) {
		this.moodId = moodId;
	}
}
