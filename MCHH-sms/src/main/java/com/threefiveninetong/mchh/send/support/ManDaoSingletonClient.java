package com.threefiveninetong.mchh.send.support;


import com.threefiveninetong.mchh.core.util.PropertyUtil;
import com.threefiveninetong.mchh.send.util.InitDictionary;

public class ManDaoSingletonClient {
	private static ManDaoClient client=null;
	
	private ManDaoSingletonClient(){
	}
	public synchronized static ManDaoClient getClient(String userName,String userPwd){
		if(client==null){
			try {
				client=new ManDaoClient(userName,userPwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return client;
	}
	public synchronized static ManDaoClient getClient(){
		if(client==null){
			for (int i = 0; i <20; i++) {
				try {
					client=new ManDaoClient(InitDictionary.getSmsPlateMap().get(PropertyUtil.getProperty().getString("MAODAOMARK")).getPlateId(),InitDictionary.getSmsPlateMap().get(PropertyUtil.getProperty().getString("MAODAOMARK")).getPlatePwd());
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
