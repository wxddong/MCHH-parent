/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: ChildrenPhysiqueExaInfoVO.java  
 * @Prject: MCHH-boss
 * @Package: com.threefiveninetong.mchh.childCare.vo 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-11-04 14:36:03 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.childCare.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @ClassName: ChildrenPhysiqueExaInfovo 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-11-04 14:36:03 
 */
public class ChildrenPhysiqueExaInfoVO {

	/** 主键ID **/ 
	private String id;
	
    /** 健康检查表ID **/ 
	private String healthExaId;
	
    /** 0：通过，1：未通过，2：未筛查，3：不详 **/ 
	private String hearing;
	
    /** 0：甲低，1：苯丙酮尿症，2：其他遗传代谢病 **/ 
	private String disease;
	
    /** 疾病筛查备注 **/ 
	private String diseaseRemark;
	
    /** 体重 **/ 
	private String weight;
	
    /** 0：上，1：中，2：下 **/ 
	private String weightStandard;
	
    /** 身长 **/ 
	private String length;
	
    /** 0：上，1：中，2：下 **/ 
	private String lengthStandard;
	
    /** 0：纯母乳，1：人工，2：混合 **/ 
	private String feedingMode;
	
    /** 吃奶量 **/ 
	private String feedingAmount;
	
    /** 0：无，1：有 **/ 
	private String vomit;
	
    /** 吃奶次数 **/ 
	private String milkNum;
	
    /** 0：糊状，1：稀 **/ 
	private String shit;
	
    /** 大便次数 **/ 
	private String shitNum;
	
    /** 体温 **/ 
	private String temperature;
	
    /** 脉率 **/ 
	private String pulseRate;
	
    /** 0：红润，1：黄染，2：其他 **/ 
	private String complexion;
	
    /** 面色备注 **/ 
	private String complexionRemark;
	
    /** 0：面部，1：躯干，2：四肢，3：手足，4：无 **/ 
	private String jaundicePosition;
	
    /** 呼吸频率 **/ 
	private String respiratoryRate;
	
    /** 前囟1 **/ 
	private String bregmatic;
	
    /** 前囟2 **/ 
	private String bregmaticOther;
	
    /** 0：正常，1：膨隆，2：凹陷，3：其他，4：闭合，5：未闭合 **/ 
	private String bregmaticSituation;
	
    /** 前囟情况备注 **/ 
	private String bregmaticRemark;
	
    /** 0：未见异常，1：异常 **/ 
	private String eye;
	
    /** 眼外观备注 **/ 
	private String eyeRemark;
	
    /** 0：未见异常，1：异常 **/ 
	private String limb;
	
    /** 四肢活动度备注 **/ 
	private String limbRemark;
	
    /** 0：未见异常，1：异常 **/ 
	private String ear;
	
    /** 耳外观备注 **/ 
	private String earRemark;
	
    /** 0：无，1：有 **/ 
	private String neckMass;
	
    /** 颈部包块备注 **/ 
	private String neckMassRemark;
	
    /** 0：未见异常，1：异常 **/ 
	private String nose;
	
    /** 鼻备注 **/ 
	private String noseRemark;
	
    /** 0：未见异常，1：异常 **/ 
	private String skin;
	
    /** 皮肤备注 **/ 
	private String skinRemark;
	
    /** 0：未见异常，1：异常 **/ 
	private String oralCavity;
	
    /** 口腔备注 **/ 
	private String oralCavityRemark;
	
    /** 0：未见异常，1：异常 **/ 
	private String anus;
	
    /** 肛门备注 **/ 
	private String anusRemark;
	
    /** 0：未见异常，1：异常 **/ 
	private String heartLung;
	
    /** 心肺听诊备注 **/ 
	private String heartLungRemark;
	
    /** 0：未见异常，1：异常 **/ 
	private String genitals;
	
    /** 外生殖器备注 **/ 
	private String genitalsRemark;
	
    /** 0：未见异常，1：异常 **/ 
	private String abdomen;
	
    /** 腹部触诊备注 **/ 
	private String abdomenRemark;
	
    /** 0：未见异常，1：异常 **/ 
	private String spine;
	
    /** 脊柱备注 **/ 
	private String spineRemark;
	
    /** 0：未见异常，1：异常 **/ 
	private String umbilicalCord;
	
    /** 脐带备注 **/ 
	private String umbilicalCordRem;
	
    /** 头围 **/ 
	private String headCir;
	
    /** 0：五，1：夜惊，2：多汗，3：烦躁 **/ 
	private String ricketsSymptom;
	
