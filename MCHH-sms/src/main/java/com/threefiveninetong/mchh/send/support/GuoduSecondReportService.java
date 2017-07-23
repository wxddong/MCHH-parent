//package com.threefiveninetong.mchh.send.support;
//
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Service;
//
//import com.threefiveninetong.mchh.send.vo.base.BaseService;
//import com.threefiveninetong.mchh.send.vo.base.BaseVo;
//import com.threefiveninetong.mchh.send.vo.base.InitDictionary;
//import com.threefiveninetong.mchh.po.SmsConfigPO;
//import com.threefiveninetong.mchh.po.SmsSendedPO;
//import com.threefiveninetong.mchh.po.SmsSendedfailPO;
//import com.threefiveninetong.mchh.po.SmsSendingPO;
//import com.threefiveninetong.mchh.service.SmsSendedService;
//import com.threefiveninetong.mchh.service.SmsSendedfailService;
//import com.threefiveninetong.mchh.core.util.ApplicationContextUtil;
//import com.threefiveninetong.mchh.core.util.PropertyUtil;
//
//@Service("guoduSecondReportService")
//public class GuoduSecondReportService {
//
//	@Resource
//	private SmsSendedService smsSendedServiceImpl;//mas=ApplicationContextUtil.getBean("smsSendedServiceImpl");
//	
//	@Resource
//	private SmsSendedfailService SmsSendedfailServiceImpl;
//	
//	
//	public void updateSmsTypeAndSendSecond(String status, String content) {
//		Map<String,Object> map=new HashMap<String,Object>(); 
//		map.put("sender",PropertyUtil.getProperty().getString("GUODUMARK"));
//		map.put("masdownmsgid",content);
//	   if(status!=null&&!"0".equals(status)){
//			try {
//				if("-1".equals(status)){
//				    return ;	
//				}
//				List<SmsSendedPO> sendedlist = smsSendedServiceImpl.findByContidions(map);//(properties,values);
//				if("1".equals(status)||"99940".equals(status)||"5".equals(status)
//						||"24".equals(status)){
//					for (int i = 0; i < sendedlist.size(); i++) {
//						SmsSendedPO btsfSend=sendedlist.get(i);
//				    		if(btsfSend!=null){
//				    		System.out.println("进入国都发送失败补发信息：补发平台失败"+"：手机号"+btsfSend.getReceiver()+",内容："+btsfSend.getContent()+"；状态："+status+";空号或者停止服务发送失败");
//							SmsSendedfailPO po=new SmsSendedfailPO();
//							po.setCommport(btsfSend.getCommport());
//							po.setContent(btsfSend.getContent());
//							po.setSender(btsfSend.getSender());
//							po.setReceiver(btsfSend.getReceiver());
//							po.setSmstype(btsfSend.getSmstype());
//							po.setInserttime(btsfSend.getInserttime());
//							po.setCreatetime(new Date());
//							po.setDescription("状态："+status+";空号或者停止服务发送失败");
//							po.setSmstype(btsfSend.getSmstype());
//							po.setSendlevel(btsfSend.getSendlevel());
//							smsSendedServiceImpl.delete(btsfSend.getId());
//							SmsSendedfailServiceImpl.create(po);
//					}
//				    
//				}
//					return ;	
//				}
//				SmsConfigPO plate=InitDictionary.getSmsPlateMap().get(PropertyUtil.getProperty().getString("GUODUMARK"));
//				long failNum=plate.getFailnum();
//				String reCode=plate.getFailCode().trim();
//				for (int i = 0; i < sendedlist.size(); i++) {
//					SmsSendedPO btsfSend=sendedlist.get(i);
//			        if(!InitDictionary.NOT_ALLOW_SMSTYPE.contains(btsfSend.getSmstype()+"")){
//			        	
//			         	if(btsfSend!=null&&Integer.valueOf(btsfSend.getDownstate())<failNum){
//					    	btsfSend.setDownstate((Integer.valueOf(btsfSend.getDownstate())+1)+"");
//					    	try{
//					    		BaseService baseCo=ApplicationContextUtil.getBean(reCode);
//					    		SmsSendingPO po =new SmsSendingPO();
//					    		po.setContent(btsfSend.getContent());
//					    		btsfSend.setSender(reCode);
//					    		BaseVo vo=new BaseVo();
//					    		vo.setMaxSendNum((int)plate.getMaxSendNum());//设置群发短信最大发送量
//					    		po.setReceiver(btsfSend.getReceiver());
//					    		baseCo.SendSms(po,vo);
//					    		btsfSend.setMasdownmsgid(vo.getMasDownId());
//					    		System.out.println("进入国都发送失败补发信息：补发平台名称"+reCode+";跳过数据库,返回代码为："+vo.getErrorCode()+"：手机号"+po.getReceiver()+",内容："+po.getContent()+";失败次数"+btsfSend.getDownstate());
////					    		btsfSend.setMasdownmsgid("guodo123456");
////					    		System.out.println("进入国都发送失败补发信息：补发平台名称"+InitDictionary.getSmsPlateMap().get(reCode).getName()+"：手机号"+po.getReceiver()+",内容："+po.getContent()+";失败次数"+btsfSend.getDownstate());
//							}catch(Exception e){
//								System.out.println("进入国都发送失败补发信息：补发平台名称"+reCode+";出现异常:"+e.getMessage());
//								e.printStackTrace();
//							}
//							smsSendedServiceImpl.updateList(sendedlist);
//							}else if(btsfSend!=null){
//								SmsSendedfailPO po=new SmsSendedfailPO();
//								po.setCommport(btsfSend.getCommport());
//								po.setContent(btsfSend.getContent());
//								po.setSender(btsfSend.getSender());
//								po.setReceiver(btsfSend.getReceiver());
//								po.setSmstype(btsfSend.getSmstype());
//								po.setInserttime(btsfSend.getInserttime());
//								po.setCreatetime(new Date());
//								po.setDescription(failNum+"次发送失败");
//								po.setSmstype(btsfSend.getSmstype());
//								po.setSendlevel(btsfSend.getSendlevel());
//								smsSendedServiceImpl.delete(btsfSend.getId());
//								SmsSendedfailServiceImpl.create(po);
//							}	
//			        }
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//}
//	}
//	   
//	   
//}
