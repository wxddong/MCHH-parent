package com.threefiveninetong.mchh.controller.support;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.threefiveninetong.mchh.send.vo.base.BaseVoExp;
import com.threefiveninetong.mchh.po.SmsSendingPO;
import com.threefiveninetong.mchh.service.SmsSendingService;
import com.threefiveninetong.mchh.core.util.IdUtil;

/**
 * @ClassName: SendSmsControllerSupport
 * @Description: TODO 短信发送控制器support
 * @author: dingjh
 * @date: 2016年1月29日 下午3:13:09
 */
@Component
public class SendSmsControllerSupport {
	@Resource
	private SmsSendingService smsSendingService;
    
    /**
     * @Title: sendSms
     * @Description: TODO 发送短信，支持批量发送
     * @param: telephoneList  手机号，多个用“,”分隔
     *         content  短信内容
     * @return: MemberFriendDetailVo 会员详情对象
     */
    public BaseVoExp sendSms(String telephoneList,String content,String smsType) {
    	BaseVoExp baseVo=new BaseVoExp();
    	smsSendingService.createByPhoneAndContent(telephoneList,content,smsType);
        return baseVo;
    }
}
