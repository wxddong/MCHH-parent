package com.threefiveninetong.mchh.app.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threefiveninetong.mchh.app.validate.AppHospitalValidateService;
import com.threefiveninetong.mchh.appConfig.service.AppBannerInfoService;
import com.threefiveninetong.mchh.appHospital.po.AppAffiliatedHospitalInfoPO;
import com.threefiveninetong.mchh.appHospital.po.AppHospitalInfoPO;
import com.threefiveninetong.mchh.appHospital.service.AppAffiliatedHospitalInfoService;
import com.threefiveninetong.mchh.appHospital.service.AppCharacteristicServiceInfoService;
import com.threefiveninetong.mchh.appHospital.service.AppHospitalInfoService;
import com.threefiveninetong.mchh.appHospital.service.AppSchoolCurriculumInfoService;
import com.threefiveninetong.mchh.appMember.po.AppMbrMessageInfoPO;
import com.threefiveninetong.mchh.appMember.service.AppMbrMessageInfoService;
import com.threefiveninetong.mchh.util.DictionaryForApi;
import com.threefiveninetong.mchh.util.DictionaryForApi.MsgSource;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.MapUtil;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.util.StringUtil;
import com.threefiveninetong.mchh.util.SystemException;

@PropertySources({@PropertySource("classpath:/system.properties"),@PropertySource("classpath:/validation_zh.properties")})
@Service
public class AppHospitalHandleService {
	
	//医院逻辑处理日志
	public static Logger loggerHospital = LoggerFactory.getLogger("fileHospital");
	
	@Value("${sys.uploadServer.url}")
    private String uploadServerUrl;//图片服务器
	
	@Value("${sys.upload.path.advertImages.file}")
    private String advertImagesFile;//广告图片
	
	@Resource
	private AppHospitalValidateService appHospitalValidateService;
	
	@Resource
	private AppBannerInfoService appBannerInfoService;
	
	@Resource
	private AppCharacteristicServiceInfoService appCharacteristicServiceInfoService;
	
	@Resource
	private AppAffiliatedHospitalInfoService appAffiliatedHospitalInfoService;
	
	@Resource
	private AppHospitalInfoService appHospitalInfoService;
	
	@Resource
	private AppMbrMessageInfoService appMbrMessageInfoService;
	
	@Resource
	private AppSchoolCurriculumInfoService appSchoolCurriculumInfoService;
	
