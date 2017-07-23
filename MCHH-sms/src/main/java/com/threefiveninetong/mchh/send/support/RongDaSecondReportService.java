package com.threefiveninetong.mchh.send.support;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.threefiveninetong.mchh.po.SmsSendedPO;
import com.threefiveninetong.mchh.po.SmsSendedFailPO;
import com.threefiveninetong.mchh.service.SmsSendedService;
import com.threefiveninetong.mchh.service.SmsSendedFailService;
import com.threefiveninetong.mchh.core.exception.AppException;
import com.threefiveninetong.mchh.core.util.PropertyUtil;

@Service("rongDaSecondReportService")
public class RongDaSecondReportService {

	@Resource
	private SmsSendedService smsSendedServiceImpl;//mas=ApplicationContextUtil.getBean("smsSendedServiceImpl");
	
	@Resource
	private SmsSendedFailService SmsSendedfailServiceImpl;
	
	
	public void updateSmsTypeAndSendSecond(String status, String content) {
		Map<String,Object> map=new HashMap<String,Object>(); 
		map.put("sender",PropertyUtil.getProperty().getString("RONGDAMARK"));
		map.put("masdownmsgid",content);
		if("DELIVRD".equals(status)){
			status="0";
		}
	   if(status!=null&&!"0".equals(status)){
				try {
					List<SmsSendedPO> sendedlist = smsSendedServiceImpl.findByContidions(map);//(properties,values);
						for (int i = 0; i < sendedlist.size(); i++) {
							SmsSendedPO btsfSend=sendedlist.get(i);
					    		if(btsfSend!=null){
					    		System.out.println("进入容大发送失败补发信息：补发平台失败"+"：手机号"+btsfSend.getReceiver()+",内容："+btsfSend.getContent()+"；状态："+status+";空号或者停止服务发送失败");
					    		SmsSendedFailPO po=new SmsSendedFailPO();
								po.setPlatformCode(btsfSend.getPlatformCode());
								po.setContent(btsfSend.getContent());
								po.setSender(btsfSend.getSender());
								po.setReceiver(btsfSend.getReceiver());
								po.setSmstype(btsfSend.getSmstype());
								po.setCreatetime(btsfSend.getCreatetime());
								po.setCreatetime(new Date());
								po.setDescription("状态："+status+";容大发送失败");
								po.setSmstype(btsfSend.getSmstype());
								po.setSendlevel(btsfSend.getSendlevel());
								smsSendedServiceImpl.delete(btsfSend.getId());
								SmsSendedfailServiceImpl.create(po);
						}
					    
						}
				} catch (AppException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	   }
	}
	   
	   
}
