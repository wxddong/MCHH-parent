package com.threefiveninetong.mchh.appMember.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.appMember.controller.support.AppMemberControllerSupport;
import com.threefiveninetong.mchh.appMember.vo.req.MemberBasicInfoUpdateReqVo;
import com.threefiveninetong.mchh.appMember.vo.req.MemberFeedbackReqVo;
import com.threefiveninetong.mchh.appMember.vo.req.MemberLoginReqVo;
import com.threefiveninetong.mchh.appMember.vo.req.MemberMoodRecordAddReqVo;
import com.threefiveninetong.mchh.appMember.vo.req.MemberMoodRecordByDayInfoReqVo;
import com.threefiveninetong.mchh.appMember.vo.req.MemberMoodRecordDeleteReqVo;
import com.threefiveninetong.mchh.appMember.vo.req.MemberMoodRecordListReqVo;
import com.threefiveninetong.mchh.appMember.vo.req.MemberMoodRecordUpdateReqVo;
import com.threefiveninetong.mchh.appMember.vo.req.MemberRegisterReqVo;
import com.threefiveninetong.mchh.appMember.vo.req.MemberResetPwdReqVo;
import com.threefiveninetong.mchh.appMember.vo.req.MemberSearchBasicInfoReqVo;
import com.threefiveninetong.mchh.appMember.vo.req.MemberSearchExpertGuidanceReqVo;
import com.threefiveninetong.mchh.appMember.vo.req.MemberSearchMessageListReqVo;
import com.threefiveninetong.mchh.appMember.vo.resp.MbrMessageVo;
import com.threefiveninetong.mchh.appMember.vo.resp.MemberLoginRespVo;
import com.threefiveninetong.mchh.appMember.vo.resp.MemberMoodRecordByDayInfoRespVo;
import com.threefiveninetong.mchh.appMember.vo.resp.MemberRegisterRespVo;
import com.threefiveninetong.mchh.appMember.vo.resp.MemberSearchBasicInfoRespVo;
import com.threefiveninetong.mchh.appMember.vo.resp.MemberSearchExpertGuidanceRespVo;
import com.threefiveninetong.mchh.appMember.vo.resp.MoodRecordVo;
import com.threefiveninetong.mchh.core.vo.BasePageVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.DictionaryForApi;

@Controller
@RequestMapping("/api/")
public class AppMemberController {
	
	@Resource
	private AppMemberControllerSupport appMemberControllerSupport;
	
	/**
	 * 会员注册
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/memberRegister", method = RequestMethod.POST)
	public MemberRegisterRespVo memberRegister(@Valid MemberRegisterReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			MemberRegisterRespVo vo = new MemberRegisterRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appMemberControllerSupport.memberRegister(request);
	}
	
	/**
	 * 会员登录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/memberLogin", method = RequestMethod.POST)
	public MemberLoginRespVo memberLogin(@Valid MemberLoginReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			MemberLoginRespVo vo = new MemberLoginRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appMemberControllerSupport.memberLogin(request);
	}
	
	/**
	 * 会员修改密码
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public BaseVo resetPassword(@Valid MemberResetPwdReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appMemberControllerSupport.resetPassword(request);
	}
	
	/**
	 * 意见反馈
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/feedback", method = RequestMethod.POST)
	public BaseVo feedback(@Valid MemberFeedbackReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appMemberControllerSupport.feedback(request);
	}
	
	/**
	 * 会员添加心情语录
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addMoodRecord", method = RequestMethod.POST)
	public BaseVo addMoodRecord(@Valid MemberMoodRecordAddReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appMemberControllerSupport.addMoodRecord(request);
	}
	
	/**
	 * 会员查询心情语录信息
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getMoodRecordList", method = RequestMethod.POST)
	public BasePageVo<MoodRecordVo> getMoodRecordList(@Valid MemberMoodRecordListReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BasePageVo<MoodRecordVo> vo = new BasePageVo<MoodRecordVo>();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appMemberControllerSupport.getMoodRecordList(request);
	}
	
	
	/**
	 * 会员查询一天的心情语录信息
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getMoodRecordByDayInfo", method = RequestMethod.POST)
	public MemberMoodRecordByDayInfoRespVo getMoodRecordByDayInfo(@Valid MemberMoodRecordByDayInfoReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			MemberMoodRecordByDayInfoRespVo vo = new MemberMoodRecordByDayInfoRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appMemberControllerSupport.getMoodRecordByDayInfo(request);
	}
	
	/**
	 * 修改心情语录信息
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateMoodRecord", method = RequestMethod.POST)
	public BaseVo updateMoodRecord(@Valid MemberMoodRecordUpdateReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appMemberControllerSupport.updateMoodRecord(request);
	}
	
	/**
	 * 删除心情语录信息
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteMoodRecord", method = RequestMethod.POST)
	public BaseVo deleteMoodRecord(@Valid MemberMoodRecordDeleteReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appMemberControllerSupport.deleteMoodRecord(request);
	}
	
	/**
	 * 查询会员接受的通知接口
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchMbrMessageList", method = RequestMethod.POST)
	public BasePageVo<MbrMessageVo> searchMbrMessageList(@Valid MemberSearchMessageListReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			BasePageVo<MbrMessageVo> vo = new BasePageVo<MbrMessageVo>();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appMemberControllerSupport.searchMbrMessageList(request);
	}
	
	/**
	 * 查询专家指导信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchExpertGuidance", method = RequestMethod.POST)
	public MemberSearchExpertGuidanceRespVo searchExpertGuidance(@Valid MemberSearchExpertGuidanceReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			MemberSearchExpertGuidanceRespVo vo = new MemberSearchExpertGuidanceRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appMemberControllerSupport.searchExpertGuidance(request);
	}
	
	/**
	 * 查询会员基本信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/searchMemberBasicInfo", method = RequestMethod.POST)
	public MemberSearchBasicInfoRespVo searchMemberBasicInfo(@Valid MemberSearchBasicInfoReqVo request, BindingResult result) {
		if (result.hasErrors()) {
			MemberSearchBasicInfoRespVo vo = new MemberSearchBasicInfoRespVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appMemberControllerSupport.searchMemberBasicInfo(request);
	}
	
	/**
	 * 修改会员基本信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updatMemberBasicInfo", method = RequestMethod.POST)
	public BaseVo updatMemberBasicInfo(@Valid MemberBasicInfoUpdateReqVo request, BindingResult result,HttpServletRequest reqImg) {
		if (result.hasErrors()) {
			BaseVo vo = new BaseVo();
            FieldError fieldError = result.getFieldError();	
            vo.setStatusCode(DictionaryForApi.RESP_CODE_EXP_PARAMETER);
            vo.setMessage(fieldError.getDefaultMessage());
            return vo;
        }
		return appMemberControllerSupport.updatMemberBasicInfo(request,reqImg);
	}
}
