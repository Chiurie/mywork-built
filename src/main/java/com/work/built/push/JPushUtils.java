package com.work.built.push;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class JPushUtils {
	
	protected static final Logger LOG = LoggerFactory.getLogger(JPushUtils.class);

	
	/**
	 * 
	  * sendToOne(推送通知给某一个特定的人)
	  *
	  * @Title: sendToOne
	  * @Description: TODO
	  * @param @param appKey 
	  * @param @param masterSecret
	  * @param @param alert  通知内容
	  * @param @param title  通知标题
	  * @param @param targetUser  目标通知对象
	  * @param @param map    额外附件标识字段
	  * @return void    返回类型
	  * @throws
	 */
	public static void sendToOne(String appKey,String masterSecret,String title,String alert,String targetUser,Map<String,String> map){
		JPushClient jpushClient = new JPushClient(masterSecret,appKey,3);
		PushPayload payload = buildPushObject_android_and_ios(targetUser, alert, title, map);
		try {
			PushResult result =  jpushClient.sendPush(payload);
			LOG.info("Got result - " + result);
			
		} catch (APIConnectionException e) {
			e.printStackTrace();
		} catch (APIRequestException e) {
			e.printStackTrace();
		}
	}
	
	
		
	/**
	 * 
	  * buildPushObject_all_alias_alert(构建推送对象：所有平台，推送目标是别名为 "alias1"，通知内容为 ALERT)
	  *
	  * @Title: buildPushObject_all_alias_alert
	  * @Description: TODO
	  * @param @param alertContent
	  * @param @return    设定文件
	  * @return PushPayload    返回类型
	  * @throws
	 */
    public static PushPayload buildPushObject_all_alias_alert(String alertContent,String alias) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.alert(alertContent))
                .build();
    }
	    
    /**
     * 
      * buildPushObject_android_tag_alertWithTitle()
      * 构建推送对象：平台是 Android，目标是 tag 为 "tag1" 的设备，内容是 Android 通知 ALERT，并且标题为 TITLE。
      * @Title: buildPushObject_android_tag_alertWithTitle
      * @Description: TODO
      * @param @param alertContent
      * @param @param title
      * @param @return    设定文件
      * @return PushPayload    返回类型
      * @throws
     */
    public static PushPayload buildPushObject_android_tag_alertWithTitle(String alertContent,String title ) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.tag("tag1"))
                .setNotification(Notification.android(alertContent, title, null))
                .build();
    }
	    
    /**
     * 
      * buildPushObject_android_and_ios(这里用一句话描述这个方法的作用)
      *构建推送对象：平台是 Android 和IOS，目标是 tag 为 "tag1" 的设备，内容是 通知 ALERT，并且标题为 TITLE。
      * @Title: buildPushObject_android_and_ios
      * @Description: TODO
      * @param @param alertContent
      * @param @param title
      * @param @return    设定文件
      * @return PushPayload    返回类型
      * @throws
     */
    public static PushPayload buildPushObject_android_and_ios(String alias,String alertContent,String title,Map<String,String> map) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.newBuilder()
                		.setAlert(alertContent)
                		.addPlatformNotification(AndroidNotification.newBuilder()
                				.setTitle(title).addExtras(map).build())
                		.addPlatformNotification(IosNotification.newBuilder()
                				.incrBadge(1)
                				.addExtras(map).build())
                		.build())
                .build();
    }
	    
    /**
     * 
      * buildPushObject_ios_tagAnd_alertWithExtrasAndMessage()
      * 
      * 构建推送对象：平台是 iOS，推送目标是 "tag1", "tag_all" 的交集，
      * 推送内容同时包括通知与消息 - 通知信息是 ALERT，
      * 角标数字为 5，通知声音为 "happy"，并且附加字段 from = "JPush"；
      * 消息内容是 MSG_CONTENT。
      * 通知是 APNs 推送通道的，消息是 JPush 应用内消息通道的。
      * APNs 的推送环境是“生产”（如果不显式设置的话，Library 会默认指定为开发）
      *
      * @Title: buildPushObject_ios_tagAnd_alertWithExtrasAndMessage
      * @Description: TODO
      * @param @param alertContent
      * @param @param msgContent
      * @param @return    设定文件
      * @return PushPayload    返回类型
      * @throws
     */
	public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage(String alertContent,String msgContent) {
	    return PushPayload.newBuilder()
	            .setPlatform(Platform.ios())
	            .setAudience(Audience.tag_and("tag1", "tag_all"))
	            .setNotification(Notification.newBuilder()
	                    .addPlatformNotification(IosNotification.newBuilder()
	                            .setAlert(alertContent)
	                            .setBadge(5)
	                            .setSound("happy")
	                            .addExtra("from", "JPush")
	                            .build())
	                    .build())
	             .setMessage(Message.content(msgContent))
	             .setOptions(Options.newBuilder()
	                     .setApnsProduction(true)
	                     .build())
	             .build();
	}
	    
	/**
	 * 
	  * buildPushObject_ios_audienceMore_messageWithExtras()
	  *
	  *构建推送对象：平台是 Andorid 与 iOS，推送目标是 （"tag1" 与 "tag2" 的并集）且（"alias1" 与 "alias2" 的并集），
	  *推送内容是 - 内容为 MSG_CONTENT 的消息，并且附加字段 from = JPush。
	  *
	  * @Title: buildPushObject_ios_audienceMore_messageWithExtras
	  * @Description: TODO
	  * @param @param msgContent
	  * @param @return    设定文件
	  * @return PushPayload    返回类型
	  * @throws
	 */
    public static PushPayload buildPushObject_ios_audienceMore_messageWithExtras(String msgContent) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.newBuilder()
                        .addAudienceTarget(AudienceTarget.tag("tag1", "tag2"))
                        .addAudienceTarget(AudienceTarget.alias("alias1", "alias2"))
                        .build())
                .setMessage(Message.newBuilder()
                        .setMsgContent(msgContent)
                        .addExtra("from", "JPush")
                        .build())
                .build();
    }
}
