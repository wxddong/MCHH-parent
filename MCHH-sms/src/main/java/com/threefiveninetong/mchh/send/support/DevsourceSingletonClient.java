package com.threefiveninetong.mchh.send.support;

import com.threefiveninetong.mchh.core.util.PropertyUtil;
import com.threefiveninetong.mchh.send.util.InitDictionary;

public class DevsourceSingletonClient {
	private static DevsourceClient client=null;
	
	private DevsourceSingletonClient(){
	}

	public synchronized static DevsourceClient getClient(){
		if(client==null){
			for (int i = 0; i <20; i++) {
				try {
					client=new DevsourceClient(
							PropertyUtil.getProperty().getString("DEVSOURCE_URL"),PropertyUtil.getProperty().getString("DEVSOURCE_USERID"),InitDictionary.getSmsPlateMap().get(PropertyUtil.getProperty().getString("DEVSOURCE_PLATFORN_CODE")).getPlateId(),InitDictionary.getSmsPlateMap().get(PropertyUtil.getProperty().getString("DEVSOURCE_PLATFORN_CODE")).getPlatePwd());
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
