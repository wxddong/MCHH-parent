package com.threefiveninetong.mchh.task;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.threefiveninetong.mchh.task.support.BalanceSmsTaskSupprot;
import com.threefiveninetong.mchh.task.support.DownSmsTaskSupprot;
import com.threefiveninetong.mchh.task.support.InitSmsTaskSupprot;
import com.threefiveninetong.mchh.task.support.SendSmsTaskSupprot;

@Component
public class SmsTask {

	Logger log= LoggerFactory.getLogger(SmsTask.class);
	@Resource
	private InitSmsTaskSupprot initSmsTaskSupprot;
	@Resource
	private BalanceSmsTaskSupprot balanceSms;
	@Resource
	private SendSmsTaskSupprot sendSms;	  
	@Resource
	private DownSmsTaskSupprot downSmsTaskSupprot;
	
	/**
	 * 初始化短信基础数据
	 */
	@PostConstruct
	@Scheduled(cron = "0 0/30 * * * ?")
    public void InitPalte(){
 	        log.info("初始化开始*********");
    	    initSmsTaskSupprot.InitPalte();
    	    log.info("初始化结束********");
    }
	
	/**
	 * 发送短信定
	 */
	@Scheduled(cron = "0/2 * * * * ?")
    public void SendSms(){
    	sendSms.SendSms();
	}
	
	/**
	 * 读取短信余额
	 */
	@Scheduled(cron = "0 0 8 * * ?") 
	public void getBalance(){
		   log.info("获取短信余额开始*********");
		   balanceSms.getBalance();
		   log.info("获取短信余额结束*********");
	}
	
	/**
	 * 处理下行短信的状态
	 */
//	@Scheduled(cron = "0/2 * * * * ?") 
	public void controlReport(){
		  downSmsTaskSupprot.OperateDownState();
	}

}
