package com.threefiveninetong.mchh.appPostpartum;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchBabyBasicInfoRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchBabyDentitionRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchBabyGrowRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchBabyListRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchEarlyStageRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchFirstPageInfoRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchOneMonthRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchVaccineRecordRespVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.APISignUtils;
import com.threefiveninetong.mchh.util.HttpUtil;
import com.threefiveninetong.mchh.util.StringUtil;

public class AppPostpartumControllerTest {
	
	/**
	 * 添加育儿期宝宝基础信息
	 * @throws Exception 
	 */
	@Test
	public void addPostpartumBabyBasicInfoTest(){
		String url = "http://127.0.0.1:8080/MCHH-api/api/addPostpartumBabyBasicInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        
        
        params.put("babyList[0].birthday", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("babyList[0].name", "周照");
        params.put("babyList[0].sex", "1");
        params.put("babyList[0].birthTime", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("babyList[0].height", "123");
        params.put("babyList[0].weight", "23");
        params.put("babyList[0].birthGesWeeks", "12");
        params.put("babyList[0].birthPlace", "湖南");
        params.put("babyList[0].deliveryMec", "北京精神病院");
        
        PostpartumSearchBabyListRespVo vo = HttpUtil.postFormDataJson(url, params, PostpartumSearchBabyListRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	
	/**
	 * 查询育儿期基础信息
	 */
	@Test
	public void searchPostpartumBabyBasicInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchPostpartumBabyBasicInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        PostpartumSearchBabyBasicInfoRespVo vo = HttpUtil.postFormDataJson(url, params, PostpartumSearchBabyBasicInfoRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询育儿期宝宝信息
	 */
	@Test
	public void searchPostpartumBabyListTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchPostpartumBabyList";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        PostpartumSearchBabyListRespVo vo = HttpUtil.postFormDataJson(url, params, PostpartumSearchBabyListRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 修改育儿期宝宝信息
	 */
	@Test
	public void updatePostpartumBabyBasicInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/updatePostpartumBabyBasicInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        
        params.put("babyInfo.babyInfoId", "1062AEA9896F431A97640D90DA0413A3");
        params.put("babyInfo.birthday", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("babyInfo.name", "周照X");
        params.put("babyInfo.sex", "1");
        params.put("babyInfo.birthTime", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("babyInfo.height", "1111");
        params.put("babyInfo.weight", "111");
        params.put("babyInfo.birthGesWeeks", "111");
        params.put("babyInfo.birthPlace", "益阳");
        params.put("babyInfo.deliveryMec", "益阳精神病院");
        
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询育儿期首页信息
	 */
	@Test
	public void searchPostpartumFirstPageInfoTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchPostpartumFirstPageInfo";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("babyInfoId", "1062AEA9896F431A97640D90DA0413A3");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        PostpartumSearchFirstPageInfoRespVo vo = HttpUtil.postFormDataJson(url, params, PostpartumSearchFirstPageInfoRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 添加育儿期妈妈体重记录
	 */
	@Test
	public void addPostpartumMomWeightRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/addPostpartumMomWeightRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("babyInfoId", "1062AEA9896F431A97640D90DA0413A3");
        params.put("prenatalBmi", "1");
        params.put("weight", "15");
        params.put("height", "112");
        params.put("bmi", "0.3");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 添加育儿期宝宝生长记录
	 */
	@Test
	public void addPostpartumBabyGrowRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/addPostpartumBabyGrowRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("babyInfoId", "1062AEA9896F431A97640D90DA0413A3");
        params.put("weight", "11");
        params.put("height", "19");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询育儿期宝宝的生长记录
	 */
	@Test
	public void searchPostpartumBabyGrowRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchPostpartumBabyGrowRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("babyInfoId", "1062AEA9896F431A97640D90DA0413A3");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        PostpartumSearchBabyGrowRecordRespVo vo = HttpUtil.postFormDataJson(url, params, PostpartumSearchBabyGrowRecordRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 保存育儿期宝宝的牙齿生长记录
	 */
	@Test
	public void savePostpartumBabyDentitionRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/savePostpartumBabyDentitionRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("babyInfoId", "1062AEA9896F431A97640D90DA0413A3");
        
        params.put("babyToochGrowList[0].position", "0");
        params.put("babyToochGrowList[0].toothingDate", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询育儿期宝宝的牙齿生长记录
	 */
	@Test
	public void searchPostpartumBabyDentitionRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchPostpartumBabyDentitionRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("babyInfoId", "1062AEA9896F431A97640D90DA0413A3");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        PostpartumSearchBabyDentitionRecordRespVo vo = HttpUtil.postFormDataJson(url, params, PostpartumSearchBabyDentitionRecordRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 添加育儿期宝宝的疫苗接种记录
	 */
	@Test
	public void addPostpartumVaccineRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/addPostpartumVaccineRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("babyInfoId", "1062AEA9896F431A97640D90DA0413A3");
        params.put("vaccineList[0]", "0");
        params.put("vaccineList[1]", "1");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询育儿期宝宝的疫苗接种记录
	 */
	@Test
	public void searchPostpartumVaccineRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchPostpartumVaccineRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("babyInfoId", "1062AEA9896F431A97640D90DA0413A3");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        PostpartumSearchVaccineRecordRespVo vo = HttpUtil.postFormDataJson(url, params, PostpartumSearchVaccineRecordRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 保存育儿期新生儿早期记录
	 */
	@Test
	public void savePostpartumEarlyStageRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/savePostpartumEarlyStageRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("babyInfoId", "1062AEA9896F431A97640D90DA0413A3");
        params.put("diseaseScreening", "0");
        params.put("hearingScreening", "0");
        params.put("earlyStageDetails.birthDays", "2");
        params.put("earlyStageDetails.feedingMode", "0");
        params.put("earlyStageDetails.milkNum", "5");
        params.put("earlyStageDetails.urineNum", "2");
        params.put("earlyStageDetails.shitNum", "3");
        params.put("earlyStageDetails.weight", "30");
        params.put("earlyStageDetails.jaundice", "0");
        params.put("earlyStageDetails.createTime", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询育儿期新生儿早期记录
	 */
	@Test
	public void searchPostpartumEarlyStageRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchPostpartumEarlyStageRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("babyInfoId", "1062AEA9896F431A97640D90DA0413A3");
        params.put("type", "1");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        PostpartumSearchEarlyStageRecordRespVo vo = HttpUtil.postFormDataJson(url, params, PostpartumSearchEarlyStageRecordRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 保存育儿期一月龄记录
	 */
	@Test
	public void savePostpartumOneMonthRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/savePostpartumOneMonthRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("babyInfoId", "1062AEA9896F431A97640D90DA0413A3");
        params.put("umbilicalTime", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("jaundiceFadeTime", StringUtil.valueOf(System.currentTimeMillis()));
        params.put("feedingMode", "0");
        params.put("feedingSituation", "1");
        params.put("frightCry", "0");
        params.put("crying", "0");
        params.put("vSupplement", "0");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        BaseVo vo = HttpUtil.postFormDataJson(url, params, BaseVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
	
	/**
	 * 查询育儿期一月龄记录
	 */
	@Test
	public void searchPostpartumOneMonthRecordTest() {
		String url = "http://127.0.0.1:8080/MCHH-api/api/searchPostpartumOneMonthRecord";
        Map<String, String> params = new HashMap<String, String>();
        params.put("terminalNo", "ffff;MCHHI;sfds;wererw;1234");
        params.put("memberId", "09ED0A50E99C452CBCC13CD8BD622943");
        params.put("babyInfoId", "1062AEA9896F431A97640D90DA0413A3");
        params.put("sign", APISignUtils.getSign(params, "1d0a49CbD359F533c9121C1Ee9cBE4FC"));
        PostpartumSearchOneMonthRecordRespVo vo = HttpUtil.postFormDataJson(url, params, PostpartumSearchOneMonthRecordRespVo.class);
        System.out.println("状态码："+vo.getStatusCode()+"   提示："+vo.getMessage());
	}
}
