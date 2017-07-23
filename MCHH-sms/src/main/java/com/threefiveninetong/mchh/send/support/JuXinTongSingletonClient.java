package com.threefiveninetong.mchh.send.support;


import com.threefiveninetong.mchh.core.util.PropertyUtil;
import com.threefiveninetong.mchh.send.util.InitDictionary;

public class JuXinTongSingletonClient {
	private static JuXinTongClient client=null;
	
	private JuXinTongSingletonClient(){
	}
	public synchronized static JuXinTongClient getClient(String userName,String userPwd){
		if(client==null){
			try {
				client=new JuXinTongClient(userName,userPwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return client;
	}
	public synchronized static JuXinTongClient getClient(){
		if(client==null){
			for (int i = 0; i <20; i++) {
				try {
					client=new JuXinTongClient(InitDictionary.getSmsPlateMap().get(PropertyUtil.getProperty().getString("JUXINMARK")).getPlateId(),InitDictionary.getSmsPlateMap().get(PropertyUtil.getProperty().getString("JUXINMARK")).getPlatePwd());
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
