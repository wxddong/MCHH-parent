package com.threefiveninetong.mchh.send.support;


import com.threefiveninetong.mchh.core.util.PropertyUtil;
import com.threefiveninetong.mchh.send.util.InitDictionary;

public class RongDaSingletonClient {
	private static RongDaClient client=null;
	
	private RongDaSingletonClient(){
	}
	public synchronized static RongDaClient getClient(String userName,String userPwd){
		if(client==null){
			try {
				client=new RongDaClient(userName,userPwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return client;
	}
	public synchronized static RongDaClient getClient(){
		if(client==null){
			for (int i = 0; i <20; i++) {
				try {
					client=new RongDaClient(InitDictionary.getSmsPlateMap().get(PropertyUtil.getProperty().getString("RONGDAMARK")).getPlateId(),InitDictionary.getSmsPlateMap().get(PropertyUtil.getProperty().getString("RONGDAMARK")).getPlatePwd());
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
