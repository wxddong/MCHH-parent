package com.threefiveninetong.mchh.appPrenatal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.threefiveninetong.mchh.appPrenatal.vo.resp.PrenatalSearchBasicInfoRespVo;
import com.threefiveninetong.mchh.appPrenatal.vo.resp.PrenatalSearchFirstPageInfoRespVo;
import com.threefiveninetong.mchh.appPrenatal.vo.resp.PrenatalSearchSelfRecordRespVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.APISignUtils;
import com.threefiveninetong.mchh.util.HttpUtil;
import com.threefiveninetong.mchh.util.StringUtil;

public class AppPrenatalControllerTest {
	
	/**
	 * 查询孕产期首页信息
	 */
	@Test
	public void searchPrenatalFirstPageInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchPrenatalFirstPageInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        PrenatalSearchFirstPageInfoRespVo vo = HttpUtil.postFormDataJson(url, params, PrenatalSearchFirstPageInfoRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 添加孕产期基础信息
	 */
	@Test
	public void addPrenatalBasicInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/addPrenatalBasicInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("predictDate", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("lastMenses", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 修改孕产期基础信息
	 */
	@Test
	public void updatePrenatalBasicInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/updatePrenatalBasicInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("prenatalBasicId", "078D048DB6974AA2B59A1F7774402C1C");
        params.put("predictDate", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("lastMenses", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询孕产期基础信息
	 */
	@Test
	public void searchPrenatalBasicInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchPrenatalBasicInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        PrenatalSearchBasicInfoRespVo vo = HttpUtil.postFormDataJson(url, params, PrenatalSearchBasicInfoRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 添加孕产期体重记录
	 */
	@Test
	public void addPrenatalWeightRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/addPrenatalWeightRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("prenatalBmi", "12");
        params.put("weight", "75");
        params.put("weightGain", "2");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 添加孕产期胎动记录
	 */
	@Test
	public void addPrenatalFetalMovementRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/addPrenatalFetalMovementRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("moveNum", "76");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 添加孕产期孕妇学校听课记录
	 */
	@Test
	public void addPrenatalLectureRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/addPrenatalLectureRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("subjects", "宝宝生长秘籍");
        params.put("content", "12321321");
        params.put("lectureTime", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("remark", "哈哈");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询孕产期其他信息
	 */
	@Test
	public void searchPrenatalSelfRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchPrenatalSelfRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("period", "0");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        PrenatalSearchSelfRecordRespVo vo = HttpUtil.postFormDataJson(url, params, PrenatalSearchSelfRecordRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 保存孕产期其他信息
	 */
	@Test
	public void savePrenatalSelfRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/savePrenatalSelfRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("lastMenses", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("predictDate", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("firstMoveDate", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("bExaDate", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("testMoveSign", "1");
        params.put("growthRange", "1");
        params.put("riskSign", "0");
        params.put("period", "0");
        List<String> specialList = new ArrayList<String>();
        specialList.add("3");
        specialList.add("4");
        //params.put("specialList", (Object)specialList);
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
}