    /** 血红蛋白值 **/ 
	private String hemoglobin;
	
    /** 户外活动 **/ 
	private String outdoorActivities;
	
    /** 服用维生素D **/ 
	private String vitaminD;
	
    /** 0：无，1：颅骨软化，2：方颅，3：枕秃，
            4：助串珠，5：助外翻,6：助软骨沟，7：鸡胸，8：手镯征
            9：O型腿，10：X型腿 **/ 
	private String ricketsBodyCha;
	
    /** 0：佳，1：受限制，2：双下肢皮纹不对称 **/ 
	private String hipJoint;
	
    /** 髋关节活动备注 **/ 
	private String hipJointRemark;
	
    /** 0：正常，1：异常 **/ 
	private String neuDevelop;
	
    /** 0：动作不对称，1：动作迟缓，2：异常肌张力/异常迟缓，3：其他 **/ 
	private String neuAbnormal;
	
    /** 神经肌肉发育异常情况备注 **/ 
	private String neuRemark;
	
    /** 0：未患病，1：患病，2：其他（3-6岁使用） **/ 
	private String followIll;
	
    /** 两次随访间患病情况备注 **/ 
	private String followIllRemark;
	
    /** 0：未通过，1：通过 **/ 
	private String develop;
	
    /** 发育评估备注 **/ 
	private String developRemark;
	
    /** 出牙数 **/ 
	private String teethNum;
	
    /** 龋齿数 **/ 
	private String dentalCariesNum;
	
    /** 0：未见异常，1：异常 **/ 
	private String gait;
	
    /** 步态备注 **/ 
	private String gaitRemark;
	
    /** 0：正常，1：低体重，2：消瘦，3：发育迟缓，4：超重 **/ 
	private String physicalGrowth;
	
    /** 0：未见异常，1：异常 **/ 
	private String vision;
	
    /** 视力备注 **/ 
	private String visionRemark;
	
    /** 3-6岁两次随访间患病使用 **/ 
	private String pneumoniaNum;
	
    /** 3-6岁两次随访间患病使用 **/ 
	private String diarrheaNum;
	
    /** 3-6岁两次随访间患病使用 **/ 
	private String traumaNum;
	

	/**
	 * 构造 
	 */
	public ChildrenPhysiqueExaInfoVO() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHealthExaId() {
		return healthExaId;
	}

	public void setHealthExaId(String healthExaId) {
		this.healthExaId = healthExaId;
	}
	public String getHearing() {
		return hearing;
	}

	public void setHearing(String hearing) {
		this.hearing = hearing;
	}
	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getDiseaseRemark() {
		return diseaseRemark;
	}

	public void setDiseaseRemark(String diseaseRemark) {
		this.diseaseRemark = diseaseRemark;
	}
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getWeightStandard() {
		return weightStandard;
	}

