package com.threefiveninetong.mchh.appPostpartum.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.appPostpartum.controller.support.AppPostpartumControllerSupport;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumBabyBasicInfoAddReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumBabyBasicInfoUpdateReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumBabyDentitionRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumBabyGrowRecordAddReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumEarlyStageRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumEightMonthRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumFiveYearRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumFourYearRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumMomWeightRecordAddReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumOneMonthRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumOneYearRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumOneYearSixRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchBabyBasicInfoReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchBabyDentitionRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchBabyGrowRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchBabyListReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchEarlyStageRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchEightMonthRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchFirstPageInfoReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchFiveYearRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchFourYearRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchOneMonthRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchOneYearRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchOneYearSixRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchSixMonthRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchSixYearRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchThreeMonthRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchThreeYearRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchTwoYearRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchTwoYearSixRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchVaccineRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSearchWeightRecordReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSixMonthRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumSixYearRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumThreeMonthRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumThreeYearRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumTwoYearRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumTwoYearSixRecordSaveReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.req.PostpartumVaccineRecordAddReqVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumBabyBasicInfoAddRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchBabyBasicInfoRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchBabyDentitionRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchBabyGrowRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchBabyListRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchEarlyStageRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchEightMonthRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchFirstPageInfoRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchFiveYearRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchFourYearRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchOneMonthRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchOneYearRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchOneYearSixRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchSixMonthRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchSixYearRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchThreeMonthRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchThreeYearRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchTwoYearRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchTwoYearSixRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchVaccineRecordRespVo;
import com.threefiveninetong.mchh.appPostpartum.vo.resp.PostpartumSearchWeightRecordRespVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.DictionaryForApi;
/**
 * 育儿期
 * @author zhanght
 */
@Controller
@RequestMapping("/api/")
public class AppPostpartumController {
	
	@Resource
	private AppPostpartumControllerSupport appPostpartumControllerSupport;
	
