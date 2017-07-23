package com.threefiveninetong.mchh.appMember.controller.support;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.threefiveninetong.mchh.app.service.AppMemberHandleService;
import com.threefiveninetong.mchh.appConfig.po.AppExpertGuidancePO;
import com.threefiveninetong.mchh.appConfig.service.AppExpertGuidanceService;
import com.threefiveninetong.mchh.appMember.po.AppMbrMessageInfoPO;
import com.threefiveninetong.mchh.appMember.po.AppMemberPO;
import com.threefiveninetong.mchh.appMember.po.AppMoodRecordPO;
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
import com.threefiveninetong.mchh.appMember.vo.resp.MemberMoodRecordAddRespVo;
import com.threefiveninetong.mchh.appMember.vo.resp.MemberMoodRecordByDayInfoRespVo;
import com.threefiveninetong.mchh.appMember.vo.resp.MemberRegisterRespVo;
import com.threefiveninetong.mchh.appMember.vo.resp.MemberSearchBasicInfoRespVo;
import com.threefiveninetong.mchh.appMember.vo.resp.MemberSearchExpertGuidanceRespVo;
import com.threefiveninetong.mchh.appMember.vo.resp.MoodRecordVo;
import com.threefiveninetong.mchh.common.CommonAssembleSupport;
import com.threefiveninetong.mchh.core.vo.BasePageVo;
import com.threefiveninetong.mchh.core.vo.BaseVo;
import com.threefiveninetong.mchh.util.BeanUtil;
import com.threefiveninetong.mchh.util.DictionaryForApi;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.util.StringUtil;

@Component
public class AppMemberControllerSupport {
	
	@Resource
	private AppMemberHandleService appMemberHandleService;
	
	@Resource
	AppExpertGuidanceService appExpertGuidanceService;
	
