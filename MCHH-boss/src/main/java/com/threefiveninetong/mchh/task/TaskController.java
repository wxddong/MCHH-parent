package com.threefiveninetong.mchh.task;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.threefiveninetong.mchh.task.service.TaskService;

@Component
public class TaskController {
	Logger log= LoggerFactory.getLogger(TaskController.class);
	
	@Resource
    private TaskService taskService;

	/**
	 * 自动结案
	 */
	@Scheduled(cron = "0 0 8 * * ?")
    public void autoCloseCase(){
    	log.info("自动结案开始");
    	taskService.autoCloseCase();
    	log.info("自动结案结束");
    }
	
//	@Scheduled(cron = "0 53 11 * * ?")
    public void messageRemind(){
    	log.info("短信提醒开始");
    	System.out.println("短信提醒开始");
    	taskService.messageRemind();
    	log.info("短信提醒结束");
    	System.out.println("短信提醒结束");
    }
	
}
