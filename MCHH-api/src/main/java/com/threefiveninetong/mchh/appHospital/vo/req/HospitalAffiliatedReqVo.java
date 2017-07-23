package com.threefiveninetong.mchh.appHospital.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;

/**
 * 会员关联医院
 * @author zhanght
 */
public class HospitalAffiliatedReqVo extends BaseReqVo{
	
	@NotEmpty(field="会员ID")
	private String memberId;
	
	@NotEmpty(field="医院ID")
	private String hospitalId;
	
	//就诊号
	private String treatmentNo;
	
	//档案编号
	private String archivesCode;
	
	//身份证号
	private String idNo;
	
	//医院名称
	private String hospitalName;

	public String getMemberId() {
		return memberId;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public String getTreatmentNo() {
		return treatmentNo;
	}

	public String getArchivesCode() {
		return archivesCode;
	}

	public String getIdNo() {
		return idNo;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public void setTreatmentNo(String treatmentNo) {
		this.treatmentNo = treatmentNo;
	}

	public void setArchivesCode(String archivesCode) {
		this.archivesCode = archivesCode;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
}
