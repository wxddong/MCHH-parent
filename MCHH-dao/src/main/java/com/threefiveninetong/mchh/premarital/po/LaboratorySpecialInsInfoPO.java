/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: LaboratorySpecialInsInfoPO.java
 * @Prject: MCHH-dao
 * @Package: com.threefiveninetong.mchh.premarital.po 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016-08-30 18:34:03 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.premarital.po;

import java.io.Serializable;
import java.util.Date;




/**
 * @ClassName: LaboratorySpecialInsInfoPO 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016-08-30 18:34:03 
 */
public class LaboratorySpecialInsInfoPO implements Serializable {

	/** serialVersionUID **/ 
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/ 
	private String id;
	
    /** 婚检表ID **/ 
	private String marriageTaId;
	
    /** 血红蛋白 **/ 
	private String hemoglobin;
	
    /** 白细胞计数值 **/ 
	private String whiteCellCount;
	
    /** 血小板 **/ 
	private String platelet;
	
    /** 血常规其他 **/ 
	private String routineBlood;
	
    /** 尿蛋白 **/ 
	private String urineProtein;
	
    /** PH **/ 
	private String ph;
	
    /** 白细胞 **/ 
	private String whiteCell;
	
    /** 尿糖 **/ 
	private String urineSugar;
	
    /** 尿酮体 **/ 
	private String ketoneBody;
	
    /** 尿潜血 **/ 
	private String ery;
	
    /** 尿常规其他 **/ 
	private String routineUrine;
	
    /** 血清谷丙转氨酶 **/ 
	private String serumAlt;
	
    /** 血清谷草转氨酶 **/ 
	private String aspertateAmi;
	
    /** 白蛋白 **/ 
	private String albumin;
	
    /** 总胆红素 **/ 
	private String totalBilirubin;
	
    /** 结合胆红素 **/ 
	private String combiningBilirubin;
	
    /** 血清肌酐 **/ 
	private String serumCreatinine;
	
    /** 0：未见异常，1：滴虫，2：假丝酵母菌，3：其他
            多个使用;号分隔，女性填写 **/ 
	private String vaginalDischarge;
	
    /** 血尿素氮 **/ 
	private String bloodUreaNitrogen;
	
    /** 阴道分泌物为其他（3）时填写，女性填写 **/ 
	private String otherSecretion;
	
    /** 0：Ⅰ度，
            1：Ⅱ度，
            2：Ⅲ度，
            3：Ⅳ度
            ，女性填写 **/ 
	private String cleanliness;
	
    /** 0：阴性，1：阳性 **/ 
	private String antigenHepatitis;
	
    /** 0：阴性，1：阳性 **/ 
	private String hepatitisAntibody;
	
    /** 0：阴性，1：阳性 **/ 
	private String coreAntibody;
	
    /** 0：阴性，1：阳性 **/ 
	private String eantibody;
	
    /** 0：阴性，1：阳性 **/ 
	private String eantigen;
	
    /** 0：阴性，1：阳性 **/ 
	private String syphilisSerum;
	
    /** 0：阴性，1：阳性 **/ 
	private String hivAntibodies;
	
    /** 0：未见异常，1：异常 **/ 
	private String chest;
	
    /** 胸透为异常（1）时填写 **/ 
	private String note;
	

	/**
	 * 构造 
	 */
	public LaboratorySpecialInsInfoPO() {
	}
	
	public LaboratorySpecialInsInfoPO( String id,  String marriageTaId, String hemoglobin, String whiteCellCount, String platelet, String routineBlood, String urineProtein, String ph, String whiteCell, String urineSugar, String ketoneBody, String ery, String routineUrine, String serumAlt, String aspertateAmi, String albumin, String totalBilirubin, String combiningBilirubin, String serumCreatinine, String vaginalDischarge, String bloodUreaNitrogen, String otherSecretion, String cleanliness, String antigenHepatitis, String hepatitisAntibody, String coreAntibody, String eantibody, String eantigen, String syphilisSerum, String hivAntibodies, String chest, String note) {
				this.marriageTaId = marriageTaId;
				this.hemoglobin = hemoglobin;
				this.whiteCellCount = whiteCellCount;
				this.platelet = platelet;
				this.routineBlood = routineBlood;
				this.urineProtein = urineProtein;
				this.ph = ph;
				this.whiteCell = whiteCell;
				this.urineSugar = urineSugar;
				this.ketoneBody = ketoneBody;
				this.ery = ery;
				this.routineUrine = routineUrine;
				this.serumAlt = serumAlt;
				this.aspertateAmi = aspertateAmi;
				this.albumin = albumin;
				this.totalBilirubin = totalBilirubin;
				this.combiningBilirubin = combiningBilirubin;
				this.serumCreatinine = serumCreatinine;
				this.vaginalDischarge = vaginalDischarge;
				this.bloodUreaNitrogen = bloodUreaNitrogen;
				this.otherSecretion = otherSecretion;
				this.cleanliness = cleanliness;
				this.antigenHepatitis = antigenHepatitis;
				this.hepatitisAntibody = hepatitisAntibody;
				this.coreAntibody = coreAntibody;
				this.eantibody = eantibody;
				this.eantigen = eantigen;
				this.syphilisSerum = syphilisSerum;
				this.hivAntibodies = hivAntibodies;
				this.chest = chest;
				this.note = note;
						this.id = id;
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
	public String getHemoglobin() {
		return hemoglobin;
	}

	public void setHemoglobin(String hemoglobin) {
		this.hemoglobin = hemoglobin;
	}
	public String getWhiteCellCount() {
		return whiteCellCount;
	}

	public void setWhiteCellCount(String whiteCellCount) {
		this.whiteCellCount = whiteCellCount;
	}
	public String getPlatelet() {
		return platelet;
	}

	public void setPlatelet(String platelet) {
		this.platelet = platelet;
	}
	public String getRoutineBlood() {
		return routineBlood;
	}

	public void setRoutineBlood(String routineBlood) {
		this.routineBlood = routineBlood;
	}
	public String getUrineProtein() {
		return urineProtein;
	}

	public void setUrineProtein(String urineProtein) {
		this.urineProtein = urineProtein;
	}
	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}
	public String getWhiteCell() {
		return whiteCell;
	}

