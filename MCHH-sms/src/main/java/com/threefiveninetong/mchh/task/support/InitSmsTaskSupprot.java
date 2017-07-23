package com.threefiveninetong.mchh.task.support;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.po.SmsConfigPO;
import com.threefiveninetong.mchh.send.util.InitDictionary;
import com.threefiveninetong.mchh.service.SmsConfigService;



@Service("initSmsTaskSupprot")
public class InitSmsTaskSupprot {

	Logger smslong= LoggerFactory.getLogger(InitSmsTaskSupprot.class);


	@Resource
	private SmsConfigService smsConfigService;

		public void InitPalte() {
			   try {
				   List<SmsConfigPO> smsConfigPOlist=  smsConfigService.findAll();//查询所有短信渠道配置
				   Collections.sort(smsConfigPOlist,new SmsConfigPO());//按发送短信的优先级别排序（1,2,3,4...不可以重复）
				   InitDictionary.InitPlateList=smsConfigPOlist;
				   
				   if(smsConfigPOlist!=null&&smsConfigPOlist.size()>0){
					   smslong.info("成功获取初始化数据");
					   InitDictionary.plateMap=   new HashMap<String, SmsConfigPO>();   
					   for (int i = 0; i <smsConfigPOlist.size(); i++) {
						   smslong.info(smsConfigPOlist.get(i)+":"+smsConfigPOlist.get(i).toString());
						   //将所有配置信息放入内存，例如：YM-亿美配置信息
						   InitDictionary.plateMap.put(smsConfigPOlist.get(i).getPlatformCode().trim(),smsConfigPOlist.get(i));
					   }
				   }else{
					   smslong.info("初始化数据失败：未启用任何发送短信渠道。");
				   }
			} catch (Exception e) {
				smslong.error("初始化平台数据异常："+e.getMessage());
				e.printStackTrace();
			}
			
		}
	
	
}