	public void setWeightStandard(String weightStandard) {
		this.weightStandard = weightStandard;
	}
	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}
	public String getLengthStandard() {
		return lengthStandard;
	}

	public void setLengthStandard(String lengthStandard) {
		this.lengthStandard = lengthStandard;
	}
	public String getFeedingMode() {
		return feedingMode;
	}

	public void setFeedingMode(String feedingMode) {
		this.feedingMode = feedingMode;
	}
	public String getFeedingAmount() {
		return feedingAmount;
	}

	public void setFeedingAmount(String feedingAmount) {
		this.feedingAmount = feedingAmount;
	}
	public String getVomit() {
		return vomit;
	}

	public void setVomit(String vomit) {
		this.vomit = vomit;
	}
	public String getMilkNum() {
		return milkNum;
	}

	public void setMilkNum(String milkNum) {
		this.milkNum = milkNum;
	}
	public String getShit() {
		return shit;
	}

	public void setShit(String shit) {
		this.shit = shit;
	}
	public String getShitNum() {
		return shitNum;
	}

	public void setShitNum(String shitNum) {
		this.shitNum = shitNum;
	}
	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getPulseRate() {
		return pulseRate;
	}

	public void setPulseRate(String pulseRate) {
		this.pulseRate = pulseRate;
	}
	public String getComplexion() {
		return complexion;
	}

	public void setComplexion(String complexion) {
		this.complexion = complexion;
	}
	public String getComplexionRemark() {
		return complexionRemark;
	}

	public void setComplexionRemark(String complexionRemark) {
		this.complexionRemark = complexionRemark;
	}
	public String getJaundicePosition() {
		return jaundicePosition;
	}

	public void setJaundicePosition(String jaundicePosition) {
		this.jaundicePosition = jaundicePosition;
	}
	public String getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(String respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}
	public String getBregmatic() {
		return bregmatic;
	}

	public void setBregmatic(String bregmatic) {
		this.bregmatic = bregmatic;
	}
	public String getBregmaticOther() {
		return bregmaticOther;
	}

	public void setBregmaticOther(String bregmaticOther) {
		this.bregmaticOther = bregmaticOther;
	}
	public String getBregmaticSituation() {
		return bregmaticSituation;
	}

	public void setBregmaticSituation(String bregmaticSituation) {
		this.bregmaticSituation = bregmaticSituation;
	}
	public String getBregmaticRemark() {
		return bregmaticRemark;
	}

	public void setBregmaticRemark(String bregmaticRemark) {
		this.bregmaticRemark = bregmaticRemark;
	}
	public String getEye() {
		return eye;
	}

	public void setEye(String eye) {
		this.eye = eye;
	}
	public String getEyeRemark() {
		return eyeRemark;
	}

	public void setEyeRemark(String eyeRemark) {
		this.eyeRemark = eyeRemark;
	}
	public String getLimb() {
		return limb;
	}

	public void setLimb(String limb) {
		this.limb = limb;
	}
	public String getLimbRemark() {
		return limbRemark;
	}

	public void setLimbRemark(String limbRemark) {
		this.limbRemark = limbRemark;
	}
	public String getEar() {
		return ear;
	}

	public void setEar(String ear) {
		this.ear = ear;
	}
	public String getEarRemark() {
		return earRemark;
	}

	public void setEarRemark(String earRemark) {
		this.earRemark = earRemark;
	}
	public String getNeckMass() {
		return neckMass;
	}

	public void setNeckMass(String neckMass) {
		this.neckMass = neckMass;
	}
	public String getNeckMassRemark() {
		return neckMassRemark;
	}

	public void setNeckMassRemark(String neckMassRemark) {
		this.neckMassRemark = neckMassRemark;
	}
	public String getNose() {
		return nose;
	}

	public void setNose(String nose) {
		this.nose = nose;
	}
	public String getNoseRemark() {
		return noseRemark;
	}

	public void setNoseRemark(String noseRemark) {
		this.noseRemark = noseRemark;
	}
	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}
	public String getSkinRemark() {
		return skinRemark;
	}

	public void setSkinRemark(String skinRemark) {
		this.skinRemark = skinRemark;
	}
	public String getOralCavity() {
		return oralCavity;
	}

	public void setOralCavity(String oralCavity) {
		this.oralCavity = oralCavity;
	}
	public String getOralCavityRemark() {
		return oralCavityRemark;
	}

	public void setOralCavityRemark(String oralCavityRemark) {
		this.oralCavityRemark = oralCavityRemark;
	}
	public String getAnus() {
		return anus;
	}

	public void setAnus(String anus) {
		this.anus = anus;
	}
	public String getAnusRemark() {
		return anusRemark;
	}

	public void setAnusRemark(String anusRemark) {
		this.anusRemark = anusRemark;
	}
	public String getHeartLung() {
		return heartLung;
	}

	public void setHeartLung(String heartLung) {
		this.heartLung = heartLung;
	}
	public String getHeartLungRemark() {
		return heartLungRemark;
	}

	public void setHeartLungRemark(String heartLungRemark) {
		this.heartLungRemark = heartLungRemark;
	}
	public String getGenitals() {
		return genitals;
	}

	public void setGenitals(String genitals) {
		this.genitals = genitals;
	}
	public String getGenitalsRemark() {
		return genitalsRemark;
	}

	public void setGenitalsRemark(String genitalsRemark) {
		this.genitalsRemark = genitalsRemark;
	}
	public String getAbdomen() {
		return abdomen;
	}

	public void setAbdomen(String abdomen) {
		this.abdomen = abdomen;
	}
	public String getAbdomenRemark() {
		return abdomenRemark;
	}

	public void setAbdomenRemark(String abdomenRemark) {
		this.abdomenRemark = abdomenRemark;
	}
	public String getSpine() {
		return spine;
	}

	public void setSpine(String spine) {
		this.spine = spine;
	}
	public String getSpineRemark() {
		return spineRemark;
	}

	public void setSpineRemark(String spineRemark) {
		this.spineRemark = spineRemark;
	}
	public String getUmbilicalCord() {
		return umbilicalCord;
	}

	public void setUmbilicalCord(String umbilicalCord) {
		this.umbilicalCord = umbilicalCord;
	}
	public String getUmbilicalCordRem() {
		return umbilicalCordRem;
	}

	public void setUmbilicalCordRem(String umbilicalCordRem) {
		this.umbilicalCordRem = umbilicalCordRem;
	}
	public String getHeadCir() {
		return headCir;
	}

	public void setHeadCir(String headCir) {
		this.headCir = headCir;
	}
	public String getRicketsSymptom() {
		return ricketsSymptom;
	}

	public void setRicketsSymptom(String ricketsSymptom) {
		this.ricketsSymptom = ricketsSymptom;
	}
	public String getHemoglobin() {
		return hemoglobin;
	}

	public void setHemoglobin(String hemoglobin) {
		this.hemoglobin = hemoglobin;
	}
	public String getOutdoorActivities() {
		return outdoorActivities;
	}

	public void setOutdoorActivities(String outdoorActivities) {
		this.outdoorActivities = outdoorActivities;
	}
	public String getVitaminD() {
		return vitaminD;
	}

	public void setVitaminD(String vitaminD) {
		this.vitaminD = vitaminD;
	}
	public String getRicketsBodyCha() {
		return ricketsBodyCha;
	}

	public void setRicketsBodyCha(String ricketsBodyCha) {
		this.ricketsBodyCha = ricketsBodyCha;
	}
	public String getHipJoint() {
		return hipJoint;
	}

	public void setHipJoint(String hipJoint) {
		this.hipJoint = hipJoint;
	}
	public String getHipJointRemark() {
		return hipJointRemark;
	}

	public void setHipJointRemark(String hipJointRemark) {
		this.hipJointRemark = hipJointRemark;
	}
	public String getNeuDevelop() {
		return neuDevelop;
	}

	public void setNeuDevelop(String neuDevelop) {
		this.neuDevelop = neuDevelop;
	}
	public String getNeuAbnormal() {
		return neuAbnormal;
	}

	public void setNeuAbnormal(String neuAbnormal) {
		this.neuAbnormal = neuAbnormal;
	}
	public String getNeuRemark() {
		return neuRemark;
	}

	public void setNeuRemark(String neuRemark) {
		this.neuRemark = neuRemark;
	}
	public String getFollowIll() {
		return followIll;
	}

	public void setFollowIll(String followIll) {
		this.followIll = followIll;
	}
	public String getFollowIllRemark() {
		return followIllRemark;
	}

	public void setFollowIllRemark(String followIllRemark) {
		this.followIllRemark = followIllRemark;
	}
	public String getDevelop() {
		return develop;
	}

	public void setDevelop(String develop) {
		this.develop = develop;
	}
	public String getDevelopRemark() {
		return developRemark;
	}

	public void setDevelopRemark(String developRemark) {
		this.developRemark = developRemark;
	}
	public String getTeethNum() {
		return teethNum;
	}

	public void setTeethNum(String teethNum) {
		this.teethNum = teethNum;
	}
	public String getDentalCariesNum() {
		return dentalCariesNum;
	}

	public void setDentalCariesNum(String dentalCariesNum) {
		this.dentalCariesNum = dentalCariesNum;
	}
	public String getGait() {
		return gait;
	}

	public void setGait(String gait) {
		this.gait = gait;
	}
	public String getGaitRemark() {
		return gaitRemark;
	}

	public void setGaitRemark(String gaitRemark) {
		this.gaitRemark = gaitRemark;
	}
	public String getPhysicalGrowth() {
		return physicalGrowth;
	}

	public void setPhysicalGrowth(String physicalGrowth) {
		this.physicalGrowth = physicalGrowth;
	}
	public String getVision() {
		return vision;
	}

	public void setVision(String vision) {
		this.vision = vision;
	}
	public String getVisionRemark() {
		return visionRemark;
	}

	public void setVisionRemark(String visionRemark) {
		this.visionRemark = visionRemark;
	}
	public String getPneumoniaNum() {
		return pneumoniaNum;
	}

	public void setPneumoniaNum(String pneumoniaNum) {
		this.pneumoniaNum = pneumoniaNum;
	}
	public String getDiarrheaNum() {
		return diarrheaNum;
	}

	public void setDiarrheaNum(String diarrheaNum) {
		this.diarrheaNum = diarrheaNum;
	}
	public String getTraumaNum() {
		return traumaNum;
	}

	public void setTraumaNum(String traumaNum) {
		this.traumaNum = traumaNum;
	}

}