/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: PhysiqueExaInfoVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.premarital.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-19 11:33:33 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: PhysiqueExaInfovo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-19 11:33:33 
 */
public class PhysiqueExaInfoVO {

	/** 主键ID **/ 
	private String id;
	
    /** 婚检表ID **/ 
	private String marriageTaId;
	
    /** 血压高值 **/ 
	private String bloodHi;
	
    /** 血压低值 **/ 
	private String bloodLow;
	
    /** 0：A型，1：B型，2：AB型，3：O型 **/ 
	private String bloodType;
	
    /** 0：RH+，1：RH- **/ 
	private String yinYang;
	
    /** 0：无，1：有 **/ 
	private String specialPosture;
	
    /** 特殊体态为有（1）时填写 **/ 
	private String postureRemark;
	
    /** 0：无，1：有 **/ 
	private String specialFace;
	
    /** 特殊面容为有（1）时填写 **/ 
	private String faceRemark;
	
    /** 0：正常，1：异常 **/ 
	private String mentalState;
	
    /** 精神状态为异常（1）时填写 **/ 
	private String stateRemark;
	
    /** 0：正常，1：异常 **/ 
	private String intelligence;
	
    /** 智力为异常（1）时填写，0：常识，1：判断，2：记忆，3：计算，4：其他 **/ 
	private String exceptionTypes;
	
    /** 0：正常，1：异常 **/ 
	private String skinHair;
	
    /** 皮肤毛发为异常（1）时填写 **/ 
	private String skinHairNote;
	
    /** 0：正常，1：异常 **/ 
	private String facialFeatures;
	
    /** 五官为异常（1）时填写 **/ 
	private String facialFeaturesRemark;
	
    /** 0：正常，1：异常 **/ 
	private String thyroidGland;
	
    /** 甲状腺为异常（1）时填写 **/ 
	private String thyroidGlandRemark;
	
    /** 心率 **/ 
	private String heartRate;
	
    /** 0：齐，1：过速，2：过缓，3：不齐，4：其他 **/ 
	private String heartRhythm;
	
    /** 心律为其他（1）时填写 **/ 
	private String heartRhythmRemark;
	
    /** 0：无，1：有 **/ 
	private String noise;
	
    /** 杂音为有（1）时填写 **/ 
	private String noiseRemark;
	
    /** 0：正常，1：异常 **/ 
	private String lung;
	
    /** 肺为异常（1）时填写 **/ 
	private String lungRemark;
	
    /** 0：未及，1：可及 **/ 
	private String liver;
	
    /** 肝为可及（1）时填写 **/ 
	private String liverRemark;
	
    /** 0：正常，1：异常 **/ 
	private String limbs;
	
    /** 四肢脊柱为异常（1）时填写 **/ 
	private String limbsRemark;
	
    /** 其他 **/ 
	private String others;
	
    /** 0：无，1：有，男性填写 **/ 
	private String throat;
	
    /** 0：正常，1：稀少，2：无 **/ 
	private String pubicHair;
	
    /** 0：正常，1：异常 **/ 
	private String breast;
	
    /** 乳房为异常（1）时填写 **/ 
	private String breastRemark;
	
    /** 0：正常，1：异常 **/ 
	private String anusVulva;
	
    /** 肛查外阴为异常（1）时填写 **/ 
	private String anusVulvaRemark;
	
    /** 0：正常，1：异常 **/ 
	private String secretions;
	
    /** 分泌物为异常（1）时填写 **/ 
	private String secretionsRemark;
	
    /** 0：正常，1：异常 **/ 
	private String vulvaVagina;
	
    /** 阴道检查外阴为异常（1）时填写 **/ 
	private String vulvaVaginaRemark;
	
    /** 0：正常，1：异常 **/ 
	private String vulva;
	
    /** 外阴为异常（1）时填写 **/ 
	private String vulvaRemark;
	
    /** 0：正常，1：异常 **/ 
	private String vagina;
	
    /** 肛查外阴为异常（1）时填写 **/ 
	private String vaginaRemark;
	
