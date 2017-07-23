/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: SupplementaryExamInfoPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.prenatal.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:38 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.prenatal.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: SupplementaryExamInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:38 
 */
public class SupplementaryExamInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 产前检查ID **/ 
	private String examinationId;
	
    /** 血红蛋白 **/ 
	private String hemoglobin;
	
    /** 白细胞 **/ 
	private String leucocyte;
	
    /** 血小板 **/ 
	private String platelet;
	
    /** 血常规其他 **/ 
	private String bloodOthers;
	
    /** 尿蛋白 **/ 
	private String proteinuria;
	
    /** 尿糖 **/ 
	private String urineSugar;
	
    /** 尿酮体 **/ 
	private String ketone;
	
    /** 尿潜血 **/ 
	private String urineBlood;
	
    /** 尿常规其他 **/ 
	private String urineOthers;
	
    /** 0：A型，1：B型，2：AB型，3：O型 **/ 
	private String bloodType;
	
    /** 0：RH+，1：RH- **/ 
	private String bloodTypeRh;
	
    /** 血糖 **/ 
	private String bloodGlucose;
	
    /** 血清谷丙转氨酶 **/ 
	private String sgpt;
	
    /** 血清谷草转氨酶 **/ 
	private String sgot;
	
    /** 白蛋白 **/ 
	private String albumin;
	
    /** 总胆红素 **/ 
	private String totalBilirubin;
	
    /** 结合胆红素 **/ 
	private String dbil;
	
    /** 血清肌酐 **/ 
	private String scr;
	
    /** 血尿素氮 **/ 
	private String bun;
	
    /** 0：未见异常，1：滴虫，2：假丝酵母菌，3：其他
            多个使用;号分隔，女性填写 **/ 
	private String vaginalFluid;
	
    /** 阴道分泌物为其他（3）时填写，女性填写 **/ 
	private String vaginalFluidOthers;
	
    /** 0：Ⅰ度，
            1：Ⅱ度，
            2：Ⅲ度，
            3：Ⅳ度
            ，女性填写 **/ 
	private String vaginalClean;
	
    /** 0：阴性，1：阳性 **/ 
	private String hbsag;
	
    /** 0：阴性，1：阳性 **/ 
	private String hbsab;
	
    /** 0：阴性，1：阳性 **/ 
	private String hbcab;
	
    /** 0：阴性，1：阳性 **/ 
	private String hbeab;
	
    /** 0：阴性，1：阳性 **/ 
	private String hbeag;
	
    /** 0：阴性，1：阳性 **/ 
	private String syphilisSerology;
	
    /** 0：阴性，1：阳性 **/ 
	private String hivab;
	
    /** 0：未检查
            1：无异常
            2：有异常 **/ 
	private String bscan;
	
    /** B超为有异常（2）时填写 **/ 
	private String bscanRemark;
	
    /** 0：未检查
            1：无异常
            2：有异常 **/ 
	private String tangSyndrome;
	
    /** 唐筛为有异常（2）时填写 **/ 
	private String tangSyndromeRemark;
	
    /** 0：未检查
            1：无异常
            2：有异常 **/ 
	private String fourDimensional;
	
    /** 四维为有异常（2）时填写 **/ 
	private String fourDimensionalRemark;
	
    /** 0：未检查
            1：无异常
            2：有异常 **/ 
	private String nt;
	
    /** NT为有异常（2）时填写 **/ 
	private String ntRemark;
	
    /** 0：未检查
            1：无异常
            2：有异常 **/ 
	private String nst;
	
    /** NST为有异常（2）时填写 **/ 
	private String nstRemark;
	
    /** 辅助检查其他 **/ 
	private String others;
	

	/**
	 * 构造 
	 */
	public SupplementaryExamInfoPO() {
	}
	
	public SupplementaryExamInfoPO( String id,  String examinationId, String hemoglobin, String leucocyte, String platelet, String bloodOthers, String proteinuria, String urineSugar, String ketone, String urineBlood, String urineOthers, String bloodType, String bloodTypeRh, String bloodGlucose, String sgpt, String sgot, String albumin, String totalBilirubin, String dbil, String scr, String bun, String vaginalFluid, String vaginalFluidOthers, String vaginalClean, String hbsag, String hbsab, String hbcab, String hbeab, String hbeag, String syphilisSerology, String hivab, String bscan, String bscanRemark, String tangSyndrome, String tangSyndromeRemark, String fourDimensional, String fourDimensionalRemark, String nt, String ntRemark, String nst, String nstRemark, String others) {
				this.examinationId = examinationId;
				this.hemoglobin = hemoglobin;
				this.leucocyte = leucocyte;
				this.platelet = platelet;
				this.bloodOthers = bloodOthers;
				this.proteinuria = proteinuria;
				this.urineSugar = urineSugar;
				this.ketone = ketone;
				this.urineBlood = urineBlood;
				this.urineOthers = urineOthers;
				this.bloodType = bloodType;
				this.bloodTypeRh = bloodTypeRh;
				this.bloodGlucose = bloodGlucose;
				this.sgpt = sgpt;
				this.sgot = sgot;
				this.albumin = albumin;
				this.totalBilirubin = totalBilirubin;
				this.dbil = dbil;
				this.scr = scr;
				this.bun = bun;
				this.vaginalFluid = vaginalFluid;
				this.vaginalFluidOthers = vaginalFluidOthers;
				this.vaginalClean = vaginalClean;
				this.hbsag = hbsag;
				this.hbsab = hbsab;
				this.hbcab = hbcab;
				this.hbeab = hbeab;
				this.hbeag = hbeag;
				this.syphilisSerology = syphilisSerology;
				this.hivab = hivab;
				this.bscan = bscan;
				this.bscanRemark = bscanRemark;
				this.tangSyndrome = tangSyndrome;
				this.tangSyndromeRemark = tangSyndromeRemark;
				this.fourDimensional = fourDimensional;
				this.fourDimensionalRemark = fourDimensionalRemark;
				this.nt = nt;
				this.ntRemark = ntRemark;
				this.nst = nst;
				this.nstRemark = nstRemark;
				this.others = others;
						this.id = id;
			}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(String examinationId) {
		this.examinationId = examinationId;
	}
	public String getHemoglobin() {
		return hemoglobin;
	}

	public void setHemoglobin(String hemoglobin) {
		this.hemoglobin = hemoglobin;
	}
	public String getLeucocyte() {
		return leucocyte;
	}

	public void setLeucocyte(String leucocyte) {
		this.leucocyte = leucocyte;
	}
	public String getPlatelet() {
		return platelet;
	}

	public void setPlatelet(String platelet) {
		this.platelet = platelet;
	}
	public String getBloodOthers() {
		return bloodOthers;
	}

	public void setBloodOthers(String bloodOthers) {
		this.bloodOthers = bloodOthers;
	}
	public String getProteinuria() {
		return proteinuria;
	}

	public void setProteinuria(String proteinuria) {
		this.proteinuria = proteinuria;
	}
	public String getUrineSugar() {
		return urineSugar;
	}

	public void setUrineSugar(String urineSugar) {
		this.urineSugar = urineSugar;
	}
	public String getKetone() {
		return ketone;
	}

	public void setKetone(String ketone) {
		this.ketone = ketone;
	}
	public String getUrineBlood() {
		return urineBlood;
	}

	public void setUrineBlood(String urineBlood) {
		this.urineBlood = urineBlood;
	}
	public String getUrineOthers() {
		return urineOthers;
	}

	public void setUrineOthers(String urineOthers) {
		this.urineOthers = urineOthers;
	}
	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getBloodTypeRh() {
		return bloodTypeRh;
	}

	public void setBloodTypeRh(String bloodTypeRh) {
		this.bloodTypeRh = bloodTypeRh;
	}
	public String getBloodGlucose() {
		return bloodGlucose;
	}

	public void setBloodGlucose(String bloodGlucose) {
		this.bloodGlucose = bloodGlucose;
	}
	public String getSgpt() {
		return sgpt;
	}

	public void setSgpt(String sgpt) {
		this.sgpt = sgpt;
	}
	public String getSgot() {
		return sgot;
	}

	public void setSgot(String sgot) {
		this.sgot = sgot;
	}
	public String getAlbumin() {
		return albumin;
	}

	public void setAlbumin(String albumin) {
		this.albumin = albumin;
	}
	public String getTotalBilirubin() {
		return totalBilirubin;
	}

	public void setTotalBilirubin(String totalBilirubin) {
		this.totalBilirubin = totalBilirubin;
	}
	public String getDbil() {
		return dbil;
	}

	public void setDbil(String dbil) {
		this.dbil = dbil;
	}
	public String getScr() {
		return scr;
	}

	public void setScr(String scr) {
		this.scr = scr;
	}
	public String getBun() {
		return bun;
	}

	public void setBun(String bun) {
		this.bun = bun;
	}
	public String getVaginalFluid() {
		return vaginalFluid;
	}

	public void setVaginalFluid(String vaginalFluid) {
		this.vaginalFluid = vaginalFluid;
	}
	public String getVaginalFluidOthers() {
		return vaginalFluidOthers;
	}

	public void setVaginalFluidOthers(String vaginalFluidOthers) {
		this.vaginalFluidOthers = vaginalFluidOthers;
	}
	public String getVaginalClean() {
		return vaginalClean;
	}

	public void setVaginalClean(String vaginalClean) {
		this.vaginalClean = vaginalClean;
	}
	public String getHbsag() {
		return hbsag;
	}

	public void setHbsag(String hbsag) {
		this.hbsag = hbsag;
	}
	public String getHbsab() {
		return hbsab;
	}

	public void setHbsab(String hbsab) {
		this.hbsab = hbsab;
	}
	public String getHbcab() {
		return hbcab;
	}

	public void setHbcab(String hbcab) {
		this.hbcab = hbcab;
	}
	public String getHbeab() {
		return hbeab;
	}

	public void setHbeab(String hbeab) {
		this.hbeab = hbeab;
	}
	public String getHbeag() {
		return hbeag;
	}

	public void setHbeag(String hbeag) {
		this.hbeag = hbeag;
	}
	public String getSyphilisSerology() {
		return syphilisSerology;
	}

	public void setSyphilisSerology(String syphilisSerology) {
		this.syphilisSerology = syphilisSerology;
	}
	public String getHivab() {
		return hivab;
	}

	public void setHivab(String hivab) {
		this.hivab = hivab;
	}
	public String getBscan() {
		return bscan;
	}

	public void setBscan(String bscan) {
		this.bscan = bscan;
	}
	public String getBscanRemark() {
		return bscanRemark;
	}

	public void setBscanRemark(String bscanRemark) {
		this.bscanRemark = bscanRemark;
	}
	public String getTangSyndrome() {
		return tangSyndrome;
	}

	public void setTangSyndrome(String tangSyndrome) {
		this.tangSyndrome = tangSyndrome;
	}
	public String getTangSyndromeRemark() {
		return tangSyndromeRemark;
	}

	public void setTangSyndromeRemark(String tangSyndromeRemark) {
		this.tangSyndromeRemark = tangSyndromeRemark;
	}
	public String getFourDimensional() {
		return fourDimensional;
	}

	public void setFourDimensional(String fourDimensional) {
		this.fourDimensional = fourDimensional;
	}
	public String getFourDimensionalRemark() {
		return fourDimensionalRemark;
	}

	public void setFourDimensionalRemark(String fourDimensionalRemark) {
		this.fourDimensionalRemark = fourDimensionalRemark;
	}
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	public String getNtRemark() {
		return ntRemark;
	}

	public void setNtRemark(String ntRemark) {
		this.ntRemark = ntRemark;
	}
	public String getNst() {
		return nst;
	}

	public void setNst(String nst) {
		this.nst = nst;
	}
	public String getNstRemark() {
		return nstRemark;
	}

	public void setNstRemark(String nstRemark) {
		this.nstRemark = nstRemark;
	}
	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

}