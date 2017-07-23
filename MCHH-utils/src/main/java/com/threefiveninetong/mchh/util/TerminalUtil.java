package com.threefiveninetong.mchh.util;

/** 
 * @ClassName: TerminalUtil 
 * @Description: TODO
 * @author: jixf
 * @date: 2016年2月3日 上午10:32:22  
 */
public class TerminalUtil {
	
	/**
	 * @Title: parse 
	 * @Description: TODO 解析terminal
	 * @param: @param terminalNo 
	 * @param: @return
	 * @return: TerminalInfo
	 */
	public static TerminalInfo parse(String terminalNo){
		return new TerminalInfo(terminalNo);
	}
	
	/** 
	 * @Title: isIosTerminal 
	 * @Description: TODO 判断是否是ios终端
	 * @param: @param terminalNo
	 * @param: @return
	 * @return: TerminalInfo
	 * @throws
	 */
	public static Boolean isIosTerminal(String terminalNo){
		if(StringUtil.isNull(terminalNo))
			return false;
		
		String[] terminalArr = terminalNo.split(";");
		
		if(terminalArr!=null&&terminalArr.length>=4&&terminalArr[3]!=null)
			return terminalArr[3].toLowerCase().contains("iphone");
		
		return false;
	}
	
	public static class TerminalInfo{
		private String versionCode;// 版本号
		private String channelNo;// 渠道号
		private String equipmentNo;// 设备号
		private String equipmentSysVersion;// 设备系统版本号
		private String equipmentModel;// 设备型号
		
		public TerminalInfo(){}
		
		public TerminalInfo(String terminalNo){
			if(StringUtil.isNull(terminalNo))
				return;
			
			String[] terminalArr = terminalNo.split(";");
			if(null != terminalArr){
				if(terminalArr.length>=1){
					this.equipmentNo = terminalArr[0];// 设备号
				}
				if(terminalArr.length>=2){
					this.channelNo = terminalArr[1];// 设备号
				}
				if(terminalArr.length>=3){
					this.equipmentSysVersion = terminalArr[2];// 设备系统版本号
				}
				if(terminalArr.length>=4){
					this.equipmentModel = terminalArr[3];// 设备型号
				}
			}
		}
		
		public String getVersionCode() {
			return versionCode;
		}
		public void setVersionCode(String versionCode) {
			this.versionCode = versionCode;
		}
		public String getChannelNo() {
			return channelNo;
		}
		public void setChannelNO(String channelNo) {
			this.channelNo = channelNo;
		}
		public String getEquipmentNo() {
			return equipmentNo;
		}
		public void setEquipmentNo(String equipmentNo) {
			this.equipmentNo = equipmentNo;
		}
		public String getEquipmentSysVersion() {
			return equipmentSysVersion;
		}
		public void setEquipmentSysVersion(String equipmentSysVersion) {
			this.equipmentSysVersion = equipmentSysVersion;
		}
		public String getEquipmentModel() {
			return equipmentModel;
		}
		public void setEquipmentModel(String equipmentModel) {
			this.equipmentModel = equipmentModel;
		}
	}
	
}
