package com.threefiveninetong.mchh.send.util;


import java.util.List;
import java.util.Map;

import com.threefiveninetong.mchh.po.SmsConfigPO;
import com.threefiveninetong.mchh.task.support.InitSmsTaskSupprot;
import com.threefiveninetong.mchh.core.util.ApplicationContextUtil;

public class InitDictionary {
	
	public static int faileNum=0;

	public static List<SmsConfigPO> InitPlateList;//初始化可用短信平台（list类型）
	
	public synchronized static List<SmsConfigPO> getSmsPlate(){
		while(InitDictionary.InitPlateList==null||InitDictionary.InitPlateList.size()<0){
			InitSmsTaskSupprot plate=ApplicationContextUtil.getBean("initSmsTaskSupprot");
		    plate.InitPalte();
		}
		return InitDictionary.InitPlateList;
	}
	
	public static Map<String,SmsConfigPO> plateMap;//初始化可用短信平台（map类型，key为自定义平台编码，如：YM）
	
	public synchronized static Map<String,SmsConfigPO> getSmsPlateMap(){
		while(InitDictionary.plateMap==null||InitDictionary.plateMap.size()<0){
			if(faileNum>20){//发送的短信渠道为空，即无法发送短信，失败20次后，停15分钟
				try {
					Thread.sleep(900000);//15分钟重新开始
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				faileNum=0;
			}
			faileNum++;
			InitSmsTaskSupprot plate=ApplicationContextUtil.getBean("initSmsTaskSupprot");
		    plate.InitPalte();
		}
		return InitDictionary.plateMap;
	}

	public static String EXCEPTIONID="-1113";//发送短信的时候出异常
	public static String EXCEPTIONMSG="调用接口异常";//发送短信的时候出异常	
	public static double EXCEPTIONBALANCE=-1111;//获取短信余额的时候出异常
	public static double NOBALANCE=-1112;//无此类接口
	
	public static String SMS_ONE_SUFFIX="【三五九通】";
	public static String SMS_TWO_SUFFIX="【快乐University】";
	public static String SMS_MCHH_SUFFIX="【驿马旅行】";
	
	public static final String CHUNLIN_REGEX=",";//春霖群发分隔符
	public static final String RONGDA_REGEX=";";//容大群发分隔符
	public static final String GUODU_REGEX=",";//国都群发分隔符
	public static final String JUXINTONG_REGEX=",";//据信通群发分隔符
	public static final String MANDAO_REGEX=",";//据信通群发分隔符
	public static final String DEVSOURCE_REGEX=",";//鼎源群发分隔符
	
	
	
	
	
	
	
	public static  String GD_CHARSET="gbk";//国都传送消息的编码格式
	
	public static  String CL_CHARSET="utf-8";//春霖传送消息的编码格式
	
	public static  String RD_CHARSET="utf-8";//容大传送消息的编码格式
	
	public static  String JX_CHARSET="utf-8";//聚信通传送消息的编码格式
	
	public static  String MD_CHARSET="utf-8";//漫道科技通传送消息的编码格式
	
	public static String TASK_SMSSEND="SMS_TASK";
	
	public static long TASK_SMSTYPE=222;
	
	public static String NOT_ALLOW_SMSTYPE="111,123,142";//补发的时候，哪些短信类型不需要重新发送
	
	public static String NOT_ALLOW_PHONE="13581909395,13701099464";//不发送的手机号，黑名单
	
	public static final String FAILSMSTYPE="-1111";//短信类型不符合
	
	public static final String FAILPHONETYPE="-1112";//手机号码类型不符合
	
	public static final String FAILPHONEMSG="限定,该手机号码不匹配当前平台";//手机号码类型不符合
	
	public static final String FAILSMSMSG="限定,该短信类型不匹配当前平台";//短信类型不符合
	
	

}
