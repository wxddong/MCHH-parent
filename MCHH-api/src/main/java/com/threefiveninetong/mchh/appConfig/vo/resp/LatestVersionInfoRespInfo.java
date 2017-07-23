package com.threefiveninetong.mchh.appConfig.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;
/**
 * 获取最新版本响应信息
 * @author zhanght
 */
public class LatestVersionInfoRespInfo extends BaseVo {
	
	//最新版本信息
	private VersionVo versionInfo;

	public VersionVo getVersionInfo() {
		return versionInfo;
	}

	public void setVersionInfo(VersionVo versionInfo) {
		this.versionInfo = versionInfo;
	}
}
