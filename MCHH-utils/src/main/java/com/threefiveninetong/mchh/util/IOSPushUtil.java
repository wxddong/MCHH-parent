package com.threefiveninetong.mchh.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;

import javapns.devices.Device;
import javapns.devices.implementations.basic.BasicDevice;
import javapns.notification.AppleNotificationServerBasicImpl;
import javapns.notification.PushNotificationManager;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotification;

public class IOSPushUtil {
	private static final Logger LOG = LoggerFactory.getLogger(IOSPushUtil.class);
//	private String certPath = "/app/api/keystore/HUI_iosPush.p12";// 证书地址
	private static final String password = "1";// 证书密码
	private static  boolean devOrPro = true;// 生产还是测试（false：测试，true：生产）
//	private String channelNO = "HUI";//渠道号
//
//	public  IOSPushUtil(String channelNO){
//		this.channelNO=channelNO;
//		initCert();
//	}
//	
//	private void initCert()
//	{
//		String systemType = System.getProperty("os.name").toLowerCase();//获取系统名称
//		if (systemType.indexOf("linux") != -1){//生产环境(linux系统)
//			certPath = "/app/api/keystore/"+channelNO+"_iosPush.p12";// 证书地址
//			devOrPro = true;// 生产还是测试（false：测试，true：生产）
//		}else{//测试环境
//			certPath = "E:/keystore/"+channelNO+"_iosPush.p12";// 证书地址
//			devOrPro = false;// 生产还是测试（false：测试，true：生产）
//		}
//	}

	/**
	 * String
	 * @param message 推送消息，手机端展示
	 * @param extras  推送参数数据，瘾式，开发者使用
	 * @param token   推送的token
	 */
	public static void pushMsg(String channelNO,String message, Map<String, String> extras, String... token) {
        sendpush(Arrays.asList(token), message, extras, true,channelNO);
	}

	/**
	 * pushMsg
	 * @param message 推送消息，手机端展示
	 * @param extras 推送参数数据，瘾式，开发者使用
	 * @param tokens 推送的token
	 */
	public static void pushMsg(String channelNO,String message, Map<String, String> extras, Collection<String> tokens) {
		sendpush((List<String>) tokens, message, extras, true,channelNO);
	}

	/**
	 * apple的推送方法
	 * 
	 * @param tokens，iphone手机获取的token
	 * @param message
	 *            推送消息的内容
	 * @param sendCount
	 *            单发还是群发（false：单发，true：群发）
	 */
	private static List<PushedNotification> sendpush(List<String> tokens, String message, Map<String, String> extras,
			boolean sendCount,String channelNO) {

		try {
			String certPath = "/app/api/keystore/HUI_iosPush.p12";// 证书地址
			
			String systemType = System.getProperty("os.name").toLowerCase();//获取系统名称
			if (systemType.indexOf("linux") != -1){//生产环境(linux系统)
				certPath = "/app/api/keystore/"+channelNO+"_iosPush.p12";// 证书地址
				devOrPro = true;// 生产还是测试（false：测试，true：生产）
			}else{//测试环境
				certPath = "E:/keystore/"+channelNO+"_iosPush.p12";// 证书地址
				devOrPro = false;// 生产还是测试（false：测试，true：生产）
			}
			
			PushNotificationPayload payLoad = new PushNotificationPayload();
			// payLoad.addAlert(message); // 消息内容
			payLoad.addCustomAlertLocKey(message); // 用于显示的
			payLoad.addCustomAlertBody(JSON.toJSONString(extras));// 用于手机端处理的，瘾式的
			// payLoad.addCustomAlertActionLocKey("这里是lockey");
			payLoad.addBadge(0); // iphone应用图标上小红圈上的数值
			payLoad.addSound("default"); // 铃音 默认
			PushNotificationManager pushManager = new PushNotificationManager();
			pushManager.initializeConnection(new AppleNotificationServerBasicImpl(certPath, password, devOrPro));
			List<PushedNotification> notifications = new ArrayList<PushedNotification>();
			
			// 发送push消息
			if (!sendCount) {// 单发
				Device device = new BasicDevice();
				//设备id格式化
				if(!StringUtil.isNull(tokens.get(0)))
					tokens.set(0,tokens.get(0).replaceAll(" ",""));
				
				device.setToken(tokens.get(0));
				PushedNotification notification = pushManager.sendNotification(device, payLoad, true);
				notifications.add(notification);
			} else {
				List<Device> device = new ArrayList<Device>();
				for (String token : tokens) {
					//设备id格式化
					if(!StringUtil.isNull(token))
						token = token.replaceAll(" ","");
					
					device.add(new BasicDevice(token));
				}
				notifications = pushManager.sendNotifications(payLoad, device);
			}

			List<PushedNotification> failedNotifications = PushedNotification.findFailedNotifications(notifications); // 推送失败的集合
			List<PushedNotification> successfulNotifications = PushedNotification.findSuccessfulNotifications(notifications); // 推送成功的集合
			int failedNum = failedNotifications.size();// 失败数量
			int successfulNum = successfulNotifications.size(); // 成功数量

			LOG.info("推送的令牌列表："+JSON.toJSONString(tokens)+"，成功数量：" + successfulNum + "，失败数量：" + failedNum);

			if (failedNum > 0) {
				String failTokens = "";
				for (PushedNotification fail : failedNotifications) {
					failTokens += fail.getDevice().getToken() + "/";
				}
				LOG.info("失败的token：" + failTokens + "，失败原因：" + failedNotifications.get(0).getException());
			}
			return failedNotifications;
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("推送发生异常",e);
		}
		return null;
	}
}