	/**
	 * 查询医院首页展示信息
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchHospitalFirstPageInfo(String mbrId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap =  this.appHospitalValidateService.validateSearchHospitalFirstPageInfo(mbrId, uploadServerUrl, advertImagesFile);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//图片地址
			respMap.put("serverUrl", uploadServerUrl + "/" + advertImagesFile + "/");
			
			//查询医院信息表
			respMap.put("hospitalInfo", (AppHospitalInfoPO)respMap.get("hospitalInfo"));
			
			//查询一条通知信息
			respMap.put("msgInfo", this.appMbrMessageInfoService.findAppMbrMessageListByCondition(StringUtil.valueOf(respMap.get("hospitalId")),mbrId, null, null));
			
			//查询一条检查信息
			
		} catch (Exception e) {
			loggerHospital.error("查询医院首页展示信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询医院首页展示信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询医院特色服务信息
	 * @param requestx
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchCharacteristicServiceInfo(String hospitalId,String mbrId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap =  this.appHospitalValidateService.validateSearchCharacteristicServiceInfo(hospitalId, mbrId,uploadServerUrl,advertImagesFile);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//图片地址
			respMap.put("serverUrl", uploadServerUrl + "/" + advertImagesFile + "/");
			
			//查询医院特色服务信息
			respMap.put("characteristicServiceList", this.appCharacteristicServiceInfoService.findAppCharacteristicServiceListByHospitalId(hospitalId));
		} catch (Exception e) {
			loggerHospital.error("查询医院特色服务信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询医院特色服务信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 会员关联医院
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> affiliatedHospital(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			String hospitalId = StringUtil.valueOf(reqMap.get("hospitalId"));
			String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
			respMap =  this.appHospitalValidateService.validateAffiliatedHospital(hospitalId, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//会员关联医院
			AppAffiliatedHospitalInfoPO affiliatedInfo = new AppAffiliatedHospitalInfoPO();
			affiliatedInfo.setId(IdUtil.uuid());
			affiliatedInfo.setMbrId(mbrId);
			affiliatedInfo.setHospitalId(hospitalId);
			affiliatedInfo.setCreateTime(new Date());
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("treatmentNo")))) 
				affiliatedInfo.setTreatmentNo(StringUtil.valueOf(reqMap.get("treatmentNo")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("archivesCode"))))
				affiliatedInfo.setArchivesCode(StringUtil.valueOf(reqMap.get("archivesCode")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("idNo"))))
				affiliatedInfo.setIdNo(StringUtil.valueOf(reqMap.get("idNo")));
			if (!StringUtil.isNullOrBlank(StringUtil.valueOf(reqMap.get("hospitalName"))))
				affiliatedInfo.setHospitalName(StringUtil.valueOf(reqMap.get("hospitalName")));
			this.appAffiliatedHospitalInfoService.create(affiliatedInfo);
		} catch (Exception e) {
			loggerHospital.error("会员关联医院异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"会员关联医院异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询医院孕妇学校课程时间
	 * @param hospitalId
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchHospitalSchoolCurriculumInfo(String hospitalId,String mbrId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap =  this.appHospitalValidateService.commonValidateHospitalStatus(respMap,hospitalId, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询医院孕妇学校课程信息
			respMap.put("curriculumList", this.appSchoolCurriculumInfoService.findMonthMillisecondList(hospitalId));
		} catch (Exception e) {
			loggerHospital.error("查询医院孕妇学校课程时间异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询医院孕妇学校课程时间异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询医院孕妇学校课程信息
	 * @param hospitalId
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchHospitalSchoolCurriculumInfo2(String hospitalId,String mbrId,String monthTime) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap =  this.appHospitalValidateService.commonValidateHospitalStatus(respMap,hospitalId, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//查询医院孕妇学校课程信息
			respMap.put("curriculumList", this.appSchoolCurriculumInfoService.findAppSchoolCurriculumListByHospitalIdAndMonth(hospitalId,monthTime));
		} catch (Exception e) {
			loggerHospital.error("查询医院孕妇学校课程信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询医院孕妇学校课程信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询医院详情信息
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> searchHospitalInfo(String hospitalId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap =  this.appHospitalValidateService.validateSearchHospitalInfo(hospitalId,uploadServerUrl,advertImagesFile);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//图片地址
			respMap.put("serverUrl", uploadServerUrl + "/" + advertImagesFile + "/");
			
			//查询医院详情信息
			respMap.put("hospitalInfo", this.appHospitalInfoService.find(hospitalId));
		} catch (Exception e) {
			loggerHospital.error("查询医院详情信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询医院详情信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 查询会员的医院通知
	 * @param request
	 * @return
	 */
	public Map<String,Object> searchHospitalMessage(String hospitalId,String mbrId,int rows,int pageIndex) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap =  this.appHospitalValidateService.commonValidateHospitalStatus(respMap, hospitalId, mbrId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//分页
			Page<AppMbrMessageInfoPO> page = new Page<AppMbrMessageInfoPO>();
			page.setRows(rows);
			page.setPage(pageIndex);
			page.setEntityOrField(true);
			
			//查询会员的医院通知
			Map<String,Object> conds = new HashMap<String,Object>();
			conds.put("hospitalId", hospitalId);
			conds.put("mbrId", mbrId);
			conds.put("type", MsgSource.医院通知.getValue());
			this.appMbrMessageInfoService.listForPage(conds, page);
			respMap.put("page", page);
		} catch (Exception e) {
			loggerHospital.error("查询会员的医院通知异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询会员的医院通知异常!",e);
		}
		return respMap;
	}
}