	public void setWhiteCell(String whiteCell) {
		this.whiteCell = whiteCell;
	}
	public String getUrineSugar() {
		return urineSugar;
	}

	public void setUrineSugar(String urineSugar) {
		this.urineSugar = urineSugar;
	}
	public String getKetoneBody() {
		return ketoneBody;
	}

	public void setKetoneBody(String ketoneBody) {
		this.ketoneBody = ketoneBody;
	}
	public String getEry() {
		return ery;
	}

	public void setEry(String ery) {
		this.ery = ery;
	}
	public String getRoutineUrine() {
		return routineUrine;
	}

	public void setRoutineUrine(String routineUrine) {
		this.routineUrine = routineUrine;
	}
	public String getSerumAlt() {
		return serumAlt;
	}

	public void setSerumAlt(String serumAlt) {
		this.serumAlt = serumAlt;
	}
	public String getAspertateAmi() {
		return aspertateAmi;
	}

	public void setAspertateAmi(String aspertateAmi) {
		this.aspertateAmi = aspertateAmi;
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
	public String getCombiningBilirubin() {
		return combiningBilirubin;
	}

	public void setCombiningBilirubin(String combiningBilirubin) {
		this.combiningBilirubin = combiningBilirubin;
	}
	public String getSerumCreatinine() {
		return serumCreatinine;
	}

	public void setSerumCreatinine(String serumCreatinine) {
		this.serumCreatinine = serumCreatinine;
	}
	public String getVaginalDischarge() {
		return vaginalDischarge;
	}

	public void setVaginalDischarge(String vaginalDischarge) {
		this.vaginalDischarge = vaginalDischarge;
	}
	public String getBloodUreaNitrogen() {
		return bloodUreaNitrogen;
	}

	public void setBloodUreaNitrogen(String bloodUreaNitrogen) {
		this.bloodUreaNitrogen = bloodUreaNitrogen;
	}
	public String getOtherSecretion() {
		return otherSecretion;
	}

	public void setOtherSecretion(String otherSecretion) {
		this.otherSecretion = otherSecretion;
	}
	public String getCleanliness() {
		return cleanliness;
	}

	public void setCleanliness(String cleanliness) {
		this.cleanliness = cleanliness;
	}
	public String getAntigenHepatitis() {
		return antigenHepatitis;
	}

	public void setAntigenHepatitis(String antigenHepatitis) {
		this.antigenHepatitis = antigenHepatitis;
	}
	public String getHepatitisAntibody() {
		return hepatitisAntibody;
	}

	public void setHepatitisAntibody(String hepatitisAntibody) {
		this.hepatitisAntibody = hepatitisAntibody;
	}
	public String getCoreAntibody() {
		return coreAntibody;
	}

	public void setCoreAntibody(String coreAntibody) {
		this.coreAntibody = coreAntibody;
	}
	public String getEantibody() {
		return eantibody;
	}

	public void setEantibody(String eantibody) {
		this.eantibody = eantibody;
	}
	public String getEantigen() {
		return eantigen;
	}

	public void setEantigen(String eantigen) {
		this.eantigen = eantigen;
	}
	public String getSyphilisSerum() {
		return syphilisSerum;
	}

	public void setSyphilisSerum(String syphilisSerum) {
		this.syphilisSerum = syphilisSerum;
	}
	public String getHivAntibodies() {
		return hivAntibodies;
	}

	public void setHivAntibodies(String hivAntibodies) {
		this.hivAntibodies = hivAntibodies;
	}
	public String getChest() {
		return chest;
	}

	public void setChest(String chest) {
		this.chest = chest;
	}
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}