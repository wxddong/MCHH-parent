package com.threefiveninetong.mchh.app.validate;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.appHospital.po.AppAffiliatedHospitalInfoPO;
import com.threefiveninetong.mchh.appHospital.po.AppHospitalInfoPO;
import com.threefiveninetong.mchh.appHospital.service.AppAffiliatedHospitalInfoService;
import com.threefiveninetong.mchh.appHospital.service.AppHospitalInfoService;
import com.threefiveninetong.mchh.appMember.po.AppMemberPO;
import com.threefiveninetong.mchh.appMember.service.AppMemberService;
import com.threefiveninetong.mchh.util.DictionaryForApi;
import com.threefiveninetong.mchh.util.DictionaryForApi.EffectStatus;
import com.threefiveninetong.mchh.util.MapUtil;
import com.threefiveninetong.mchh.util.StringUtil;
import com.threefiveninetong.mchh.util.SystemException;

@Service
public class AppHospitalValidateService {
	
	//医院逻辑处理日志
	public static Logger loggerHospital = LoggerFactory.getLogger("fileHospital");
	
	@Resource
	private AppMemberService appMemberService;
	
	@Resource
	private AppAffiliatedHospitalInfoService appAffiliatedHospitalInfoService;
	
	@Resource
	private AppHospitalInfoService appHospitalInfoService;
	
	/**
	 * 验证医院首页展示信息
	 * @param memberId
	 * @param uploadServerUrl
	 * @param advertImagesFile
	 * @return
	 */
	public Map<String,Object> validateSearchHospitalFirstPageInfo(String memberId,String uploadServerUrl,String advertImagesFile) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证图片地址
			if (StringUtil.isNullOrBlank(uploadServerUrl) || StringUtil.isNullOrBlank(advertImagesFile)) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_SERVER);
	    		respMap.put("message", "系统图片数据异常!");
				return respMap;
			}
			
			//验证会员信息
			respMap = this.commonValidateMbrStatus(respMap, memberId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//验证会员医院关联信息
			AppAffiliatedHospitalInfoPO affiliatedInfo = this.appAffiliatedHospitalInfoService.findAppAffiliatedHospitalInfoByMbrId(memberId);
			if (null == affiliatedInfo || StringUtil.isNullOrBlank(affiliatedInfo.getHospitalId())) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
				respMap.put("message", "不存在与该会员关联的医院信息!");
				return respMap;
			}
			
			//验证医院信息
			respMap = this.commonValidateHospital(respMap, affiliatedInfo.getHospitalId());
			respMap.put("hospitalId", affiliatedInfo.getHospitalId());
		} catch (Exception e) {
			loggerHospital.error("查询医院首页展示信息验证异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询医院首页展示信息验证异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 验证会员关联医院
	 * @param hospitalId
	 * @param memberId
	 * @return
	 */
	public Map<String,Object> validateAffiliatedHospital(String hospitalId,String memberId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证会员信息
			respMap = this.commonValidateMbrStatus(respMap, memberId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//验证医院信息
			respMap = this.commonValidateHospital(respMap, hospitalId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//验证是否已经关联过该医院
			AppAffiliatedHospitalInfoPO affiliatedInfo = this.appAffiliatedHospitalInfoService.findAppAffiliatedHospitalInfoByHIdAndMbrId(hospitalId, memberId);
			if (null != affiliatedInfo) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
				respMap.put("message", "已关联过该医院!");
				return respMap;
			}
		} catch (Exception e) {
			loggerHospital.error("会员关联医院验证异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"会员关联医院验证异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 验证查询医院特色服务信息
	 * @param hospitalId
	 * @param memberId
	 * @param uploadServerUrl
	 * @param advertImagesFile
	 * @return
	 */
	public Map<String,Object> validateSearchCharacteristicServiceInfo(String hospitalId,String memberId,String uploadServerUrl,String advertImagesFile) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证图片地址
			if (StringUtil.isNullOrBlank(uploadServerUrl) || StringUtil.isNullOrBlank(advertImagesFile)) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_SERVER);
	    		respMap.put("message", "系统图片数据异常!");
				return respMap;
			}
			
			//验证会员及医院信息
			return commonValidateHospitalStatus(respMap, hospitalId, memberId);
		} catch (Exception e) {
			loggerHospital.error("查询医院特色服务信息验证异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询医院特色服务信息验证异常!",e);
		}
	}
	
	/**
	 * 验证查询医院详情信息
	 * @param hospitalId
	 * @param uploadServerUrl
	 * @param advertImagesFile
	 * @return
	 */
	public Map<String,Object> validateSearchHospitalInfo(String hospitalId,String uploadServerUrl,String advertImagesFile) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证图片地址
			if (StringUtil.isNullOrBlank(uploadServerUrl) || StringUtil.isNullOrBlank(advertImagesFile)) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_SERVER);
	    		respMap.put("message", "系统图片数据异常!");
				return respMap;
			}
			
			return this.commonValidateHospital(respMap, hospitalId);
		} catch (Exception e) {
			loggerHospital.error("查询医院详情信息验证异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询医院详情信息验证异常!",e);
		}
	}
	
	/**
	 * 通过医院ID和会员ID验证信息
	 * @param respMap
	 * @param hospitalId
	 * @param memberId
	 * @return
	 */
	public Map<String,Object> commonValidateHospitalStatus(Map<String,Object> respMap,String hospitalId,String memberId) {
		if (null == respMap) {
			respMap = MapUtil.getResultSuccess();
		}
		
		//验证会员信息
		respMap = this.commonValidateMbrStatus(respMap, memberId);
		if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
			return respMap;
		}
		
		//验证医院信息
		respMap = this.commonValidateHospital(respMap, hospitalId);
		if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
			return respMap;
		}
		
		//验证会员医院关联信息
		AppAffiliatedHospitalInfoPO affiliatedInfo = this.appAffiliatedHospitalInfoService.findAppAffiliatedHospitalInfoByHIdAndMbrId(hospitalId, memberId);
		if (null == affiliatedInfo) {
			respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
			respMap.put("message", "不存在与该会员关联的医院信息!");
			return respMap;
		}
		respMap.put("affiliatedInfo", affiliatedInfo);
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
	 * 验证医院信息
	 * @param respMap
	 * @param hospitalId
	 * @return
	 */
	public Map<String,Object> commonValidateHospital(Map<String,Object> respMap,String hospitalId) {
		if (null == respMap) {
			respMap = MapUtil.getResultSuccess();
		}
		
		//验证医院信息
		AppHospitalInfoPO hospitalInfo = this.appHospitalInfoService.find(hospitalId);
		if (null == hospitalInfo) {
			respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
    		respMap.put("message", "医院信息异常!");
			return respMap;
		}
		
		respMap.put("hospitalInfo", hospitalInfo);
		return respMap;
	}
}
