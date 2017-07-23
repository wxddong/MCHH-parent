package com.threefiveninetong.mchh.appPremarital;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.threefiveninetong.mchh.appPremarital.vo.resp.PremaritalBasicAddRespVo;
import com.threefiveninetong.mchh.appPremarital.vo.resp.PremaritalBasicSearchInfoRespVo;
import com.threefiveninetong.mchh.appPremarital.vo.resp.PremaritalSearchFirstPageInfoRespVo;
import com.threefiveninetong.mchh.appPremarital.vo.resp.PremaritalSearchOtherInfoRespVo;
import com.threefiveninetong.mchh.appPremarital.vo.resp.PremaritalSearchTemperatureRecordRespVo;
import com.threefiveninetong.mchh.appPremarital.vo.resp.PremaritalSearchWeightRecordRespVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.APISignUtils;
import com.threefiveninetong.mchh.util.HttpUtil;
import com.threefiveninetong.mchh.util.StringUtil;

public class AppPremaritalControllerTest {
	
	/**
	 * 查询备孕期首页信息
	 */
	@Test
	public void searchPremaritalFirstPageInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchPremaritalFirstPageInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622941");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        PremaritalSearchFirstPageInfoRespVo vo = HttpUtil.postFormDataJson(url, params, PremaritalSearchFirstPageInfoRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 添加备孕期基础信息
	 */
	@Test
	public void addPremaritalBasicInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/addPremaritalBasicInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("lastMenses", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("period", "5");
        params.put("menstrualCycle", "25");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        PremaritalBasicAddRespVo vo = HttpUtil.postFormDataJson(url, params, PremaritalBasicAddRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 修改备孕期基础信息
	 */
	@Test
	public void updatePremaritalBasicInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/updatePremaritalBasicInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("premaritalBasicId", "92F50EB370224EB7812F3D740310053D");
        params.put("lastMenses", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("period", "3");
        params.put("menstrualCycle", "22");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询备孕期基础信息
	 */
	@Test
	public void searchPremaritalBasicInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchPremaritalBasicInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        PremaritalBasicSearchInfoRespVo vo = HttpUtil.postFormDataJson(url, params, PremaritalBasicSearchInfoRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 添加备孕期体重记录
	 */
	@Test
	public void addPremaritalWeightRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/addPremaritalWeightRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("weight", "75");
        params.put("height", "175");
        params.put("bmi", "2");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询备孕期体温记录
	 */
	@Test
	public void searchPremaritalTemperatureRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchPremaritalTemperatureRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        PremaritalSearchTemperatureRecordRespVo vo = HttpUtil.postFormDataJson(url, params, PremaritalSearchTemperatureRecordRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 添加备孕期体温记录
	 */
	@Test
	public void addPremaritalTemperatureRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/addPremaritalTemperatureRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("temperature", "36");
        params.put("periodSign", "0");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 保存备孕期其他信息
	 */
	@Test
	public void savePremaritalOtherInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/savePremaritalOtherInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("dadAge", "35");
        params.put("momAge", "35");
        params.put("planTime", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("dadHealthy", "1");
        params.put("momHealthy", "1");
        params.put("dadHealthyRemark", "哈哈哈");
        params.put("momHealthyRemark", "哈哈哈");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询备孕期其他信息
	 */
	@Test
	public void searchPremaritalOtherInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchPremaritalOtherInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        PremaritalSearchOtherInfoRespVo vo = HttpUtil.postFormDataJson(url, params, PremaritalSearchOtherInfoRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询备孕期妈妈的体重记录
	 */
	@Test
	public void searchPremaritalWeightRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchPremaritalWeightRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        PremaritalSearchWeightRecordRespVo vo = HttpUtil.postFormDataJson(url, params, PremaritalSearchWeightRecordRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
}
