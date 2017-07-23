package com.threefiveninetong.mchh.send.support;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import com.threefiveninetong.mchh.send.util.InitDictionary;


public class ChunLinSingletonClient {
	private static ChunLinClient client=null;
	
	private ChunLinSingletonClient(){
	}
	public synchronized static ChunLinClient getClient(String softwareSerialNo){
		if(client==null){
			try {
				client=new ChunLinClient(softwareSerialNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return client;
	}
	public synchronized static ChunLinClient getClient(){
		ResourceBundle bundle=PropertyResourceBundle.getBundle("config");
		if(client==null){
			for (int i = 0; i <20; i++) {
				try {
					client=new ChunLinClient(InitDictionary.getSmsPlateMap().get(bundle.getString("CHUNLINMARK")).getPlatePwd());
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
