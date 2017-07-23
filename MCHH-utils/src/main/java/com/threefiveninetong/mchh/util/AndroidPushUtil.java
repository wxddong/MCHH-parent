package com.threefiveninetong.mchh.util;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

/** 
 * @ClassName: PushUtil 
 * @Description: TODO 安卓应用信息推送
 * @author: jixf 
 * @date: 2016年1月31日 下午2:12:26  
 */
public class AndroidPushUtil {
	private static final Logger LOG = LoggerFactory.getLogger(AndroidPushUtil.class);
	
	/** 
	 * @Title: pushMsgForAll 
	 * @Description: TODO 安卓推送所有人
	 * @param: @param title 消息头
	 * @param: @param msg 消息内容
	 * @param: @param extras 消息参数
	 */
	public static void pushMsgForAll(String title,String msg,Map<String, String> extras){
		JPushUtil.pushMsgForAll(title, msg, extras);
	}
	
	/** 
	 * @Title: pushMsgByTags 
	 * @Description: TODO 安卓使用tags标签特征推送
	 * @param: @param title 消息头
	 * @param: @param msg 消息内容
	 * @param: @param extras 消息参数
	 * @param: @param tags 消息特征集合
	 */
	public static void pushMsgByTags(String title,String msg,Map<String, String> extras,String... tags){
		JPushUtil.pushMsgByTags(title, msg, extras, tags);
	}
	
	/** 
	 * @Title: pushMsgByTags 
	 * @Description: TODO 安卓使用tags标签特征推送
	 * @param: @param title 消息头
	 * @param: @param msg 消息内容
	 * @param: @param extras 消息参数
	 * @param: @param tags 消息特征集合
	 */
	public static void pushMsgByTags(String title,String msg,Map<String, String> extras,Collection<String> tags){
		JPushUtil.pushMsgByTags(title, msg, extras, tags);
	}
	
	/** 
	 * @Title: pushMsgByTags 
	 * @Description: TODO 安卓使用设备别名推送
	 * @param: @param title 消息头
	 * @param: @param msg 消息内容
	 * @param: @param extras 消息参数
	 * @param: @param alias 设备别名
	 */
	public static void pushMsgByAlias(String title,String msg,Map<String, String> extras,String... alias){
		JPushUtil.pushMsgByAlias(title, msg, extras, alias);
	}
	
	/** 
	 * @Title: pushMsgByTags 
	 * @Description: TODO 安卓使用设备别名推送
	 * @param: @param title 消息头
	 * @param: @param msg 消息内容
	 * @param: @param extras 消息参数
	 * @param: @param alias 设备别名
	 */
	public static void pushMsgByAlias(String title,String msg,Map<String, String> extras,Collection<String> alias){
		JPushUtil.pushMsgByAlias(title, msg, extras, alias);
	}
	
	/** 
	 * @Title: pushMsgByTags 
	 * @Description: TODO 安卓使用设备唯一标识推送
	 * @param: @param title 消息头
	 * @param: @param msg 消息内容
	 * @param: @param extras 消息参数
	 * @param: @param registrationId 设备注册唯一id
	 */
	public static void pushMsgByRegistrationId(String title,String msg,Map<String, String> extras,String... registrationId){
		JPushUtil.pushMsgByRegistrationId(title, msg, extras, registrationId);
	}
	
	/** 
	 * @Title: pushMsgByTags 
	 * @Description: TODO 安卓使用设备唯一标识推送
	 * @param: @param title 消息头
	 * @param: @param msg 消息内容
	 * @param: @param extras 消息参数
	 * @param: @param registrationId 设备注册唯一id
	 */
	public static void pushMsgByRegistrationID(String title,String msg,Map<String, String> extras,Collection<String> registrationId){
		JPushUtil.pushMsgByRegistrationId(title, msg, extras, registrationId);
	}
	
	
	/**
	 * @ClassName: JPushConfig 
	 * @Description: TODO 极光推送配置文件
	 * @author: jixf
	 * @date: 2016年1月31日 下午2:56:00
	 */
	private static class JPushConfig{
		/**测试使用**/
		/*private static final String appKey = "eb5c1e4bbc39c6f165b71458";
		private static final String masterSecret = "db6581fbf168f750f0e5e46f";*/
		
