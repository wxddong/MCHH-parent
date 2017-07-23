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
import com.threefiveninetong.mchh.util.CryptUtil;
import com.threefiveninetong.mchh.util.DictionaryForApi;
import com.threefiveninetong.mchh.util.DictionaryForApi.EffectStatus;
import com.threefiveninetong.mchh.util.Encoding;
import com.threefiveninetong.mchh.util.MapUtil;
import com.threefiveninetong.mchh.util.StringUtil;
import com.threefiveninetong.mchh.util.SystemException;

@Service
public class AppMemberValidateService {
	
	//会员逻辑处理日志
	public static Logger loggerMbr = LoggerFactory.getLogger("fileMember");
	
	@Resource
	private AppMemberService appMemberService;
	
	@Resource
	private AppAffiliatedHospitalInfoService appAffiliatedHospitalInfoService;
	
	/**
	 * 注册校验
	 * @param userName
	 * @return
	 */
	public Map<String,Object> validateMemberRegister(String userName) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//用户名是否已被注册
			AppMemberPO mbrInfo = this.appMemberService.findMbrInfoByUserName(userName);
			if (mbrInfo != null) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
				respMap.put("message", "该用户名已存在!");
				return respMap;
			}
			
			//验证码校验--目前不做
		} catch (Exception e) {
			loggerMbr.error("注册校验异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"注册校验异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 登录验证
	 * @param userName
	 * @param password
	 * @return
	 */
	public Map<String,Object> validateMemberLogin(String userName,String password,String uploadServerUrl,String mbrImagesFile) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证常量
			if (StringUtil.isNullOrBlank(uploadServerUrl) || StringUtil.isNullOrBlank(mbrImagesFile)) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_SERVER);
				respMap.put("message", "系统图片地址数据异常!");
				return respMap;
			}
			
			//通过用户名查询会员信息
			AppMemberPO mbrInfo = this.appMemberService.findMbrInfoByUserName(userName);
			if (null == mbrInfo) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
				respMap.put("message", "该用户不存在!");
				return respMap;
			}
			
			//校验会员是否停用
			if (mbrInfo.getStatus().equals(EffectStatus.无效.getValue())) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
				respMap.put("message", "该用户已被停用!");
				return respMap;
			}
			
			//校验密码
	        boolean pwdEqu = false;
	        try {
	            pwdEqu = mbrInfo.getPwd().equals(CryptUtil.MD5.encrypt(password, Encoding.UTF_8));
	        } catch (Exception e) {
	        	loggerMbr.error("会员登录校验密码时抛异常", e);
	        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"会员登录校验密码时抛异常!",e);
	        }
	        if (!pwdEqu) {
	        	respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
	        	respMap.put("message", "密码错误!");
	            return respMap;
	        }
	        
	        //登录成功封装用户信息
	        respMap.put("mbrInfo", mbrInfo);
		} catch (Exception e) {
			loggerMbr.error("登录验证异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"登录验证异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 修改密码校验
	 * @param mbrId
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	public Map<String,Object> validateMemberResetPassword(String mbrId, String oldPwd, String newPwd){
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//通过用户名查询会员信息
			AppMemberPO mbrInfo = this.appMemberService.find(mbrId);
			if (null == mbrInfo) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
				respMap.put("message", "该用户不存在!");
				return respMap;
			}
			
			//校验会员是否停用
			if (mbrInfo.getStatus().equals(EffectStatus.无效.getValue())) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
				respMap.put("message", "该用户已被停用!");
				return respMap;
			}
			
			//校验密码
	        boolean pwdEqu = false;
	        try {
	            pwdEqu = mbrInfo.getPwd().equals(CryptUtil.MD5.encrypt(oldPwd, Encoding.UTF_8));
	        } catch (Exception e) {
	        	loggerMbr.error("会员修改密码校验密码时抛异常", e);
	        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"会员登录校验密码时抛异常!",e);
	        }
	        if (!pwdEqu) {
	        	respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
	        	respMap.put("message", "密码错误!");
	            return respMap;
	        }
	        
	        //登录成功封装用户信息
	        respMap.put("mbrInfo", mbrInfo);
		} catch (Exception e) {
			loggerMbr.error("修改密码验证异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"修改密码验证异常!",e);
		}
		return respMap;
	}

	/**
	 * 修改会员基本信息
	 * @param memberId
	 * @param nickName
	 * @param sex
	 * @param bloodType
	 * @param birthday
	 * @param signature
	 * @param image
	 * @param type
	 * @return
	 */
	public Map<String, Object> validateMemberUpdate(String memberId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//通过用户名查询会员信息
			AppMemberPO mbrInfo = this.appMemberService.find(memberId);
			if (null == mbrInfo) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
				respMap.put("message", "该用户不存在!");
				return respMap;
			}
			
			//校验会员是否停用
			if (mbrInfo.getStatus().equals(EffectStatus.无效.getValue())) {
				respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
				respMap.put("message", "该用户已被停用!");
				return respMap;
			}
			
	        //登录成功封装用户信息
	        respMap.put("mbrInfo", mbrInfo);
		} catch (Exception e) {
			loggerMbr.error("修改会员基本信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"修改会员基本信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 心情语录校验
	 * @param mbrId
	 * @param type
	 * @return
	 */
	public Map<String,Object> validateMoodRecord(String mbrId,String type) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//校验会员状态
			respMap = commonValidateMbrStatus(respMap, mbrId);
        	if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
        	
        	//校验用户所处阶段
        	AppMemberPO mbrInfo = (AppMemberPO) respMap.get("mbrInfo");
        	if (StringUtil.isNullOrBlank(mbrInfo.getCurrentStage()) || !type.equals(mbrInfo.getCurrentStage())) {
        		respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
				respMap.put("message", "用户所处阶段异常!");
				return respMap;
        	}
		} catch (Exception e) {
			loggerMbr.error("修改会员基本信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"修改会员基本信息异常!",e);
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
		if (null == affiliatedInfo || StringUtil.isNullOrBlank(affiliatedInfo.getHospitalId())) {
			respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
			respMap.put("message", "不存在与该会员关联的医院信息!");
			return respMap;
		}
		respMap.put("hospitalId", affiliatedInfo.getId());
		return respMap;
	}
}
