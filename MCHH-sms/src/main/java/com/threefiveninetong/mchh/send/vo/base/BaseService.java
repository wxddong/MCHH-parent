package com.threefiveninetong.mchh.send.vo.base;

import java.util.List;

import com.threefiveninetong.mchh.po.SmsDownstatePO;
import com.threefiveninetong.mchh.po.SmsSendingPO;

public interface BaseService {

	/**
	 * 发送短信方法
	 * @param mobilePhone 手机号
	 * @param content  短信内容
	 */
	BaseVoExp SendSms(BaseVoExp basevo);

	/**
	 * 查询余额
	 * @return
	 */
	double getBalance();

	/**
	 * 查询下行短信状态，处理失败的短信
	 */
	List<SmsDownstatePO> controlReport(Object obj);

	/**
	 * 当短信余额不足时，发送短信提醒
	 */
	void warnSms();

	/**
	 * 操作接收到的短信
	 */
	void controlReceive(Object obj);

	
}