		private static final String appKey = "8ce750ba579087b9c94ce39c";
		private static final String masterSecret = "8e2628a9d6fa7d0f6e216bde";
	}
	private static class JPushUtil{
		/** 
		 * @Title: pushMsgForAll 
		 * @Description: TODO 安卓推送所有人
		 * @param: @param title 消息头
		 * @param: @param msg 消息内容
		 * @param: @param extras 消息参数
		 */
		protected static void pushMsgForAll(String title,String msg,Map<String, String> extras){
			JPushClient jpushClient = new JPushClient(JPushConfig.masterSecret,JPushConfig.appKey);
			
			PushPayload payload = buildPushPayloadObject(Audience.all(), Notification.android(msg,title, extras));
			/** 发送消息 **/
			pushMsg(jpushClient, payload);
		}

		/** 
		 * @Title: pushMsgByTags 
		 * @Description: TODO 安卓使用tags标签特征推送
		 * @param: @param title 消息头
		 * @param: @param msg 消息内容
		 * @param: @param extras 消息参数
		 * @param: @param tags 消息特征集合
		 */
		protected static void pushMsgByTags(String title,String msg,Map<String, String> extras,String... tags){
			JPushClient jpushClient = new JPushClient(JPushConfig.masterSecret,JPushConfig.appKey);
			PushPayload payload = buildPushPayloadObject(Audience.tag(tags), Notification.android(msg,title, extras));
			/** 发送消息 **/
			pushMsg(jpushClient, payload);
		}
		
		/** 
		 * @Title: pushMsgByTags 
		 * @Description: TODO 安卓使用tags标签特征推送
		 * @param: @param title 消息头
		 * @param: @param msg 消息内容
		 * @param: @param extras 消息参数
		 * @param: @param tags 消息特征集合
		 */
		protected static void pushMsgByTags(String title,String msg,Map<String, String> extras,Collection<String> tags){
			JPushClient jpushClient = new JPushClient(JPushConfig.masterSecret,JPushConfig.appKey);
			PushPayload payload = buildPushPayloadObject(Audience.tag(tags), Notification.android(msg,title, extras));
			/** 发送消息 **/
			pushMsg(jpushClient, payload);
		}
		
		/** 
		 * @Title: pushMsgByTags 
		 * @Description: TODO 安卓使用设备别名推送
		 * @param: @param title 消息头
		 * @param: @param msg 消息内容
		 * @param: @param extras 消息参数
		 * @param: @param alias 设备别名
		 */
		protected static void pushMsgByAlias(String title,String msg,Map<String, String> extras,String... alias){
			JPushClient jpushClient = new JPushClient(JPushConfig.masterSecret,JPushConfig.appKey);
			PushPayload payload = buildPushPayloadObject(Audience.alias(alias), Notification.android(msg,title, extras));
			/** 发送消息 **/
			pushMsg(jpushClient, payload);
		}
		
		/** 
		 * @Title: pushMsgByTags 
		 * @Description: TODO 安卓使用设备别名推送
		 * @param: @param title 消息头
		 * @param: @param msg 消息内容
		 * @param: @param extras 消息参数
		 * @param: @param alias 设备别名
		 */
		protected static void pushMsgByAlias(String title,String msg,Map<String, String> extras,Collection<String> alias){
			JPushClient jpushClient = new JPushClient(JPushConfig.masterSecret,JPushConfig.appKey);
			PushPayload payload = buildPushPayloadObject(Audience.alias(alias), Notification.android(msg,title, extras));
			/** 发送消息 **/
			pushMsg(jpushClient, payload);
		}
		
