package com.threefiveninetong.mchh.send.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.send.vo.base.FailReSendService;
import com.threefiveninetong.mchh.po.SmsDownstatePO;


@Service("manDaoSecondReportService")
public class ManDaoSecondReportService extends FailReSendService{
	Logger log = LoggerFactory.getLogger(ManDaoSecondReportService.class);
	public void updateSmsTypeAndSendSecond(SmsDownstatePO masDeliver) {
		operateMas(masDeliver);
		smsDownstateServiceImpl.create(masDeliver);
	}
	   
	   
}
