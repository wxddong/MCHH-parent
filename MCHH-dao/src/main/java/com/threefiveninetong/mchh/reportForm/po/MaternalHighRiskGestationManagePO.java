package com.threefiveninetong.mchh.reportForm.po;

public class MaternalHighRiskGestationManagePO {

	//管理单位ID
	private String departmentId;
	//管理单位
	private String hospitalName;
	//孕产妇总数
	private int maternalNum;
	//高危产妇筛选人数 
	private int  maternalFilterNum;
	//高危产妇筛选率
	private double  maternalFilterRate;
	//高危产妇管理人数
	private int maternalManageNum;
	//高危产妇管理率
	private double maternalManageRate;
	//高危产妇上转人数
	private int turnOnNum;
	//高危产妇上转率
	private double turnOnRate;
	
	
	
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public int getMaternalNum() {
		return maternalNum;
	}
	public void setMaternalNum(int maternalNum) {
		this.maternalNum = maternalNum;
	}
	public int getMaternalFilterNum() {
		return maternalFilterNum;
	}
	public void setMaternalFilterNum(int maternalFilterNum) {
		this.maternalFilterNum = maternalFilterNum;
	}
	public double getMaternalFilterRate() {
		return maternalFilterRate;
	}
	public void setMaternalFilterRate(double maternalFilterRate) {
		this.maternalFilterRate = maternalFilterRate;
	}
	public int getMaternalManageNum() {
		return maternalManageNum;
	}
	public void setMaternalManageNum(int maternalManageNum) {
		this.maternalManageNum = maternalManageNum;
	}
	public double getMaternalManageRate() {
		return maternalManageRate;
	}
	public void setMaternalManageRate(double maternalManageRate) {
		this.maternalManageRate = maternalManageRate;
	}
	public int getTurnOnNum() {
		return turnOnNum;
	}
	public void setTurnOnNum(int turnOnNum) {
		this.turnOnNum = turnOnNum;
	}
	public double getTurnOnRate() {
		return turnOnRate;
	}
	public void setTurnOnRate(double turnOnRate) {
		this.turnOnRate = turnOnRate;
	}
	public MaternalHighRiskGestationManagePO() {
	}
	public MaternalHighRiskGestationManagePO(String departmentId, String hospitalName, int maternalNum,
			int maternalFilterNum, double maternalFilterRate, int maternalManageNum, double maternalManageRate,
			int turnOnNum, double turnOnRate) {
		super();
		this.departmentId = departmentId;
		this.hospitalName = hospitalName;
		this.maternalNum = maternalNum;
		this.maternalFilterNum = maternalFilterNum;
		this.maternalFilterRate = maternalFilterRate;
		this.maternalManageNum = maternalManageNum;
		this.maternalManageRate = maternalManageRate;
		this.turnOnNum = turnOnNum;
		this.turnOnRate = turnOnRate;
	}
	
}
