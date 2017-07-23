package com.threefiveninetong.mchh.task.support;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.service.SmsSendingService;



@Service("receiveTask")
public class ReceiveSmsTaskSupprot {

	Logger smslong= LoggerFactory.getLogger(ReceiveSmsTaskSupprot.class);
	@Resource
	private SmsSendingService smsSendingServiceImpl;

	

}
