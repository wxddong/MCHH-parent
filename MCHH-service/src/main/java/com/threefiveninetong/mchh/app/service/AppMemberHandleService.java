package com.threefiveninetong.mchh.app.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.threefiveninetong.mchh.app.validate.AppMemberValidateService;
import com.threefiveninetong.mchh.appConfig.service.AppExpertGuidanceService;
import com.threefiveninetong.mchh.appMember.po.AppMbrFeedbackPO;
import com.threefiveninetong.mchh.appMember.po.AppMbrMessageInfoPO;
import com.threefiveninetong.mchh.appMember.po.AppMemberPO;
import com.threefiveninetong.mchh.appMember.po.AppMoodRecordPO;
import com.threefiveninetong.mchh.appMember.service.AppMbrFeedbackService;
import com.threefiveninetong.mchh.appMember.service.AppMbrMessageInfoService;
import com.threefiveninetong.mchh.appMember.service.AppMbrOperationRecordService;
import com.threefiveninetong.mchh.appMember.service.AppMemberService;
import com.threefiveninetong.mchh.appMember.service.AppMoodRecordService;
import com.threefiveninetong.mchh.appStatis.po.AppActivationPO;
import com.threefiveninetong.mchh.appStatis.service.AppActivationService;
import com.threefiveninetong.mchh.util.CollectionUtil;
import com.threefiveninetong.mchh.util.CryptUtil;
import com.threefiveninetong.mchh.util.DateUtil;
import com.threefiveninetong.mchh.util.DictionaryForApi;
import com.threefiveninetong.mchh.util.DictionaryForApi.EffectStatus;
import com.threefiveninetong.mchh.util.DictionaryForApi.FeedBackStatus;
import com.threefiveninetong.mchh.util.DictionaryForApi.MbrOptType;
import com.threefiveninetong.mchh.util.DictionaryForApi.MbrSexStatus;
import com.threefiveninetong.mchh.util.DictionaryForApi.MbrStarsStatus;
import com.threefiveninetong.mchh.util.DictionaryForApi.VisitCountTypeForApi;
import com.threefiveninetong.mchh.util.Encoding;
import com.threefiveninetong.mchh.util.IdUtil;
import com.threefiveninetong.mchh.util.MapUtil;
import com.threefiveninetong.mchh.util.Page;
import com.threefiveninetong.mchh.util.StringUtil;
import com.threefiveninetong.mchh.util.SystemException;

@PropertySources({@PropertySource("classpath:/system.properties"),@PropertySource("classpath:/validation_zh.properties")})
@Service
public class AppMemberHandleService {
	
	//会员逻辑处理日志
	public static Logger loggerMbr = LoggerFactory.getLogger("fileMember");
	
	//图片服务器
	@Value("${sys.uploadServer.url}")
    private String uploadServerUrl;
	
	//会员图片目录
	@Value("${sys.upload.path.mbrImages.file}")
	private String mbrImagesFile;
	
	@Resource
	private AppMemberValidateService appMemberValidateService;
	
	@Resource
	private AppMemberService appMemberService;
	
	@Resource
	private AppActivationService appActivationService;
	
	@Resource
	AppMbrFeedbackService appMbrFeedbackService;
	
	@Resource
	AppMbrMessageInfoService appMbrMessageInfoService;
	
	@Resource
	AppExpertGuidanceService appExpertGuidanceService;
	
	@Resource
	private AppMoodRecordService appMoodRecordService;
	
	@Resource
	private AppMbrOperationRecordService appMbrOperationRecordService;
	
	@Resource
	private FileService fileService;
	
