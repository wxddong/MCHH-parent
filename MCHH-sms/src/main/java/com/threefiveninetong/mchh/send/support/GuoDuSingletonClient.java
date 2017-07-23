//package com.threefiveninetong.mchh.send.support;
//
//
//import com.threefiveninetong.mchh.send.vo.base.InitDictionary;
//import com.threefiveninetong.mchh.core.util.PropertyUtil;
//
//public class GuoDuSingletonClient {
//	private static GuoDuClient client=null;
//	
//	private GuoDuSingletonClient(){
//	}
//	public synchronized static GuoDuClient getClient(String softwareSerialNo,String key){
//		if(client==null){
//			try {
//				client=new GuoDuClient(softwareSerialNo,key);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return client;
//	}
//	public synchronized static GuoDuClient getClient(){
//		if(client==null){
//			for (int i = 0; i <20; i++) {
//				try {
//					client=new GuoDuClient(InitDictionary.getSmsPlateMap().get(PropertyUtil.getProperty().getString("GUODUMARK")).getPlateId(),InitDictionary.getSmsPlateMap().get(PropertyUtil.getProperty().getString("GUODUMARK")).getPlatePwd());
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				if(client!=null){
//	                break;				
//				}
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//	}
//		return client;
//	}
//	
//	
//	
//}
