package com.threefiveninetong.mchh.app.validate;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appHospital.po.AppAffiliatedHospitalInfoPO;
import com.threefiveninetong.mchh.appHospital.service.AppAffiliatedHospitalInfoService;
import com.threefiveninetong.mchh.appMember.po.AppMemberPO;
import com.threefiveninetong.mchh.appMember.service.AppMemberService;
import com.threefiveninetong.mchh.appPostpartum.po.AppBabyBasicInfoPO;
import com.threefiveninetong.mchh.appPostpartum.service.AppBabyBasicInfoService;
import com.threefiveninetong.mchh.util.DictionaryForApi;
import com.threefiveninetong.mchh.util.DictionaryForApi.EffectStatus;
import com.threefiveninetong.mchh.util.DictionaryForApi.StageStatus;
import com.threefiveninetong.mchh.util.MapUtil;
import com.threefiveninetong.mchh.util.StringUtil;
import com.threefiveninetong.mchh.util.SystemException;

@Service
public class AppPostpartumValidateService {
	
	//育儿期逻辑处理日志
	public static Logger loggerPostpartum = LoggerFactory.getLogger("filePostpartum");
	
	@Resource
	private AppBabyBasicInfoService appBabyBasicInfoService;
	
	@Resource
	private AppMemberService appMemberService;
	
	@Resource
	private AppAffiliatedHospitalInfoService appAffiliatedHospitalInfoService;
	
	/**
	 * 验证育儿期首页信息
	 * @param mbrId
	 * @param uploadServerUrl
	 * @param advertImagesFile
	 * @return
	 */
	public Map<String,Object> validateSearchPostpartumFirstPageInfo(String mbrId,String babyInfoId,String uploadServerUrl,String advertImagesFile) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证图片地址
			if (StringUtil.isNullOrBlank(uploadServerUrl) || StringUtil.isNullOrBlank(advertImagesFile)) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_SERVER);
	    		respMap.put("message", "系统图片数据异常!");
				return respMap;
			}
			
			if (!StringUtil.isNullOrBlank(babyInfoId) && !StringUtil.isNullOrBlank(mbrId)) {
				//校验会员育儿期信息
				this.commonValidatePostpartumStatus(respMap, mbrId, babyInfoId, false);
				if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
					return respMap;
				}
				
				//获取关联医院信息ID
				this.commonValidateHospital(respMap, StringUtil.valueOf(respMap.get("mbrId")));
				
				//验证当前阶段与会员表阶段状态是否一致
				AppMemberPO mbrInfo = (AppMemberPO) respMap.get("mbrInfo");
				if (null != mbrInfo) {
					if (!StringUtil.isNullOrBlank(mbrInfo.getCurrentStage())) {
						if (mbrInfo.getCurrentStage().equals(StageStatus.育儿期.getValue())) {
							if (mbrInfo.getParId().equals(babyInfoId)) {
								//不作处理
								return respMap;
							}
						}
					}
					
					//修改会员表所处阶段为 -- 育儿期，并修改儿童ID
					this.appMemberService.updateCurrentStage(mbrInfo.getId(), StageStatus.育儿期.getValue(), babyInfoId);
				}
			}
		} catch (Exception e) {
			loggerPostpartum.error("查询育儿期首页信息验证异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询育儿期首页信息验证异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 验证儿童及会员信息
	 * @param respMap
	 * @param babyInfoId
	 * bn--是否校验当前儿童parid
	 * @return
	 */
	public Map<String,Object> commonValidatePostpartumStatus(Map<String,Object> respMap,String mbrId,String babyInfoId,boolean bn) {
		if (null == respMap) {
			respMap = MapUtil.getResultSuccess();
		}
		
		if (!StringUtil.isNullOrBlank(mbrId) && !StringUtil.isNullOrBlank(babyInfoId)) {
			//校验会员信息
			this.commonValidateMbrStatus(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//校验儿童信息
			AppBabyBasicInfoPO babyInfo = this.appBabyBasicInfoService.find(babyInfoId);
			if (null == babyInfo) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
	    		respMap.put("message", "不存在该儿童信息!");
				return respMap;
			}
			
			//校验育儿期状态信息
			AppMemberPO mbrInfo = (AppMemberPO) respMap.get("mbrInfo");
			if (!mbrInfo.getCurrentStage().equals(StageStatus.育儿期.getValue())) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
	    		respMap.put("message", "会员当前不处于育儿期!");
				return respMap;
			}
			
			//校验育儿期所处儿童信息
			if (bn) {
				if (StringUtil.isNullOrBlank(mbrInfo.getParId()) || !mbrInfo.getParId().equals(babyInfoId)) {
					respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
		    		respMap.put("message", "会员育儿期阶段异常!");
					return respMap;
				}
			}
			respMap.put("mbrId", babyInfo.getMbrId());
			respMap.put("babyInfo", babyInfo);
		}
		return respMap;
	}
	
	
	/**
	 * 验证会员信息
	 * @param respMap
	 * @param memberId
	 * @return
	 */
	public Map<String,Object> commonValidateMbrStatus(Map<String,Object> respMap,String memberId) {
		if (null == respMap) {
			respMap = MapUtil.getResultSuccess();
		}
		
		//校验会员信息
		AppMemberPO mbrInfo = appMemberService.find(memberId);
		if (null == mbrInfo) {
			respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
    		respMap.put("message", "会员登录异常!");
			return respMap;
		}
		
		//校验会员是否停用
		if (mbrInfo.getStatus().equals(EffectStatus.无效.getValue())) {
			respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
			respMap.put("message", "该用户已被停用!");
			return respMap;
		}
		
		respMap.put("mbrInfo", mbrInfo);
		return respMap;
	}
	
	/**
	 * 通过mbrId查询关联的医院ID
	 * @param respMap
	 * @param memberId
	 * @return
	 */
	public Map<String,Object> commonValidateHospital(Map<String,Object> respMap,String memberId) {
		if (null == respMap) {
			respMap = MapUtil.getResultSuccess();
		}
		
		//验证会员医院关联信息
		AppAffiliatedHospitalInfoPO affiliatedInfo = this.appAffiliatedHospitalInfoService.findAppAffiliatedHospitalInfoByMbrId(memberId);
//		if (null == affiliatedInfo || StringUtil.isNullOrBlank(affiliatedInfo.getHospitalId())) {
//			respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
//			respMap.put("message", "不存在与该会员关联的医院信息!");
//			return respMap;
//		}
		
		if (null != affiliatedInfo) {
			respMap.put("hospitalId", affiliatedInfo.getId());
		}
		return respMap;
	}
}
