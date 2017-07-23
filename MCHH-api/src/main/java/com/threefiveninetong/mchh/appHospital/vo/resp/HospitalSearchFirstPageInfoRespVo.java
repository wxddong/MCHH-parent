package com.threefiveninetong.mchh.appHospital.vo.resp;

import java.util.List;

import com.threefiveninetong.mchh.appMember.vo.resp.MbrMessageVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;

/**
 * 查询医院首页展示信息 
 * @author zhanght
 */
public class HospitalSearchFirstPageInfoRespVo extends BaseVo {
	
	//医院信息ID
	private String hospitalId = "";
	
	//医院名称
	private String hospitalName = "";
	
	//咨询电话
	private String telephone = "";
	
	//大图片URL
	private String bigImageUrl = "";
	
	//简介
	private String brief = "";
	
	private String title = "";
	
	private String content = "";
	
	private String receiveTime = "";
	
	//检查列表
	private List<InspectionReportVo> inspectionReportList;

	public String getHospitalId() {
		return hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getBigImageUrl() {
		return bigImageUrl;
	}

	public String getBrief() {
		return brief;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setBigImageUrl(String bigImageUrl) {
		this.bigImageUrl = bigImageUrl;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public List<InspectionReportVo> getInspectionReportList() {
		return inspectionReportList;
	}

	public void setInspectionReportList(
			List<InspectionReportVo> inspectionReportList) {
		this.inspectionReportList = inspectionReportList;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getReceiveTime() {
		return receiveTime;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}
}
