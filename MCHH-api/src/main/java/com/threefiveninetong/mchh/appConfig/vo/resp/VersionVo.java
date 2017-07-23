package com.threefiveninetong.mchh.appConfig.vo.resp;
/**
 * 最新版本信息
 * @author zhanght
 */
public class VersionVo {
	
	//版本名称
	private String versionName;
	
	//版本号
	private String versionCode;
	
	//更新信息
	private String updateInfo;
	
	//下载地址
	private String downloadUrl;

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public String getUpdateInfo() {
		return updateInfo;
	}

	public void setUpdateInfo(String updateInfo) {
		this.updateInfo = updateInfo;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
}
