package com.threefiveninetong.mchh.util;

import java.util.Date;

public class DictionaryForApi {
	
	public static final String RESP_CODE_SUCCESS = "0000";
	
	public static final String RESP_CODE_EXP_PARAMETER = "-1001";
	
	public static final String RESP_CODE_EXP_SERVER = "-2001";
	
	public static final String RESP_CODE_EXP_LOGIC = "-3001";
	
	public static final String RESP_CODE_SPECIAL = "1111";
	
	/**
	 * 阶段状态
	 * @author zhanght
	 */
	public enum StageStatus {
		备孕期("0"),孕产期("1"),育儿期("2"),医院("3");
		private String value;
			
		StageStatus(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * 会员状态
	 * @author zhanght
	 */
	public enum EffectStatus {
		无效("0"),有效("1");
		private String value;
			
		EffectStatus(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * 意见处理状态
	 * @author zhanght
	 */
	public enum FeedBackStatus {
		未处理("0"),已处理("1");
		private String value;
			
		FeedBackStatus(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * 会员等级
	 * @author zhanght
	 */
	public enum MbrStarsStatus {
		普通("0"),钻石("1");
		private String value;
			
		MbrStarsStatus(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * 会员性别
	 * @author zhanght
	 */
	public enum MbrSexStatus {
		女("0"),男("1");
		private String value;
			
		MbrSexStatus(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * 访问量表访问类型
	 * @author zhanght
	 */
	public enum VisitCountTypeForApi {
		激活("1"),登录("2"),注册("3");
		private String value;
			
		VisitCountTypeForApi(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * 结案状态
	 * @author zhanght
	 */
	public enum ClosedStatus {
		未结案("0"),已结案("1");
		private String value;
			
		ClosedStatus(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * 通知来源
	 * @author zhanght
	 */
	public enum MsgSource {
		医院通知("0"),系统通知("1");
		private String value;
			
		MsgSource(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * 孕产期自我记录孕期阶段
	 * @author zhanght
	 */
	public enum GestationPeriod {
		孕1至3月("0"),孕4至7月("1"),孕8至10月("2");
		private String value;
			
		GestationPeriod(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * 孕产期自我记录点亮状态
	 * @author zhanght
	 */
	public enum LightStatus {
		熄灭("0"),点亮("1");
		private String value;
			
		LightStatus(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * 育儿期宝宝牙齿位置
	 * @author zhanght
	 */
	public enum ToochGrowPosition {
		左一("0"),左二("1"),左三("2"),左四("3"),左五("4"),左六("5"),左七("6"),左八("7"),左九("8"),左十("9"),右一("10"),右二("11"),右三("12"),右四("13"),右五("14"),右六("15"),右七("16"),右八("17"),右九("18"),右十("19");
		private String value;
			
		ToochGrowPosition(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * 育儿期年龄
	 * @author zhanght
	 */
	public enum PostpartumAge {
		一个月("0.1"),三个月("0.3"),六个月("0.6"),八个月("0.8"),一岁("1"),一岁半("1.6"),两岁("2"),两岁半("2.6"),
		三岁("3"),四岁("4"),五岁("5"),六岁("6");
		
		private String value;
			
		PostpartumAge(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * 会员操作记录类型
	 * @author zhanght
	 */
	public enum MbrOptType {
		修改密码("0"),更新个人信息("1");
		
		private String value;
			
		MbrOptType(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
}