	/**
	 * 添加育儿期宝宝基础信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addPostpartumBabyBasicInfo", method = RequestMethod.POST)
	public PostpartumBabyBasicInfoAddRespVo addPostpartumBabyBasicInfo(@Valid PostpartumBabyBasicInfoAddReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumBabyBasicInfoAddRespVo vo = new PostpartumBabyBasicInfoAddRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.addPostpartumBabyBasicInfo(request);
	}
	
	/**
	 * 查询育儿期基础信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumBabyBasicInfo", method = RequestMethod.POST)
	public PostpartumSearchBabyBasicInfoRespVo searchPostpartumBabyBasicInfo(@Valid PostpartumSearchBabyBasicInfoReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchBabyBasicInfoRespVo vo = new PostpartumSearchBabyBasicInfoRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumBabyBasicInfo(request);
	}
	
	/**
	 * 查询育儿期宝宝信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumBabyList", method = RequestMethod.POST)
	public PostpartumSearchBabyListRespVo searchPostpartumBabyList(@Valid PostpartumSearchBabyListReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchBabyListRespVo vo = new PostpartumSearchBabyListRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumBabyList(request);
	}
	
	/**
	 * 修改育儿期宝宝信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updatePostpartumBabyBasicInfo", method = RequestMethod.POST)
	public BaseVo updatePostpartumBabyBasicInfo(@Valid PostpartumBabyBasicInfoUpdateReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.updatePostpartumBabyBasicInfo(request);
	}
	
	/**
	 * 查询育儿期首页信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumFirstPageInfo", method = RequestMethod.POST)
	public PostpartumSearchFirstPageInfoRespVo searchPostpartumFirstPageInfo(PostpartumSearchFirstPageInfoReqVo request) {
		return appPostpartumControllerSupport.searchPostpartumFirstPageInfo(request);
	}
	
	/**
	 * 添加育儿期妈妈体重记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addPostpartumMomWeightRecord", method = RequestMethod.POST)
	public BaseVo addPostpartumMomWeightRecord(@Valid PostpartumMomWeightRecordAddReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.addPostpartumMomWeightRecord(request);
	}
	
	/**
	 * 添加育儿期宝宝生长记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addPostpartumBabyGrowRecord", method = RequestMethod.POST)
	public BaseVo addPostpartumBabyGrowRecord(@Valid PostpartumBabyGrowRecordAddReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.addPostpartumBabyGrowRecord(request);
	}
	
	/**
	 * 查询育儿期宝宝生长记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumBabyGrowRecord", method = RequestMethod.POST)
	public PostpartumSearchBabyGrowRecordRespVo searchPostpartumBabyGrowRecord(@Valid PostpartumSearchBabyGrowRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchBabyGrowRecordRespVo vo = new PostpartumSearchBabyGrowRecordRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumBabyGrowRecord(request);
	}
	
	/**
	 * 保存育儿期宝宝牙齿生长记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/savePostpartumBabyDentitionRecord", method = RequestMethod.POST)
	public BaseVo savePostpartumBabyDentitionRecord(@Valid PostpartumBabyDentitionRecordSaveReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.savePostpartumBabyDentitionRecord(request);
	}
	
	/**
	 * 查询育儿期宝宝牙齿生长记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumBabyDentitionRecord", method = RequestMethod.POST)
	public PostpartumSearchBabyDentitionRecordRespVo searchPostpartumBabyDentitionRecord(@Valid PostpartumSearchBabyDentitionRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchBabyDentitionRecordRespVo vo = new PostpartumSearchBabyDentitionRecordRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumBabyDentitionRecord(request);
	}
	
	/**
	 * 添加育儿期宝宝疫苗接种记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addPostpartumVaccineRecord", method = RequestMethod.POST)
	public BaseVo addPostpartumVaccineRecord(@Valid PostpartumVaccineRecordAddReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.addPostpartumVaccineRecord(request);
	}
	
	/**
	 * 查询育儿期宝宝疫苗接种记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumVaccineRecord", method = RequestMethod.POST)
	public PostpartumSearchVaccineRecordRespVo searchPostpartumVaccineRecord(@Valid PostpartumSearchVaccineRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchVaccineRecordRespVo vo = new PostpartumSearchVaccineRecordRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumVaccineRecord(request);
	}
	
	/**
	 * 保存育儿期新生儿早期记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/savePostpartumEarlyStageRecord", method = RequestMethod.POST)
	public BaseVo savePostpartumEarlyStageRecord(@Valid PostpartumEarlyStageRecordSaveReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.savePostpartumEarlyStageRecord(request);
	}
	
	/**
	 * 查询育儿期新生儿早期记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumEarlyStageRecord", method = RequestMethod.POST)
	public PostpartumSearchEarlyStageRecordRespVo searchPostpartumEarlyStageRecord(@Valid PostpartumSearchEarlyStageRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchEarlyStageRecordRespVo vo = new PostpartumSearchEarlyStageRecordRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumEarlyStageRecord(request);
	}
	
	/**
	 * 保存育儿期一月龄记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/savePostpartumOneMonthRecord", method = RequestMethod.POST)
	public BaseVo savePostpartumOneMonthRecord(@Valid PostpartumOneMonthRecordSaveReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.savePostpartumOneMonthRecord(request);
	}
	
	/**
	 * 保存育儿期三月龄记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/savePostpartumThreeMonthRecord", method = RequestMethod.POST)
	public BaseVo savePostpartumThreeMonthRecord(@Valid PostpartumThreeMonthRecordSaveReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.savePostpartumThreeMonthRecord(request);
	}
	
	/**
	 * 保存育儿期六月龄记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/savePostpartumSixMonthRecord", method = RequestMethod.POST)
	public BaseVo savePostpartumSixMonthRecord(@Valid PostpartumSixMonthRecordSaveReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.savePostpartumSixMonthRecord(request);
	}
	
	/**
	 * 保存育儿期八月龄记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/savePostpartumEightMonthRecord", method = RequestMethod.POST)
	public BaseVo savePostpartumEightMonthRecord(@Valid PostpartumEightMonthRecordSaveReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.savePostpartumEightMonthRecord(request);
	}
	
	/**
	 * 保存育儿期一岁记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/savePostpartumOneYearRecord", method = RequestMethod.POST)
	public BaseVo savePostpartumOneYearRecord(@Valid PostpartumOneYearRecordSaveReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.savePostpartumOneYearRecord(request);
	}
	
	/**
	 * 保存育儿期一岁六月龄记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/savePostpartumOneYearSixRecord", method = RequestMethod.POST)
	public BaseVo savePostpartumOneYearSixRecord(@Valid PostpartumOneYearSixRecordSaveReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.savePostpartumOneYearSixRecord(request);
	}
	
	/**
	 * 保存育儿期两岁记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/savePostpartumTwoYearRecord", method = RequestMethod.POST)
	public BaseVo savePostpartumTwoYearRecord(@Valid PostpartumTwoYearRecordSaveReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.savePostpartumTwoYearRecord(request);
	}
	
	/**
	 * 保存育儿期两岁六月龄记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/savePostpartumTwoYearSixRecord", method = RequestMethod.POST)
	public BaseVo savePostpartumTwoYearSixRecord(@Valid PostpartumTwoYearSixRecordSaveReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.savePostpartumTwoYearSixRecord(request);
	}
	
	/**
	 * 保存育儿期三岁记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/savePostpartumThreeYearRecord", method = RequestMethod.POST)
	public BaseVo savePostpartumThreeYearRecord(@Valid PostpartumThreeYearRecordSaveReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.savePostpartumThreeYearRecord(request);
	}
	
	/**
	 * 保存育儿期四岁记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/savePostpartumFourYearRecord", method = RequestMethod.POST)
	public BaseVo savePostpartumFourYearRecord(@Valid PostpartumFourYearRecordSaveReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();	
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.savePostpartumFourYearRecord(request);
	}
	
	/**
	 * 保存育儿期五岁记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/savePostpartumFiveYearRecord", method = RequestMethod.POST)
	public BaseVo savePostpartumFiveYearRecord(@Valid PostpartumFiveYearRecordSaveReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();	
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.savePostpartumFiveYearRecord(request);
	}
	
	/**
	 * 保存育儿期六岁记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/savePostpartumSixYearRecord", method = RequestMethod.POST)
	public BaseVo savePostpartumSixYearRecord(@Valid PostpartumSixYearRecordSaveReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();	
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.savePostpartumSixYearRecord(request);
	}
	
	/**
	 * 查询育儿期一月龄记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumOneMonthRecord", method = RequestMethod.POST)
	public PostpartumSearchOneMonthRecordRespVo searchPostpartumOneMonthRecord(@Valid PostpartumSearchOneMonthRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchOneMonthRecordRespVo vo = new PostpartumSearchOneMonthRecordRespVo();	
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumOneMonthRecord(request);
	}
	
	/**
	 * 查询育儿期三月龄记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumThreeMonthRecord", method = RequestMethod.POST)
	public PostpartumSearchThreeMonthRecordRespVo searchPostpartumThreeMonthRecord(@Valid PostpartumSearchThreeMonthRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchThreeMonthRecordRespVo vo = new PostpartumSearchThreeMonthRecordRespVo();	
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumThreeMonthRecord(request);
	}
	
	/**
	 * 查询育儿期六月龄记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumSixMonthRecord", method = RequestMethod.POST)
	public PostpartumSearchSixMonthRecordRespVo searchPostpartumSixMonthRecord(@Valid PostpartumSearchSixMonthRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchSixMonthRecordRespVo vo = new PostpartumSearchSixMonthRecordRespVo();	
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumSixMonthRecord(request);
	}
	
	/**
	 * 查询育儿期八月龄记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumEightMonthRecord", method = RequestMethod.POST)
	public PostpartumSearchEightMonthRecordRespVo searchPostpartumEightMonthRecord(@Valid PostpartumSearchEightMonthRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchEightMonthRecordRespVo vo = new PostpartumSearchEightMonthRecordRespVo();	
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumEightMonthRecord(request);
	}
	
	/**
	 * 查询育儿期一岁记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumOneYearRecord", method = RequestMethod.POST)
	public PostpartumSearchOneYearRecordRespVo searchPostpartumOneYearRecord(@Valid PostpartumSearchOneYearRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchOneYearRecordRespVo vo = new PostpartumSearchOneYearRecordRespVo();	
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumOneYearRecord(request);
	}
	
	/**
	 * 查询育儿期一岁六月记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumOneYearSixRecord", method = RequestMethod.POST)
	public PostpartumSearchOneYearSixRecordRespVo searchPostpartumOneYearSixRecord(@Valid PostpartumSearchOneYearSixRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchOneYearSixRecordRespVo vo = new PostpartumSearchOneYearSixRecordRespVo();	
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumOneYearSixRecord(request);
	}
	
	/**
	 * 查询育儿期两岁记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumTwoYearRecord", method = RequestMethod.POST)
	public PostpartumSearchTwoYearRecordRespVo searchPostpartumTwoYearRecord(@Valid PostpartumSearchTwoYearRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchTwoYearRecordRespVo vo = new PostpartumSearchTwoYearRecordRespVo();	
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumTwoYearRecord(request);
	}
	
	/**
	 * 查询育儿期两岁六月记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumTwoYearSixRecord", method = RequestMethod.POST)
	public PostpartumSearchTwoYearSixRecordRespVo searchPostpartumTwoYearSixRecord(@Valid PostpartumSearchTwoYearSixRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchTwoYearSixRecordRespVo vo = new PostpartumSearchTwoYearSixRecordRespVo();	
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumTwoYearSixRecord(request);
	}
	
	/**
	 * 查询育儿期三岁记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumThreeYearRecord", method = RequestMethod.POST)
	public PostpartumSearchThreeYearRecordRespVo searchPostpartumThreeYearRecord(@Valid PostpartumSearchThreeYearRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchThreeYearRecordRespVo vo = new PostpartumSearchThreeYearRecordRespVo();	
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumThreeYearRecord(request);
	}
	
	/**
	 * 查询育儿期四岁记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumFourYearRecord", method = RequestMethod.POST)
	public PostpartumSearchFourYearRecordRespVo searchPostpartumFourYearRecord(@Valid PostpartumSearchFourYearRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchFourYearRecordRespVo vo = new PostpartumSearchFourYearRecordRespVo();	
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumFourYearRecord(request);
	}
	
	/**
	 * 查询育儿期五岁记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumFiveYearRecord", method = RequestMethod.POST)
	public PostpartumSearchFiveYearRecordRespVo searchPostpartumFiveYearRecord(@Valid PostpartumSearchFiveYearRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchFiveYearRecordRespVo vo = new PostpartumSearchFiveYearRecordRespVo();	
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumFiveYearRecord(request);
	}
	
	/**
	 * 查询育儿期六岁记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumSixYearRecord", method = RequestMethod.POST)
	public PostpartumSearchSixYearRecordRespVo searchPostpartumSixYearRecord(@Valid PostpartumSearchSixYearRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchSixYearRecordRespVo vo = new PostpartumSearchSixYearRecordRespVo();	
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumSixYearRecord(request);
	}
	
	/**
	 * 查询育儿期妈妈的体重记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchPostpartumWeightRecord", method = RequestMethod.POST)
	public PostpartumSearchWeightRecordRespVo searchPostpartumWeightRecord(@Valid PostpartumSearchWeightRecordReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			PostpartumSearchWeightRecordRespVo vo = new PostpartumSearchWeightRecordRespVo();	
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);	
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appPostpartumControllerSupport.searchPostpartumWeightRecord(request);
	}
}