	/**
	 * 会员注册
	 * @param request
	 * @return
	 */
	public MemberRegisterRespVo memberRegister(MemberRegisterReqVo request) {
		MemberRegisterRespVo respInfo = new MemberRegisterRespVo();
		Map<String,Object> respMap = appMemberHandleService.memberRegister(request.getTerminalNo(), request.getUserName(), request.getPassword());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				//会员ID
				String memberId = (String) respMap.get("memberId");
				if (!StringUtil.isNullOrBlank(memberId)) {
					respInfo.setMemberId(memberId);
				}
			}
		}	
		return respInfo;
	}
	
	/**
	 * 会员登录
	 * @param request
	 * @return
	 */
	public MemberLoginRespVo memberLogin(MemberLoginReqVo request) {
		MemberLoginRespVo respInfo = new MemberLoginRespVo();
		Map<String,Object> respMap = appMemberHandleService.memberLogin(request.getTerminalNo(), request.getUserName(), request.getPassword());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				AppMemberPO mbrInfo = (AppMemberPO) respMap.get("mbrInfo");
				respInfo.setMemberId(mbrInfo.getId());
				respInfo.setNickName(mbrInfo.getNickName());
				respInfo.setCurrentStage(StringUtil.isNullOrBlank(mbrInfo.getCurrentStage())?"":mbrInfo.getCurrentStage());
				respInfo.setParId(StringUtil.isNullOrBlank(mbrInfo.getParId())?"":mbrInfo.getParId());
				if (!StringUtil.isNullOrBlank(StringUtil.valueOf(respMap.get("imageUrl")))) {
					respInfo.setImageUrl(StringUtil.valueOf(respMap.get("imageUrl")));
				}
			}
		}	
		return respInfo;
	}
	
	/**
	 * 会员修改密码
	 * @param request
	 * @return
	 */
	public BaseVo resetPassword(MemberResetPwdReqVo request) {
		return BeanUtil.mapToBean(appMemberHandleService.memberResetPassword(request.getTerminalNo(), request.getMemberId(), request.getOldPwd(),request.getNewPwd()), BaseVo.class);
	}
	
	/**
	 * 意见反馈
	 * @param request
	 * @return
	 */
	public BaseVo feedback(MemberFeedbackReqVo request) {
		BaseVo vo = new BaseVo();
		Map<String,Object> respMap = appMemberHandleService.feedback(request.getTerminalNo(), request.getMemberId(), request.getContent());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			vo.setStatusCode(statusCode);
			vo.setMessage(StringUtil.valueOf(respMap.get("message")));
		}
		return vo;
	}
	
	/**
	 * 会员添加心情语录
	 * @param request
	 * @return
	 */
	public MemberMoodRecordAddRespVo addMoodRecord(MemberMoodRecordAddReqVo request) {
		return BeanUtil.mapToBean(appMemberHandleService.addMoodRecord(BeanUtil.beanToMap(request)), MemberMoodRecordAddRespVo.class);
		
	}
	
	/**
	 * 会员查询心情语录信息
	 * @param request
	 * @return
	 */
	public BasePageVo<MoodRecordVo> getMoodRecordList(MemberMoodRecordListReqVo request) {
		BasePageVo<MoodRecordVo> respInfo = new BasePageVo<MoodRecordVo>();
		Map<String,Object> respMap = appMemberHandleService.getMoodRecordList(request.getMemberId(),request.getType(),request.getRows(),request.getPage());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				Page<AppMoodRecordPO> page = (Page<AppMoodRecordPO>)respMap.get("page");
				respInfo = new BasePageVo<MoodRecordVo>(page.getPage(), page.getRows(), page.getTotal(),CommonAssembleSupport.assembleGetMoodRecordList(page.getList()));
			}
		}		
		return respInfo;
	}
	
	/**
	 * 会员查询一条的心情语录信息 -- 不做
	 * @param request
	 * @return
	 */
	public MemberMoodRecordByDayInfoRespVo getMoodRecordByDayInfo(MemberMoodRecordByDayInfoReqVo request) {
		return null;
	}
	
	/**
	 * 修改心情语录信息
	 * @param request
	 * @return
	 */
	public BaseVo updateMoodRecord(MemberMoodRecordUpdateReqVo request) {
		return BeanUtil.mapToBean(appMemberHandleService.updateMoodRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 删除心情语录信息
	 * 
	 * @param request
	 * @return
	 */
	public BaseVo deleteMoodRecord(MemberMoodRecordDeleteReqVo request) {
		return BeanUtil.mapToBean(appMemberHandleService.deleteMoodRecord(BeanUtil.beanToMap(request)), BaseVo.class);
	}
	
	/**
	 * 查询会员接受的通知接口
	 * @param request
	 * @return
	 */
	public BasePageVo<MbrMessageVo> searchMbrMessageList(MemberSearchMessageListReqVo request) {
		BasePageVo<MbrMessageVo> respInfo = new BasePageVo<MbrMessageVo>();
		Map<String,Object> respMap = appMemberHandleService.searchMbrMessageList(request.getMemberId(),request.getType(),request.getRows(),request.getPage());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				Page<AppMbrMessageInfoPO> page = (Page<AppMbrMessageInfoPO>)respMap.get("page");
				respInfo = new BasePageVo<MbrMessageVo>(page.getPage(), page.getRows(), page.getTotal(),CommonAssembleSupport.assembleSearchHospitalMessage(page.getList()));
			}
		}		
		return respInfo;
	}
	
	/**
	 * 会员查询专家指导信息
	 * @param request
	 * @return
	 */
	public MemberSearchExpertGuidanceRespVo searchExpertGuidance(MemberSearchExpertGuidanceReqVo request) {
		MemberSearchExpertGuidanceRespVo respInfo = new MemberSearchExpertGuidanceRespVo();
		Map<String,Object> respMap = appMemberHandleService.findAppExpertGuidanceListByClassification(request.getClassification());
		
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				//封装专家指导信息
				respInfo.setExpertGuidanceList(CommonAssembleSupport.assembleExpertGuidanceVo((List<AppExpertGuidancePO>) respMap.get("expertGuidanceList"), statusCode));
			}
		}
		return respInfo;
	}
	
	/**
	 * 查询会员的详细信息
	 * @param request
	 * @return
	 */
	public MemberSearchBasicInfoRespVo searchMemberBasicInfo(MemberSearchBasicInfoReqVo request) {
		MemberSearchBasicInfoRespVo respInfo = new MemberSearchBasicInfoRespVo();
		//根据会员id查询会员信息
		Map<String,Object> respMap = appMemberHandleService.searchMemberBasicInfo(request.getMemberId());
		String statusCode = StringUtil.valueOf(respMap.get("statusCode"));
		if (!StringUtil.isNullOrBlank(statusCode)) {
			respInfo.setStatusCode(statusCode);
			respInfo.setMessage(StringUtil.valueOf(respMap.get("message")));
			if (statusCode.equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				AppMemberPO mbrInfo = (AppMemberPO) respMap.get("appMemberPO");
				respInfo.setImageUrl(StringUtil.valueOf(respMap.get("imageUrl")));//头像图片地址
				respInfo.setUserName(mbrInfo.getUserName());//用户名
				respInfo.setNickName(mbrInfo.getNickName());//昵称
				respInfo.setSex(mbrInfo.getSex());//性别
				respInfo.setBloodType(mbrInfo.getBloodType());//血型
				if (null != mbrInfo.getBirthday())
					respInfo.setBirthday(StringUtil.valueOf(mbrInfo.getBirthday().getTime()));//生日
				respInfo.setSignature(mbrInfo.getSignature());//个性签名
			}
		}
		return respInfo;
	}
	
	/**
	 * 修改会员基本信息
	 * @param request
	 * @return
	 */
	public BaseVo updatMemberBasicInfo(MemberBasicInfoUpdateReqVo request,HttpServletRequest reqImg) {
		return BeanUtil.mapToBean(appMemberHandleService.updatMemberBasicInfo(request.getMemberId(),request.getContent(),request.getType(),reqImg), BaseVo.class);
	}
}
