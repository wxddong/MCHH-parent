package com.threefiveninetong.mchh.appConfig.vo.req;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;
import com.threefiveninetong.mchh.core.vo.BaseReqVo;
/**
 * 获取iphone的deviceToken请求信息
 * @author zhanght
 */
public class DeviceTokenInfoReqVo extends BaseReqVo {
	
	//iphone推送令牌
	@NotEmpty(field="deviceToken")
	private String deviceToken;

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
}
