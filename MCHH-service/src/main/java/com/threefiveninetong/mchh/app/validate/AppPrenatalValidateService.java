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
import com.threefiveninetong.mchh.appPrenatal.po.AppPrenatalBasicInfoPO;
import com.threefiveninetong.mchh.appPrenatal.service.AppPrenatalBasicInfoService;
import com.threefiveninetong.mchh.util.DictionaryForApi;
import com.threefiveninetong.mchh.util.DictionaryForApi.EffectStatus;
import com.threefiveninetong.mchh.util.DictionaryForApi.StageStatus;
import com.threefiveninetong.mchh.util.MapUtil;
import com.threefiveninetong.mchh.util.StringUtil;
import com.threefiveninetong.mchh.util.SystemException;

@Service
public class AppPrenatalValidateService {
	
	//孕产期逻辑处理日志
	public static Logger loggerPrenatal = LoggerFactory.getLogger("filePrenatal");
	
	@Resource
	private AppMemberService appMemberService;
	
	@Resource
	private AppPrenatalBasicInfoService appPrenatalBasicInfoService;
	
	@Resource
	private AppAffiliatedHospitalInfoService appAffiliatedHospitalInfoService;
	
	/**
	 * 验证孕产期首页信息
	 * @param mbrId
	 * @param uploadServerUrl
	 * @param advertImagesFile
	 * @return
	 */
	public Map<String,Object> validateSearchPrenatalFirstPageInfo(String mbrId,String uploadServerUrl,String advertImagesFile) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证图片地址
			if (StringUtil.isNullOrBlank(uploadServerUrl) || StringUtil.isNullOrBlank(advertImagesFile)) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_SERVER);
	    		respMap.put("message", "系统图片数据异常!");
				return respMap;
			}
			
			if (!StringUtil.isNullOrBlank(mbrId)) {
				//验证会员信息
				this.commonValidateMbrStatus(respMap, mbrId);
				if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
					return respMap;
				}
				//获取关联医院信息id
				this.commonValidateHospital(respMap, mbrId);
			
				//验证当前阶段与会员表阶段状态是否一致
				AppMemberPO mbrInfo = (AppMemberPO) respMap.get("mbrInfo");
				if (null != mbrInfo) {
					if (!StringUtil.isNullOrBlank(mbrInfo.getCurrentStage())) {
						if (mbrInfo.getCurrentStage().equals(StageStatus.孕产期.getValue())) {
							//不作处理
							return respMap;
						}
					}
					
					//修改会员表所处阶段为 -- 孕产期
					this.appMemberService.updateCurrentStage(mbrId, StageStatus.孕产期.getValue(), null);
				}
			}
		} catch (Exception e) {
			loggerPrenatal.error("查询孕产期首页信息验证异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询孕产期首页信息验证异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 验证修改孕产期基础信息
	 * @param mbrId
	 * @return
	 */
	public Map<String,Object> validateUpdatePrenatalBasicInfo(String mbrId,String prenatalBasicId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证会员状态
			this.commonValidateMbrStatus(respMap, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//验证是否存在孕产期数据
			AppPrenatalBasicInfoPO basicInfo =this.appPrenatalBasicInfoService.find(prenatalBasicId);
			if (null == basicInfo) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
				respMap.put("message", "孕产期基础数据异常!");
				return respMap;
			}
			respMap.put("basicInfo", basicInfo);
		} catch (Exception e) {
			loggerPrenatal.error("查询孕产期首页信息验证异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询孕产期首页信息验证异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 公用验证孕产期信息
	 * @param respMap
	 * @param memberId
	 * @return
	 */
	public Map<String,Object> commonValidatePrenatal(Map<String,Object> respMap,String memberId) {
		this.commonValidateMbrStatus(respMap, memberId);
		if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
			return respMap;
		}
		
		//校验是否处于孕产期
		AppMemberPO mbrInfo = (AppMemberPO) respMap.get("mbrInfo");
		if (!StringUtil.isNullOrBlank(mbrInfo.getCurrentStage()) && !mbrInfo.getCurrentStage().equals(StageStatus.孕产期.getValue())) {
			respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
    		respMap.put("message", "会员当前不处于孕产期!");
			return respMap;
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
		/*if (null == affiliatedInfo || StringUtil.isNullOrBlank(affiliatedInfo.getHospitalId())) {
			respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
			respMap.put("message", "不存在与该会员关联的医院信息!");
			return respMap;
		}*/
		
		if (null != affiliatedInfo) {
			respMap.put("hospitalId", affiliatedInfo.getId());
		}
		return respMap;
	}
}
