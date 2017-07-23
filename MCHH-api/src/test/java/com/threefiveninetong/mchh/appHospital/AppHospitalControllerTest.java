package com.threefiveninetong.mchh.appHospital;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.threefiveninetong.mchh.appHospital.vo.resp.HospitalSearchCharacteristicServiceInfoRespVo;
import com.threefiveninetong.mchh.appHospital.vo.resp.HospitalSearchFirstPageInfoRespVo;
import com.threefiveninetong.mchh.appHospital.vo.resp.HospitalSearchInfoRespVo;
import com.threefiveninetong.mchh.appHospital.vo.resp.HospitalSearchSchoolCurriculumInfo2RespVo;
import com.threefiveninetong.mchh.appHospital.vo.resp.HospitalSearchSchoolCurriculumInfoRespVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.APISignUtils;
import com.threefiveninetong.mchh.util.HttpUtil;

public class AppHospitalControllerTest {
	
	/**
	 * 会员关联医院
	 */
	@Test
	public void affiliatedHospitalTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/affiliatedHospital";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "123213213");
        params.put("hospitalId", "ffff;MCHHI;sfds;wererw;1234");
        params.put("treatmentNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("archivesCode", "ffff;MCHHI;sfds;wererw;1234");
        params.put("idNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("hospitalName", "ffff;MCHHI;sfds;wererw;1234");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询医院首页展示信息
	 */
	@Test
	public void searchHospitalFirstPageInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchHospitalFirstPageInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "123213213");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        HospitalSearchFirstPageInfoRespVo vo = HttpUtil.postFormDataJson(url, params, HospitalSearchFirstPageInfoRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询医院特色服务信息
	 */
	@Test
	public void searchHospitalCharacteristicServiceInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchHospitalCharacteristicServiceInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "123213213");
        params.put("hospitalId", "123213213");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        HospitalSearchCharacteristicServiceInfoRespVo vo = HttpUtil.postFormDataJson(url, params, HospitalSearchCharacteristicServiceInfoRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询医院孕妇学校课程时间列表
	 */
	@Test
	public void searchHospitalSchoolCurriculumInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchHospitalSchoolCurriculumInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "123213213");
        params.put("hospitalId", "123213213");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        HospitalSearchSchoolCurriculumInfoRespVo vo = HttpUtil.postFormDataJson(url, params, HospitalSearchSchoolCurriculumInfoRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询医院孕妇学校课程信息
	 */
	@Test
	public void searchHospitalSchoolCurriculumInfo2Test() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchHospitalSchoolCurriculumInfo2";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "123213213");
        params.put("hospitalId", "123213213");
        params.put("date", "123213213");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        HospitalSearchSchoolCurriculumInfo2RespVo vo = HttpUtil.postFormDataJson(url, params, HospitalSearchSchoolCurriculumInfo2RespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询医院详情信息
	 */
	@Test
	public void searchHospitalInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchHospitalInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("hospitalId", "123213213");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        HospitalSearchInfoRespVo vo = HttpUtil.postFormDataJson(url, params, HospitalSearchInfoRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询会员的医院通知
	 */
	@Test
	public void searchHospitalMessageTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchHospitalMessage";
	}
	
	/**
	 * 查询会员的医院检查报告
	 */
	@Test
	public void searchHospitalReportTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchHospitalReport";
	}
}
