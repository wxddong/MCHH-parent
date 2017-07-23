package com.threefiveninetong.mchh.task.support;


import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.send.util.InitDictionary;
import com.threefiveninetong.mchh.send.vo.base.BaseService;
import com.threefiveninetong.mchh.send.vo.base.FailReSendService;
import com.threefiveninetong.mchh.po.SmsConfigPO;
import com.threefiveninetong.mchh.po.SmsDownstatePO;
import com.threefiveninetong.mchh.core.util.ApplicationContextUtil;




@Service("downSmsTaskSupprot")
public class DownSmsTaskSupprot extends FailReSendService{

	 Logger smslong= LoggerFactory.getLogger(DownSmsTaskSupprot.class);
	 /**
	  * 国都短信状态是由国都发送的，所以不需要用定时任务控制
	  * 春霖短信太垃圾，基本上不用，所以暂时放弃
	  * 下面的操作仅针对易美操作  YIMEIMARK
	  */
     public void OperateDownState(){
    	 for (int j = 0; j < InitDictionary.getSmsPlate().size(); j++) {
    	     SmsConfigPO plate=InitDictionary.getSmsPlate().get(j);
			 String code=plate.getPlatformCode().trim();
		     BaseService baseService=ApplicationContextUtil.getBean(code);
		     List<SmsDownstatePO> statusReport=null;
		     statusReport=  baseService.controlReport(null);//调用下行短信接口
		     if(statusReport!=null&&statusReport.size()>0){
    		   for (int i = 0; i <statusReport.size(); i++) {
    			   SmsDownstatePO masDeliver=statusReport.get(i);
    			   updateSmsTypeAndSendSecond(masDeliver);
    		   }
		     }
    	 }
     }
	@Override
	public void updateSmsTypeAndSendSecond(SmsDownstatePO masDeliver) {
		   operateMas(masDeliver);
		   smsDownstateServiceImpl.create(masDeliver);
	}

}