    /** 0：正常，1：异常 **/ 
	private String cervical;
	
    /** 肛查外阴为异常（1）时填写 **/ 
	private String cervicalRemark;
	
    /** 0：正常，1：异常 **/ 
	private String uterus;
	
    /** 肛查外阴为异常（1）时填写 **/ 
	private String uterusRemark;
	
    /** 0：正常，1：异常 **/ 
	private String attachment;
	
    /** 肛查外阴为异常（1）时填写 **/ 
	private String attachmentRemark;
	
    /** 子宫附件其他 **/ 
	private String attachmentOther;
	
    /** 0：同意，1：拒绝 **/ 
	private String vaginalExamination;
	
    /** 0：正常，1：异常，男性填写 **/ 
	private String penis;
	
    /** 阴茎备注，男性填写 **/ 
	private String penisRemark;
	
    /** 0：正常，1：过长，2：包茎，男性填写 **/ 
	private String foreskin;
	
    /** 0：是，1：否，男性填写 **/ 
	private String bilateralTesticular;
	
    /** 睾丸左体积，男性填写 **/ 
	private String leftTestis;
	
    /** 睾丸右体积，男性填写 **/ 
	private String rightTestis;
	
    /** 0：左1：右，男性填写 **/ 
	private String without;
	
    /** 0：是，1：否，男性填写 **/ 
	private String normalEpididymis;
	
    /** 左结节，男性填写 **/ 
	private String leftNodules;
	
    /** 右结节，男性填写 **/ 
	private String rihgtNodules;
	
    /** 0：无，1：有，男性填写 **/ 
	private String varicocele;
	
    /** 曲张部位，男性填写 **/ 
	private String varicoseParts;
	
    /** 曲张程度，男性填写 **/ 
	private String degree;
	
    /** 生殖器其他，男性填写 **/ 
	private String genitalOther;
	

	/**
	 * 构造 
	 */
	public PhysiqueExaInfoVO() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMarriageTaId() {
		return marriageTaId;
	}

	public void setMarriageTaId(String marriageTaId) {
		this.marriageTaId = marriageTaId;
	}
	public String getBloodHi() {
		return bloodHi;
	}

	public void setBloodHi(String bloodHi) {
		this.bloodHi = bloodHi;
	}
	public String getBloodLow() {
		return bloodLow;
	}

	public void setBloodLow(String bloodLow) {
		this.bloodLow = bloodLow;
	}
	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getYinYang() {
		return yinYang;
	}

	public void setYinYang(String yinYang) {
		this.yinYang = yinYang;
	}
	public String getSpecialPosture() {
		return specialPosture;
	}

	public void setSpecialPosture(String specialPosture) {
		this.specialPosture = specialPosture;
	}
	public String getPostureRemark() {
		return postureRemark;
	}

	public void setPostureRemark(String postureRemark) {
		this.postureRemark = postureRemark;
	}
	public String getSpecialFace() {
		return specialFace;
	}

	public void setSpecialFace(String specialFace) {
		this.specialFace = specialFace;
	}
	public String getFaceRemark() {
		return faceRemark;
	}

	public void setFaceRemark(String faceRemark) {
		this.faceRemark = faceRemark;
	}
	public String getMentalState() {
		return mentalState;
	}

	public void setMentalState(String mentalState) {
		this.mentalState = mentalState;
	}
	public String getStateRemark() {
		return stateRemark;
	}

	public void setStateRemark(String stateRemark) {
		this.stateRemark = stateRemark;
	}
	public String getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(String intelligence) {
		this.intelligence = intelligence;
	}
	public String getExceptionTypes() {
		return exceptionTypes;
	}

	public void setExceptionTypes(String exceptionTypes) {
		this.exceptionTypes = exceptionTypes;
	}
	public String getSkinHair() {
		return skinHair;
	}

	public void setSkinHair(String skinHair) {
		this.skinHair = skinHair;
	}
	public String getSkinHairNote() {
		return skinHairNote;
	}

