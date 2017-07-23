package com.threefiveninetong.mchh.appConfig;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.threefiveninetong.mchh.appConfig.vo.resp.LatestVersionInfoRespInfo;
import com.threefiveninetong.mchh.appConfig.vo.resp.UniformConfigInfoRespVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.APISignUtils;
import com.threefiveninetong.mchh.util.HttpUtil;

public class AppConfigControllerTest {
	
	/**
	 * 获取统一配置信息
	 */
	@Test
	public void getUniformConfigInfoTest() {
		String url = "http://106.2.212.50:5555/MCHH-api/api/getUniformConfigInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        UniformConfigInfoRespVo vo = HttpUtil.postFormDataJson(url, params, UniformConfigInfoRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 获取最新版本信息
	 */
	@Test
	public void getLatestVersionInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/getLatestVersionInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        LatestVersionInfoRespInfo vo = HttpUtil.postFormDataJson(url, params, LatestVersionInfoRespInfo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 获取iphone的deviceToken信息
	 */
	@Test
	public void getDeviceTokenInfo() {
		String url = "http://locahost:8080/MCHH-api/api/getDeviceTokenInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("deviceToken", "123213");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
}
