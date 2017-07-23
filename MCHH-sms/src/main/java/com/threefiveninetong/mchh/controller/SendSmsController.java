package com.threefiveninetong.mchh.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threefiveninetong.mchh.controller.support.SendSmsControllerSupport;
import com.threefiveninetong.mchh.send.vo.base.BaseVoExp;
import com.threefiveninetong.mchh.service.SmsSendingService;
import com.threefiveninetong.mchh.task.support.InitSmsTaskSupprot;
import com.threefiveninetong.mchh.task.support.SendSmsTaskSupprot;


@Controller
@RequestMapping("/sms")
public class SendSmsController {
	
	@Resource
	private SmsSendingService smsSendingService;
	
	@Resource
	private SendSmsTaskSupprot sendSmsTaskSupprot;
	@Resource
	private InitSmsTaskSupprot initSmsTaskSupprot;

	@Resource
	private SendSmsControllerSupport sendSmsControllerSupport;
	
	@ResponseBody
	@RequestMapping(value = "sendSms", method = RequestMethod.POST)
	public  BaseVoExp sendSms(String terminalNo,String telephoneList,String content,String smsType,String sign) {
		
		return sendSmsControllerSupport.sendSms(telephoneList, content,smsType);
	}
	
}
