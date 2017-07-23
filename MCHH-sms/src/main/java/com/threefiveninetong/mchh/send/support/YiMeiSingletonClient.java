package com.threefiveninetong.mchh.send.support;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import com.threefiveninetong.mchh.send.util.InitDictionary;


public class YiMeiSingletonClient {
	private static YiMeiClient client=null;
	
	private YiMeiSingletonClient(){
	}
	public synchronized static YiMeiClient getClient(String softwareSerialNo,String key){
		if(client==null){
			try {
				client=new YiMeiClient(softwareSerialNo,key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return client;
	}
	public synchronized static YiMeiClient getClient(){
		ResourceBundle bundle=PropertyResourceBundle.getBundle("config");
		if(client==null){
			for (int i = 0; i <20; i++) {
				try {
					client=new YiMeiClient(InitDictionary.getSmsPlateMap().get(bundle.getString("YIMEIMARK")).getPlateId(),InitDictionary.getSmsPlateMap().get(bundle.getString("YIMEIMARK")).getPlatePwd());
					/*if(client!=null){
					client.registEx(InitDictionary.SERIALPASS);
					}*/
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(client!=null){
	                break;				
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}
		return client;
	}
	
	
	
}