	public void setSkinHairNote(String skinHairNote) {
		this.skinHairNote = skinHairNote;
	}
	public String getFacialFeatures() {
		return facialFeatures;
	}

	public void setFacialFeatures(String facialFeatures) {
		this.facialFeatures = facialFeatures;
	}
	public String getFacialFeaturesRemark() {
		return facialFeaturesRemark;
	}

	public void setFacialFeaturesRemark(String facialFeaturesRemark) {
		this.facialFeaturesRemark = facialFeaturesRemark;
	}
	public String getThyroidGland() {
		return thyroidGland;
	}

	public void setThyroidGland(String thyroidGland) {
		this.thyroidGland = thyroidGland;
	}
	public String getThyroidGlandRemark() {
		return thyroidGlandRemark;
	}

	public void setThyroidGlandRemark(String thyroidGlandRemark) {
		this.thyroidGlandRemark = thyroidGlandRemark;
	}
	public String getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}
	public String getHeartRhythm() {
		return heartRhythm;
	}

	public void setHeartRhythm(String heartRhythm) {
		this.heartRhythm = heartRhythm;
	}
	public String getHeartRhythmRemark() {
		return heartRhythmRemark;
	}

	public void setHeartRhythmRemark(String heartRhythmRemark) {
		this.heartRhythmRemark = heartRhythmRemark;
	}
	public String getNoise() {
		return noise;
	}

	public void setNoise(String noise) {
		this.noise = noise;
	}
	public String getNoiseRemark() {
		return noiseRemark;
	}

	public void setNoiseRemark(String noiseRemark) {
		this.noiseRemark = noiseRemark;
	}
	public String getLung() {
		return lung;
	}

	public void setLung(String lung) {
		this.lung = lung;
	}
	public String getLungRemark() {
		return lungRemark;
	}

	public void setLungRemark(String lungRemark) {
		this.lungRemark = lungRemark;
	}
	public String getLiver() {
		return liver;
	}

	public void setLiver(String liver) {
		this.liver = liver;
	}
	public String getLiverRemark() {
		return liverRemark;
	}

	public void setLiverRemark(String liverRemark) {
		this.liverRemark = liverRemark;
	}
	public String getLimbs() {
		return limbs;
	}

	public void setLimbs(String limbs) {
		this.limbs = limbs;
	}
	public String getLimbsRemark() {
		return limbsRemark;
	}

	public void setLimbsRemark(String limbsRemark) {
		this.limbsRemark = limbsRemark;
	}
	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}
	public String getThroat() {
		return throat;
	}

	public void setThroat(String throat) {
		this.throat = throat;
	}
	public String getPubicHair() {
		return pubicHair;
	}

	public void setPubicHair(String pubicHair) {
		this.pubicHair = pubicHair;
	}
	public String getBreast() {
		return breast;
	}

	public void setBreast(String breast) {
		this.breast = breast;
	}
	public String getBreastRemark() {
		return breastRemark;
	}

	public void setBreastRemark(String breastRemark) {
		this.breastRemark = breastRemark;
	}
	public String getAnusVulva() {
		return anusVulva;
	}

	public void setAnusVulva(String anusVulva) {
		this.anusVulva = anusVulva;
	}
	public String getAnusVulvaRemark() {
		return anusVulvaRemark;
	}

	public void setAnusVulvaRemark(String anusVulvaRemark) {
		this.anusVulvaRemark = anusVulvaRemark;
	}
	public String getSecretions() {
		return secretions;
	}

	public void setSecretions(String secretions) {
		this.secretions = secretions;
	}
	public String getSecretionsRemark() {
		return secretionsRemark;
	}

	public void setSecretionsRemark(String secretionsRemark) {
		this.secretionsRemark = secretionsRemark;
	}
	public String getVulvaVagina() {
		return vulvaVagina;
	}

	public void setVulvaVagina(String vulvaVagina) {
		this.vulvaVagina = vulvaVagina;
	}
	public String getVulvaVaginaRemark() {
		return vulvaVaginaRemark;
	}

	public void setVulvaVaginaRemark(String vulvaVaginaRemark) {
		this.vulvaVaginaRemark = vulvaVaginaRemark;
	}
	public String getVulva() {
		return vulva;
	}

	public void setVulva(String vulva) {
		this.vulva = vulva;
	}
	public String getVulvaRemark() {
		return vulvaRemark;
	}

	public void setVulvaRemark(String vulvaRemark) {
		this.vulvaRemark = vulvaRemark;
	}
	public String getVagina() {
		return vagina;
	}

	public void setVagina(String vagina) {
		this.vagina = vagina;
	}
	public String getVaginaRemark() {
		return vaginaRemark;
	}

	public void setVaginaRemark(String vaginaRemark) {
		this.vaginaRemark = vaginaRemark;
	}
	public String getCervical() {
		return cervical;
	}

	public void setCervical(String cervical) {
		this.cervical = cervical;
	}
	public String getCervicalRemark() {
		return cervicalRemark;
	}

	public void setCervicalRemark(String cervicalRemark) {
		this.cervicalRemark = cervicalRemark;
	}
	public String getUterus() {
		return uterus;
	}

	public void setUterus(String uterus) {
		this.uterus = uterus;
	}
	public String getUterusRemark() {
		return uterusRemark;
	}

	public void setUterusRemark(String uterusRemark) {
		this.uterusRemark = uterusRemark;
	}
	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getAttachmentRemark() {
		return attachmentRemark;
	}

	public void setAttachmentRemark(String attachmentRemark) {
		this.attachmentRemark = attachmentRemark;
	}
	public String getAttachmentOther() {
		return attachmentOther;
	}

	public void setAttachmentOther(String attachmentOther) {
		this.attachmentOther = attachmentOther;
	}
	public String getVaginalExamination() {
		return vaginalExamination;
	}

	public void setVaginalExamination(String vaginalExamination) {
		this.vaginalExamination = vaginalExamination;
	}
	public String getPenis() {
		return penis;
	}

	public void setPenis(String penis) {
		this.penis = penis;
	}
	public String getPenisRemark() {
		return penisRemark;
	}

	public void setPenisRemark(String penisRemark) {
		this.penisRemark = penisRemark;
	}
	public String getForeskin() {
		return foreskin;
	}

	public void setForeskin(String foreskin) {
		this.foreskin = foreskin;
	}
	public String getBilateralTesticular() {
		return bilateralTesticular;
	}

	public void setBilateralTesticular(String bilateralTesticular) {
		this.bilateralTesticular = bilateralTesticular;
	}
	public String getLeftTestis() {
		return leftTestis;
	}

	public void setLeftTestis(String leftTestis) {
		this.leftTestis = leftTestis;
	}
	public String getRightTestis() {
		return rightTestis;
	}

	public void setRightTestis(String rightTestis) {
		this.rightTestis = rightTestis;
	}
	public String getWithout() {
		return without;
	}

	public void setWithout(String without) {
		this.without = without;
	}
	public String getNormalEpididymis() {
		return normalEpididymis;
	}

	public void setNormalEpididymis(String normalEpididymis) {
		this.normalEpididymis = normalEpididymis;
	}
	public String getLeftNodules() {
		return leftNodules;
	}

	public void setLeftNodules(String leftNodules) {
		this.leftNodules = leftNodules;
	}
	public String getRihgtNodules() {
		return rihgtNodules;
	}

	public void setRihgtNodules(String rihgtNodules) {
		this.rihgtNodules = rihgtNodules;
	}
	public String getVaricocele() {
		return varicocele;
	}

	public void setVaricocele(String varicocele) {
		this.varicocele = varicocele;
	}
	public String getVaricoseParts() {
		return varicoseParts;
	}

	public void setVaricoseParts(String varicoseParts) {
		this.varicoseParts = varicoseParts;
	}
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getGenitalOther() {
		return genitalOther;
	}

	public void setGenitalOther(String genitalOther) {
		this.genitalOther = genitalOther;
	}

}