	/**
	 * 会员注册
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> memberRegister(String terminalNo,String userName,String password) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		String[] terminalArr = terminalNo.split(";");
        String versionCode = terminalArr[4];// 版本号
        String channelNO = terminalArr[1];// 渠道号
        String equipmentNo = terminalArr[0];// 设备号
        String equipmentSysVersion = terminalArr[2];// 设备系统版本号
        String equipmentModel = terminalArr[3];// 设备型号
        try {
        	//验证过程
        	respMap = this.appMemberValidateService.validateMemberRegister(userName);
        	if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
        	
        	//注册会员账户
        	AppMemberPO mbrInfo = new AppMemberPO();
        	mbrInfo.setId(IdUtil.uuid());
        	mbrInfo.setUserName(userName);
        	mbrInfo.setNickName(userName);
        	mbrInfo.setStatus(EffectStatus.有效.getValue());
        	mbrInfo.setStars(MbrStarsStatus.普通.getValue());
        	mbrInfo.setSex(MbrSexStatus.男.getValue());
        	mbrInfo.setCreateTime(new Date());
        	try {
            	//会员密码
        		mbrInfo.setPwd(CryptUtil.MD5.encrypt(password, Encoding.UTF_8));
            } catch (Exception e) {
            	loggerMbr.error("会员注册密码加密时异常", e);
                throw new SystemException("-1000", null,"会员注册密码加密时抛异常!",e);
            }
        	appMemberService.create(mbrInfo);
        	
        	//添加注册量
        	AppActivationPO activationPO = new AppActivationPO();
            activationPO.setId(IdUtil.uuid());// id
            activationPO.setEquipmentNo(equipmentNo);// 设备号
            activationPO.setVisitcountType(VisitCountTypeForApi.注册.getValue());// 注册
            activationPO.setPhone(userName);// 会员账号
            activationPO.setChannelCode(channelNO);// 渠道号
            activationPO.setEquipmentModel(equipmentModel);// 设备型号
            activationPO.setEquipmentSysVersion(equipmentSysVersion);// 设备系统版本号
            activationPO.setVersion(versionCode);// 版本号
            activationPO.setCreateTime(new Date());// 创建时间
            try {
            	appActivationService.create(activationPO);
    		} catch (Exception e) {
    			loggerMbr.error("会员注册-添加注册量异常", e);
            	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"会员注册-添加注册量异常!",e);
    		}
            
            //组织响应参数
            respMap.put("memberId", mbrInfo.getId());
        } catch (Exception e) {
        	loggerMbr.error("会员注册异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"会员注册异常!",e);
        }
		return respMap;
	}
	
	/**
	 * 会员登录
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> memberLogin(String terminalNo,String userName,String password) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		String[] terminalArr = terminalNo.split(";");
        String versionCode = terminalArr[4];// 版本号
        String channelNO = terminalArr[1];// 渠道号
        String equipmentNo = terminalArr[0];// 设备号
        String equipmentSysVersion = terminalArr[2];// 设备系统版本号
        String equipmentModel = terminalArr[3];// 设备型号
		try {
			//验证过程
			respMap = appMemberValidateService.validateMemberLogin(userName, password,uploadServerUrl,mbrImagesFile);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//修改会员最后登录时间
			AppMemberPO mbrInfo = (AppMemberPO) respMap.get("mbrInfo");
			try {
				this.appMemberService.updateLoginTime(mbrInfo.getId());
			} catch (Exception e) {
				loggerMbr.error("修改会员最后登录时间异常", e);
	        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"修改会员最后登录时间异常!",e);
			}
			
			//添加登录量
			AppActivationPO activationPO =new AppActivationPO();
            activationPO.setId(IdUtil.uuid());// id
            activationPO.setEquipmentNo(equipmentNo);// 设备号
            activationPO.setVisitcountType(VisitCountTypeForApi.登录.getValue());// 登录
            activationPO.setCreateTime(new Date());// 创建时间
            activationPO.setPhone(userName);// 会员账号
            activationPO.setChannelCode(channelNO);// 渠道号
            activationPO.setEquipmentModel(equipmentModel);// 设备型号
            activationPO.setEquipmentSysVersion(equipmentSysVersion);// 设备系统版本号
            activationPO.setVersion(versionCode);// 版本号
            try {
            	appActivationService.create(activationPO);
    		} catch (Exception e) {
    			loggerMbr.error("会员登录-添加登录量异常", e);
            	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"会员登录-添加登录量异常!",e);
    		}
			
			//组织响应结果
            if (!StringUtil.isNullOrBlank(mbrInfo.getImageUrl())) {
            	respMap.put("imageUrl", uploadServerUrl + "/" + mbrImagesFile + "/" + mbrInfo.getImageUrl());
            }
		} catch (Exception e) {
			loggerMbr.error("会员登录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"会员登录异常!",e);
		}
		return respMap;
	}

	/**
	 * 会员修改密码
	 * @param terminalNo
	 * @param mbrId
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	@Transactional
	public Map<String, Object> memberResetPassword(String terminalNo, String mbrId, String oldPwd, String newPwd) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
        try {
			//验证过程
			respMap = appMemberValidateService.validateMemberResetPassword(mbrId, oldPwd,newPwd);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//注册会员账户
        	AppMemberPO mbrInfo = (AppMemberPO) respMap.get("mbrInfo");
        	mbrInfo.setUpdateTime(new Date());
        	try {
            	//会员密码
        		mbrInfo.setPwd(CryptUtil.MD5.encrypt(newPwd, Encoding.UTF_8));
            } catch (Exception e) {
            	loggerMbr.error("会员修改密码加密时异常", e);
                throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER, null,"会员修改密码加密时抛异常!",e);
            }
        	appMemberService.update(mbrInfo);
        	
        	appMbrOperationRecordService.createMbrOptRecByType(mbrInfo.getId(), mbrInfo.getNickName(), null, MbrOptType.修改密码);
		} catch (Exception e) {
			loggerMbr.error("会员修改密码异常", e);
			System.out.println(e.getMessage());
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"会员修改密码异常!",e);
		}
		return respMap;
	}

	/**
	 * 意见反馈
	 * @param terminalNo
	 * @param memberId
	 * @param content
	 * @return
	 */
	@Transactional
	public Map<String, Object> feedback(String terminalNo, String memberId, String content) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//校验过程
			if (!StringUtil.isNullOrBlank(memberId)) {
				respMap = appMemberValidateService.commonValidateMbrStatus(respMap, memberId);
				if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
					return respMap;
				}
			}
			
			//意见反馈
			AppMbrFeedbackPO mbrFeedback = new AppMbrFeedbackPO();
			mbrFeedback.setId(IdUtil.uuid());// id
			mbrFeedback.setMbrId(memberId);//会员ID
			mbrFeedback.setContent(content);//意见反馈内容
			mbrFeedback.setStatus(FeedBackStatus.未处理.getValue());//状态
			//创建时间
			mbrFeedback.setCreateTime(new Date());
			appMbrFeedbackService.create(mbrFeedback);
			
		} catch (Exception e) {
			loggerMbr.error("提交意见异常", e);
			System.out.println(e.getMessage());
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"提交意见异常!",e);
		}
		return respMap;
	}

	/**
	 * 查询专家指导信息
	 * @param classification
	 * @return
	 */
	@Transactional
	public Map<String, Object> findAppExpertGuidanceListByClassification(String classification) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//查询专家指导信息
			respMap.put("expertGuidanceList", this.appExpertGuidanceService.findAppExpertGuidanceListByClassification(classification));
		} catch (Exception e) {
			loggerMbr.error("查询专家指导信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询专家指导信息异常!",e);
		}
		return respMap;
	}

	/**
	 * 查询会员的详细信息
	 * @param memberId
	 * @return
	 */
	@Transactional
	public Map<String, Object> searchMemberBasicInfo(String memberId) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//校验过程
			respMap = appMemberValidateService.commonValidateMbrStatus(respMap, memberId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			//查询会员的详细信息
			AppMemberPO appMemberPO = appMemberService.find(memberId);
			respMap.put("appMemberPO", appMemberPO);
		} catch (Exception e) {
			loggerMbr.error("查询会员的详细异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询会员的详细异常!",e);
		}
		return respMap;
	}

	/**
	 * 修改会员信息
	 * @param memberId
	 * @param content
	 * @param type
	 * @return
	 */
	@Transactional
	public Map<String, Object> updatMemberBasicInfo(String memberId, String content, String type,HttpServletRequest reqImg) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
        
        try {
			//验证过程
			respMap = appMemberValidateService.validateMemberUpdate(memberId);
			if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
			//修改会员基本信息
        	AppMemberPO mbrInfo = (AppMemberPO) respMap.get("mbrInfo");
        	String remark = "";
        	switch (type) {
			case "0":
				remark = "修改昵称";
        		mbrInfo.setNickName(content);
				break;
			case "1":
				remark = "修改性别";
        		mbrInfo.setSex(content);
				break;
			case "2":
				remark = "修改血型";
        		mbrInfo.setBloodType(content);
				break;
			case "3":
				remark = "修改生日";
	        	mbrInfo.setBirthday(DateUtil.getDateByTime(content));
				break;
			case "4":
				remark = "修改个性签名";
        		mbrInfo.setSignature(content);
				break;
			case "5":
				remark = "修改头像";
				try {
					String imageUrl = "";
					if (reqImg instanceof MultipartHttpServletRequest) {
						// 接收文件
						MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) reqImg;
						List<MultipartFile> multipartFile = multipartRequest.getFiles("imageInfo");
						if (!CollectionUtil.isNullOrEmpty(multipartFile)) {
							for (int i=0;i<multipartFile.size();i++) {
								imageUrl += fileService.uploadImageUrl(multipartFile.get(i),"orderEvalueteImages");
								if (i != multipartFile.size()-1) {
									imageUrl+=",";
								}
							}
						}
					}
					mbrInfo.setImageUrl(imageUrl);
				} catch (Exception e0) {
					loggerMbr.error("修改会员基本信息--用户头像图片操作异常",e0);
					throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"修改会员基本信息--用户头像图片操作异常!",e0);
				}
				break;
			default:
				break;
			}
        	mbrInfo.setUpdateTime(new Date());
        	appMemberService.updateMember(mbrInfo);
        	
        	//记录会员操作记录
        	appMbrOperationRecordService.createMbrOptRecByType(memberId, mbrInfo.getNickName(), remark, MbrOptType.更新个人信息);
		} catch (Exception e) {
			loggerMbr.error("修改会员基本信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"修改会员基本信息异常!",e);
		}
		return respMap;
	}
	
	/**
	 * 会员添加心情语录
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> addMoodRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
        try {
        	//验证过程
        	String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
        	String type = StringUtil.valueOf(reqMap.get("type"));
        	respMap = this.appMemberValidateService.validateMoodRecord(mbrId,type);
        	if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
        	
        	//会员添加心情语录
        	AppMoodRecordPO moodInfo = new AppMoodRecordPO();
        	moodInfo.setId(IdUtil.uuid());
        	moodInfo.setMbrId(mbrId);
        	moodInfo.setType(type);
        	moodInfo.setContent(StringUtil.valueOf(reqMap.get("content")));
        	moodInfo.setCreateTime(new Date());
        	appMoodRecordService.create(moodInfo);
        	respMap.put("moodId", moodInfo.getId());
        } catch (Exception e) {
        	loggerMbr.error("会员添加心情语录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"会员添加心情语录异常!",e);
        }
		return respMap;
	}
	
	/**
	 * 会员查询心情语录信息
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> getMoodRecordList(String mbrId,String type,int rows,int pageIndex) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
        try {
        	//验证过程
        	respMap = this.appMemberValidateService.commonValidateMbrStatus(respMap, mbrId);
        	if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
        	
        	//分页
        	Page<AppMoodRecordPO> page = new Page<AppMoodRecordPO>();
			page.setRows(rows);
			page.setPage(pageIndex);
        	
        	//会员查询心情语录信息
			Map<String, Object> conds = new HashMap<String,Object>();
			conds.put("mbrId", mbrId);
			conds.put("type", type);
			this.appMoodRecordService.listForPage(conds, page);
			respMap.put("page", page);
        } catch (Exception e) {
        	loggerMbr.error("会员查询心情语录信息异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"会员查询心情语录信息异常!",e);
        }
		return respMap;
	}
	
	/**
	 * 会员修改心情语录
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> updateMoodRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
        try {
        	//验证过程
        	String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
        	respMap = this.appMemberValidateService.commonValidateMbrStatus(respMap, mbrId);
        	if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
        	
        	//会员修改心情语录
        	AppMoodRecordPO moodInfo = appMoodRecordService.find(StringUtil.valueOf(reqMap.get("moodId")));
        	if (null == moodInfo) {
        		respMap.put("statusCode", DictionaryForApi.RESP_CODE_EXP_LOGIC);
        		respMap.put("message", "该语录信息不存在异常!");
    			return respMap;
        	}
        	
        	moodInfo.setContent(StringUtil.valueOf(reqMap.get("content")));
        	moodInfo.setType(StringUtil.valueOf(reqMap.get("type")));
        	moodInfo.setUpdateTime(new Date());
        	appMoodRecordService.update(moodInfo);
        } catch (Exception e) {
        	loggerMbr.error("会员修改心情语录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"会员修改心情语录异常!",e);
        }
		return respMap;
	}
	
	/**
	 * 会员删除心情语录
	 * @param request
	 * @return
	 */
	@Transactional
	public Map<String,Object> deleteMoodRecord(Map<String,Object> reqMap) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
        try {
        	//验证过程
        	String mbrId = StringUtil.valueOf(reqMap.get("memberId"));
        	respMap = this.appMemberValidateService.commonValidateMbrStatus(respMap, mbrId);
        	if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
        	
        	//会员修改心情语录
        	String moodId = StringUtil.valueOf(reqMap.get("moodId"));
        	AppMoodRecordPO moodInfo = appMoodRecordService.find(moodId);
        	if (null == moodInfo) {
        		respMap.put("statusCode", DictionaryForApi.RESP_CODE_SUCCESS);
        		respMap.put("message", "删除成功!");
    			return respMap;
        	}
        	this.appMoodRecordService.delete(moodId);
        } catch (Exception e) {
        	loggerMbr.error("会员删除心情语录异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"会员删除心情语录异常!",e);
        }
		return respMap;
	}

	/**
	 * 查询会员接受的通知接口
	 * @param terminalNo
	 * @param memberId
	 * @param type
	 * @return
	 */
	@Transactional
	public Map<String, Object> searchMbrMessageList(String mbrId,String type, int rows,int pageIndex) {
		Map<String,Object> respMap = MapUtil.getResultSuccess();
		try {
			//验证过程
			respMap = this.appMemberValidateService.commonValidateMbrStatus(respMap, mbrId);
        	if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
        	respMap = this.appMemberValidateService.commonValidateHospital(respMap, mbrId);
        	if (!StringUtil.valueOf(respMap.get("statusCode")).equals(DictionaryForApi.RESP_CODE_SUCCESS)) {
				return respMap;
			}
			
        	//分页
        	Page<AppMbrMessageInfoPO> page = new Page<AppMbrMessageInfoPO>();
        	page.setRows(rows);
			page.setPage(pageIndex);
			page.setEntityOrField(true);
			
			Map<String,Object> conds = new HashMap<String,Object>();
			conds.put("mbrId", mbrId);
			conds.put("type", type);
			conds.put("hospitalId", StringUtil.valueOf(respMap.get("hospitalId")));
			this.appMbrMessageInfoService.listForPage(conds, page);
			respMap.put("page", page);
		} catch (Exception e) {
			loggerMbr.error("查询会员接受的通知接口异常", e);
        	throw new SystemException(DictionaryForApi.RESP_CODE_EXP_SERVER,null,"查询会员接受的通知异常!",e);
		}
		return respMap;
	}
}
