package com.threefiveninetong.mchh.sys.po;

import com.threefiveninetong.mchh.archives.po.ArchivesInfoPO;

/**
 * 孕产妇保健报表
 * @author zhangjie
 *
 */
public class MaternalReportsPO {

	/**
	 * 医院id
	 */
	private String hospitalId;
	
	/**
	 * 合计人数
	 */
	private Integer total;
	
	/**
	 * 非农业户籍
	 */
	private Integer noAgriculture;
	
	/**
	 * 农业户籍
	 */
	private Integer agriculture;
	
	/**
	 * 建卡人数
	 */
	private Integer archNum;
	
	/**
	 * 建卡人数所占百分比
	 */
	private String archBili;
	
	/**
	 * 早检人数
	 */
	private Integer mornNum;
	
	/**
	 * 早检人数百分比
	 */
	private String mornNumBili;
	
	/**
	 * 产检人数
	 */
	private Integer midNum;
	
	/**
	 * 产检人数百分比
	 */
	private String midNumBili;
	
	/**
	 * 产检次数大于5次人数
	 */
	private Integer afterNum;
	
	/**
	 * 产检次数大于5次人数百分比
	 */
	private String afterNumBili;
	
	/**
	 * 艾滋病检测人数
	 */
	private Integer acheckNum;
	
	/**
	 * 艾滋病检测人数百分比
	 */
	private String acheckNumBili;
	
	/**
	 * 艾滋病感染人数
	 */
	private Integer gacheckNum;
	
	/**
	 * 艾滋病感染人数比例
	 */
	private String gacheckNumBili;
	
	/**
	 * 梅毒检测人数
	 */
	private Integer mcheckNum;
	
	/**
	 * 梅毒检测人数百分比
	 */
	private String mcheckNumBili;
	
	/**
	 * 梅毒感染人数
	 */
	private Integer gmcheckNum;
	
	/**
	 * 梅毒感染人数比例
	 */
	private String gmcheckNumBili;
	
	/**
	 * 乙肝表面抗原检测人数
	 */
	private Integer ycheckNum;
	
	/**
	 * 乙肝表面抗原检测人数百分比
	 */
	private String ycheckNumBili;
	
	/**
	 * 乙肝表面抗原感染人数
	 */
	private Integer gycheckNum;
	
	/**
	 * 乙肝表面抗原感染人数比例
	 */
	private String gycheckNumBili;
	
	/**
	 * 产前筛查人数
	 */
	private Integer shcheckNum;
	
	/**
	 * 产前筛查人数百分比
	 */
	private String shcheckNumBili;
	
	/**
	 * 高危人数
	 */
	private Integer gwNum;
	
	/**
	 * 高危人数百分比
	 */
	private String gwNumBili;
	
	/**
	 * 产后访视
	 */
	private Integer lookNum;
	
	/**
	 * 产后访视百分比
	 */
	private String lookNumBili;
	
	/**
	 * 产妇系统管理人数
	 */
	private Integer systermNum;
	
	/**
	 * 产妇系统管理人数百分比
	 */
	private String systermNumBili;
	
	/**
	 * 高危产妇人数
	 */
	private Integer gmaternalNum;
	
	/**
	 * 高危产妇人数百分比
	 */
	private String gmaternalNumBili;
	
	/**
	 * 高危产妇管理人数
	 */
	private Integer gmaternalgNum;
	
	/**
	 * 高危产妇管理人数百分比
	 */
	private String gmaternalgNumBili;
	
	/**
	 * 高危产妇住院分娩人数
	 */
	private Integer gmaternalzNum;
	
	/**
	 * 高危产妇住院分娩人数百分比
	 */
	private String gmaternalzNumBili;

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getNoAgriculture() {
		return noAgriculture;
	}

	public void setNoAgriculture(Integer noAgriculture) {
		this.noAgriculture = noAgriculture;
	}

	public Integer getAgriculture() {
		return agriculture;
	}

	public void setAgriculture(Integer agriculture) {
		this.agriculture = agriculture;
	}

	public Integer getArchNum() {
		return archNum;
	}

	public void setArchNum(Integer archNum) {
		this.archNum = archNum;
	}

	public String getArchBili() {
		return archBili;
	}

	public void setArchBili(String archBili) {
		this.archBili = archBili;
	}

	public Integer getMornNum() {
		return mornNum;
	}

	public void setMornNum(Integer mornNum) {
		this.mornNum = mornNum;
	}

	public String getMornNumBili() {
		return mornNumBili;
	}

	public void setMornNumBili(String mornNumBili) {
		this.mornNumBili = mornNumBili;
	}

	public Integer getMidNum() {
		return midNum;
	}

	public void setMidNum(Integer midNum) {
		this.midNum = midNum;
	}

	public String getMidNumBili() {
		return midNumBili;
	}

	public void setMidNumBili(String midNumBili) {
		this.midNumBili = midNumBili;
	}

	public Integer getAfterNum() {
		return afterNum;
	}

	public void setAfterNum(Integer afterNum) {
		this.afterNum = afterNum;
	}

	public String getAfterNumBili() {
		return afterNumBili;
	}

