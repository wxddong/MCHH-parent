package com.threefiveninetong.mchh.appConfig.vo.resp;

import com.threefiveninetong.mchh.core.vo.BaseVo;
/**
 * 获取统一配置响应信息
 * @author zhanght
 */
public class UniformConfigInfoRespVo extends BaseVo {
	
	//广告图片地址
	private String imageUrl = "";
	
	//是否需要强制升级：0-不需要  1-需要
	private String forcedUpdateSign = "";
	
	//最新版本信息
	private VersionVo versionInfo;
	
	public UniformConfigInfoRespVo() {
		imageUrl = "";
		forcedUpdateSign = "";
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getForcedUpdateSign() {
		return forcedUpdateSign;
	}

	public void setForcedUpdateSign(String forcedUpdateSign) {
		this.forcedUpdateSign = forcedUpdateSign;
	}

	public VersionVo getVersionInfo() {
		return versionInfo;
	}

	public void setVersionInfo(VersionVo versionInfo) {
		this.versionInfo = versionInfo;
	}
}