		/** 
		 * @Title: pushMsgByTags 
		 * @Description: TODO 安卓使用设备唯一标识推送
		 * @param: @param title 消息头
		 * @param: @param msg 消息内容
		 * @param: @param extras 消息参数
		 * @param: @param registrationID 设备注册唯一id
		 */
		protected static void pushMsgByRegistrationId(String title,String msg,Map<String, String> extras,String... registrationId){
			JPushClient jpushClient = new JPushClient(JPushConfig.masterSecret,JPushConfig.appKey);
			PushPayload payload = buildPushPayloadObject(Audience.registrationId(registrationId), Notification.android(msg,title, extras));
			/** 发送消息 **/
			pushMsg(jpushClient, payload);
		}
		
		/** 
		 * @Title: pushMsgByTags 
		 * @Description: TODO 安卓使用设备唯一标识推送
		 * @param: @param title 消息头
		 * @param: @param msg 消息内容
		 * @param: @param extras 消息参数
		 * @param: @param registrationID 设备注册唯一id
		 */
		protected static void pushMsgByRegistrationId(String title,String msg,Map<String, String> extras,Collection<String> registrationId){
			JPushClient jpushClient = new JPushClient(JPushConfig.masterSecret,JPushConfig.appKey);
			PushPayload payload = buildPushPayloadObject(Audience.registrationId(registrationId), Notification.android(msg,title, extras));
			/** 发送消息 **/
			pushMsg(jpushClient, payload);
		}
		
		
		/** 
		 * @Title: pushMsg 
		 * @Description: TODO 发送消息，接受返回结果
		 * @param: @param jpushClient
		 * @param: @param payload
		 * @return: void
		 * @throws
		 */
		private static void pushMsg(JPushClient jpushClient, PushPayload payload) {
			try {
	            PushResult result = jpushClient.sendPush(payload);
	            LOG.info("获取结果  - " + result);
	        } catch (APIConnectionException e) {
	            // Connection error, should retry later
	            LOG.error("连接错误,请稍后再试!", e);

	        } catch (APIRequestException e) {
	            // Should review the error, and fix the request
	            LOG.error("Should review the error, and fix the request", e);
	            LOG.info("HTTP Status: " + e.getStatus());
	            LOG.info("Error Code: " + e.getErrorCode());
	            LOG.info("Error Message: " + e.getErrorMessage());
	        }
		}
		
		/** 
		 * @Title: buildPushPayloadObject 
		 * @Description: TODO 构建PushPayload对象
		 * @param: @param audience
		 * @param: @param notification
		 * @param: @return
		 * @return: PushPayload
		 */
		private static PushPayload buildPushPayloadObject(Audience audience,Notification notification){
			return PushPayload.newBuilder()
	                .setPlatform(Platform.android())//推送安卓设备
	                .setAudience(audience)
	                .setNotification(notification)
	                .build();
		}
		
		
		
	}
	
	public static void main(String[] args){
		//JPushUtil.pushMsgByTags("快乐校园", "快乐校园欢迎入学！by tags", null, "aaa","bbb");
		//JPushUtil.pushMsgByAlias("快乐校园", "快乐校园欢迎入学！by alias", null,"jixf");
		
		
		JPushClient jpushClient = new JPushClient(JPushConfig.masterSecret,JPushConfig.appKey);
		
		PushPayload payload = PushPayload.newBuilder()
		        .setPlatform(Platform.ios())
		        .setAudience(Audience.registrationId("d75c187a dcaa8f45 fc797aa1 a93fecf0 e9c6a5b8 b85273d8 8d2e7ab6 15cbad7d"))
		        .setNotification(Notification.newBuilder()
		                .addPlatformNotification(IosNotification.newBuilder()
		                        .setAlert("aas")
		                        .setBadge(5)
		                        .setSound("happy.caf")
		                        .addExtra("from", "APNs")
		                        .build())
		                .build())
		         .setMessage(Message.content("bbbbb"))
		         .setOptions(Options.newBuilder()
		                 .setApnsProduction(true)
		                 .build())
		         .build();
		/** 发送消息 **/
		JPushUtil.pushMsg(jpushClient, payload);
		
	}

}