	public void setAfterNumBili(String afterNumBili) {
		this.afterNumBili = afterNumBili;
	}

	public Integer getAcheckNum() {
		return acheckNum;
	}

	public void setAcheckNum(Integer acheckNum) {
		this.acheckNum = acheckNum;
	}

	public String getAcheckNumBili() {
		return acheckNumBili;
	}

	public void setAcheckNumBili(String acheckNumBili) {
		this.acheckNumBili = acheckNumBili;
	}

	public Integer getGacheckNum() {
		return gacheckNum;
	}

	public void setGacheckNum(Integer gacheckNum) {
		this.gacheckNum = gacheckNum;
	}

	public String getGacheckNumBili() {
		return gacheckNumBili;
	}

	public void setGacheckNumBili(String gacheckNumBili) {
		this.gacheckNumBili = gacheckNumBili;
	}

	public Integer getMcheckNum() {
		return mcheckNum;
	}

	public void setMcheckNum(Integer mcheckNum) {
		this.mcheckNum = mcheckNum;
	}

	public String getMcheckNumBili() {
		return mcheckNumBili;
	}

	public void setMcheckNumBili(String mcheckNumBili) {
		this.mcheckNumBili = mcheckNumBili;
	}

	public Integer getGmcheckNum() {
		return gmcheckNum;
	}

	public void setGmcheckNum(Integer gmcheckNum) {
		this.gmcheckNum = gmcheckNum;
	}

	public String getGmcheckNumBili() {
		return gmcheckNumBili;
	}

	public void setGmcheckNumBili(String gmcheckNumBili) {
		this.gmcheckNumBili = gmcheckNumBili;
	}

	public Integer getYcheckNum() {
		return ycheckNum;
	}

	public void setYcheckNum(Integer ycheckNum) {
		this.ycheckNum = ycheckNum;
	}

	public String getYcheckNumBili() {
		return ycheckNumBili;
	}

	public void setYcheckNumBili(String ycheckNumBili) {
		this.ycheckNumBili = ycheckNumBili;
	}

	public Integer getGycheckNum() {
		return gycheckNum;
	}

	public void setGycheckNum(Integer gycheckNum) {
		this.gycheckNum = gycheckNum;
	}

	public String getGycheckNumBili() {
		return gycheckNumBili;
	}

	public void setGycheckNumBili(String gycheckNumBili) {
		this.gycheckNumBili = gycheckNumBili;
	}

	public Integer getShcheckNum() {
		return shcheckNum;
	}

	public void setShcheckNum(Integer shcheckNum) {
		this.shcheckNum = shcheckNum;
	}

	public String getShcheckNumBili() {
		return shcheckNumBili;
	}

	public void setShcheckNumBili(String shcheckNumBili) {
		this.shcheckNumBili = shcheckNumBili;
	}

	public Integer getGwNum() {
		return gwNum;
	}

	public void setGwNum(Integer gwNum) {
		this.gwNum = gwNum;
	}

	public String getGwNumBili() {
		return gwNumBili;
	}

	public void setGwNumBili(String gwNumBili) {
		this.gwNumBili = gwNumBili;
	}

	public Integer getLookNum() {
		return lookNum;
	}

	public void setLookNum(Integer lookNum) {
		this.lookNum = lookNum;
	}

	public String getLookNumBili() {
		return lookNumBili;
	}

	public void setLookNumBili(String lookNumBili) {
		this.lookNumBili = lookNumBili;
	}

	public Integer getSystermNum() {
		return systermNum;
	}

	public void setSystermNum(Integer systermNum) {
		this.systermNum = systermNum;
	}

	public String getSystermNumBili() {
		return systermNumBili;
	}

	public void setSystermNumBili(String systermNumBili) {
		this.systermNumBili = systermNumBili;
	}

	public Integer getGmaternalNum() {
		return gmaternalNum;
	}

	public void setGmaternalNum(Integer gmaternalNum) {
		this.gmaternalNum = gmaternalNum;
	}

	public String getGmaternalNumBili() {
		return gmaternalNumBili;
	}

	public void setGmaternalNumBili(String gmaternalNumBili) {
		this.gmaternalNumBili = gmaternalNumBili;
	}

	public Integer getGmaternalgNum() {
		return gmaternalgNum;
	}

	public void setGmaternalgNum(Integer gmaternalgNum) {
		this.gmaternalgNum = gmaternalgNum;
	}

	public String getGmaternalgNumBili() {
		return gmaternalgNumBili;
	}

	public void setGmaternalgNumBili(String gmaternalgNumBili) {
		this.gmaternalgNumBili = gmaternalgNumBili;
	}

	public Integer getGmaternalzNum() {
		return gmaternalzNum;
	}

	public void setGmaternalzNum(Integer gmaternalzNum) {
		this.gmaternalzNum = gmaternalzNum;
	}

	public String getGmaternalzNumBili() {
		return gmaternalzNumBili;
	}

	public void setGmaternalzNumBili(String gmaternalzNumBili) {
		this.gmaternalzNumBili = gmaternalzNumBili;
	}

	
}
