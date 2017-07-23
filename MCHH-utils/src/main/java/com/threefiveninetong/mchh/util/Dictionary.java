/**   
 * Copyright © 2016 三五九通. All rights reserved.
 * @Title: Dictionary.java 
 * @Prject: MCHH-utils
 * @Package: com.threefiveninetong.mchh.util 
 * @Description: TODO
 * @author: dingjh   
 * @date: 2016年1月14日 下午3:47:03 
 * @version: V1.0   
 */
package com.threefiveninetong.mchh.util;
/** 
 * @ClassName: Dictionary 
 * @Description: TODO
 * @author: dingjh
 * @date: 2016年1月14日 下午3:47:03  
 */
public class Dictionary {
	
//	public class TaskExecCron {
//		
//		//订单取消分钟数 45分钟
//		public static final int minute = 45;
//		
//		//是否开启订单状态检测
//		public static final boolean checkOrderCancelWhether = false;
//		
//		//开启订单已出行状态检测
//		public static final boolean checkOrderNotTravelWhether = false;
//		
//		//是否开启产品状态监测
//		public static final boolean checkProductWhether = false;
//		
//		//每隔5分钟执行一次--订单已取消状态
//		public static final String checkOrderCancel = "*/5 * * * * ?";
//		
//		//每天x点执行一次--订单未出行状态
//		public static final String checkOrderNotTravel = "*/5 * * * * ?";
//		
//		//产品状态
//		public static final String checkProductstart = "*/5 * * * * ?";
//		
//		//下载关闭时间 23小时50分钟后开始下一次轮训下载/检测b
//		public static final int downloadendhour = 23; 
//		public static final int downloadendminut = 50; 
//	}
//	
//	/**
//	 * 会员等级
//	 * @author zhanght
//	 */
//	public enum MbrStarsStatus {
//		普通("0"),钻石("1");
//		private String value;
//			
//		MbrStarsStatus(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 会员操作记录操作类型
//	 * @author zhanght
//	 */
//	public enum OptRecordOrnType {
//		忘记密码("0"),修改密码("1"),完善信息("2"),会员邮箱("3"),常用地址("4"),常用人("5"),足迹("6"),收藏("7"),订单("8");
//		private String value;
//			
//		OptRecordOrnType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 常用旅客类型
//	 * @author zhanght
//	 */
//	public enum MbrTravelerType {
//		常用出行人("0"),常用乘机人("1"),常用被办人("2"),常用被保人("3");
//		private String value;
//			
//		MbrTravelerType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 跟团游产品扩展表-跟团游类型
//	 * @author zhanght
//	 */
//	public enum TourType {
//		经济游("0"),舒适游("1"),深度游("2"),豪华游("3");
//		private String value;
//			
//		TourType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 活动推荐类型
//	 * @author zhanght
//	 */
//	public enum ActivityRecommendType {
//		已推荐("0"),不推荐("1");
//		private String value;
//			
//		ActivityRecommendType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 活动删除情况
//	 * @author 周照
//	 */
//	public enum ActivityDeleteSign{
//		未删除("0"),已删除("1");
//		private String value;
//			
//		ActivityDeleteSign(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 活动删除情况
//	 * @author 周照
//	 */
//	public enum AdvertisingDeleteSign{
//		未删除("0"),已删除("1");
//		private String value;
//			
//		AdvertisingDeleteSign(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 产品表-产品类型：0-跟团游  1-机票 2：签证；3：通讯；4：保险
//	 * @author 
//	 */
//	public enum ProductType {
//		跟团游("0"),机票("1"),签证("2"),游通讯("3"),保险("4");
//		private String value;
//			
//		ProductType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//		
//		public static String getName(String typeValue) {
//			if (!StringUtil.isNullOrBlank(typeValue)) {
//				if (ProductType.跟团游.getValue().equals(typeValue)) {
//					return ProductType.跟团游.name();
//				} else if (ProductType.机票.getValue().equals(typeValue)) {
//					return ProductType.机票.name();
//				} else if (ProductType.签证.getValue().equals(typeValue)) {
//					return ProductType.签证.name();
//				} else if (ProductType.游通讯.getValue().equals(typeValue)) {
//					return ProductType.游通讯.name();
//				} else if (ProductType.保险.getValue().equals(typeValue)) {
//					return ProductType.保险.name();
//				}
//			}
//			return null;
//		}
//	}
//	
//	
//	/**
//	 * 订单表-订单状态
//	 * @author zhanght
//	 */
//	public enum OrderStatusType {
//		未出行("0"),已出行("1"),已删除("2"),已取消("3"),预下单("4");
//		private String value;
//			
//		OrderStatusType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//		
//		public static String getName(String typeValue) {
//			if (!StringUtil.isNullOrBlank(typeValue)) {
//				if (OrderStatusType.未出行.getValue().equals(typeValue)) {
//					return OrderStatusType.未出行.name();
//				} else if (OrderStatusType.已出行.getValue().equals(typeValue)) {
//					return OrderStatusType.已出行.name();
//				} else if (OrderStatusType.已删除.getValue().equals(typeValue)) {
//					return OrderStatusType.已删除.name();
//				} else if (OrderStatusType.已取消.getValue().equals(typeValue)) {
//					return OrderStatusType.已取消.name();
//				} else if (OrderStatusType.预下单.getValue().equals(typeValue)) {
//					return OrderStatusType.预下单.name();
//				}
//			}
//			return null;
//		}
//	}
//	
//	/**
//	 * 订单表-支付状态
//	 * @author zhanght
//	 */
//	public enum OrderPayStatusType {
//		未支付("0"),支付中("1"),支付成功("2"),支付失败("3");
//		private String value;
//			
//		OrderPayStatusType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//		
//		public static String getName(String typeValue) {
//			if (!StringUtil.isNullOrBlank(typeValue)) {
//				if (OrderPayStatusType.未支付.getValue().equals(typeValue)) {
//					return OrderPayStatusType.未支付.name();
//				} else if (OrderPayStatusType.支付中.getValue().equals(typeValue)) {
//					return OrderPayStatusType.支付中.name();
//				} else if (OrderPayStatusType.支付成功.getValue().equals(typeValue)) {
//					return OrderPayStatusType.支付成功.name();
//				} else if (OrderPayStatusType.支付失败.getValue().equals(typeValue)) {
//					return OrderPayStatusType.支付失败.name();
//				} 
//			}
//			return null;
//		}
//	}
//	
//	/**
//	 * 订单表-退款状态
//	 * @author zhanght
//	 */
//	public enum OrderRefundStatusType {
//		退款中("0"),已退款("1"),有退款("2");
//		private String value;
//			
//		OrderRefundStatusType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//		
//		public static String getName(String typeValue) {
//			if (!StringUtil.isNullOrBlank(typeValue)) {
//				if (OrderRefundStatusType.退款中.getValue().equals(typeValue)) {
//					return OrderRefundStatusType.退款中.name();
//				} else if (OrderRefundStatusType.已退款.getValue().equals(typeValue)) {
//					return OrderRefundStatusType.已退款.name();
//				} else if (OrderRefundStatusType.有退款.getValue().equals(typeValue)) {
//					return OrderRefundStatusType.有退款.name();
//				}
//			}
//			return null;
//		}
//	}
//	
//	/**
//	 * 订单表-评价状态
//	 * @author zhanght
//	 */
//	public enum OrderEvaluateStatusType {
//		未评价("0"),已评价("1");
//		private String value;
//			
//		OrderEvaluateStatusType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//		
//		public static String getName(String typeValue) {
//			if (!StringUtil.isNullOrBlank(typeValue)) {
//				if (OrderEvaluateStatusType.未评价.getValue().equals(typeValue)) {
//					return OrderEvaluateStatusType.未评价.name();
//				} else if (OrderEvaluateStatusType.已评价.getValue().equals(typeValue)) {
//					return OrderEvaluateStatusType.已评价.name();
//				}
//			}
//			return null;
//		}
//	}
//	
//	/**
//	 * 产品图片类型
//	 * @author zhanght
//	 */
//	public enum ProductImgType {
//		跟团游展示图片("0"),特色路线图("1"),签证详情图("2");
//		private String value;
//			
//		ProductImgType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 产品交通信息交通类型
//	 * @author zhanght
//	 */
//	public enum TourTrafficVehicleType {
//		飞机("0"),轮船("1"),火车("2");
//		private String value;
//			
//		TourTrafficVehicleType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 产品交通信息去程/回程
//	 * @author zhanght
//	 */
//	public enum TourTrafficGoOrReturnType {
//		去程("0"),回程("1");
//		private String value;
//			
//		TourTrafficGoOrReturnType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 意见反馈处理状态
//	 * @author zhanght
//	 */
//	public enum FeedbackOptType {
//		未处理("0"),已处理("1");
//		private String value;
//			
//		FeedbackOptType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 产品购买方式
//	 * @author zhanght
//	 */
//	public enum OrderPayWayType {
//		现金("0"),积分("1"),现金和积分("2");
//		private String value;
//			
//		OrderPayWayType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 是否需要发票
//	 * @author zhanght
//	 */
//	public enum OrderInvoiceType {
//		不需要("0"),需要("1");
//		private String value;
//			
//		OrderInvoiceType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 证件类型
//	 * @author zhanght
//	 */
//	public enum CredentialsType {
//		护照("0"),身份证("1");
//		private String value;
//			
//		CredentialsType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 成人儿童标示
//	 * @author zhanght
//	 */
//	public enum AdultOrChildType {
//		成人("0"),儿童("1");
//		private String value;
//			
//		AdultOrChildType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 发票明细
//	 * @author zhanght
//	 */
//	public enum InvoiceDetailType {
//		旅游服务费("0"),机票与酒店("1"),服务费("2");
//		private String value;
//			
//		InvoiceDetailType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 优惠券是否已被使用
//	 * @author zhanght
//	 */
//	public enum CouponUseType {
//		没使用("0"),已使用("1");
//		private String value;
//			
//		CouponUseType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 优惠券适用产品
//	 * @author zhanght
//	 */
//	public enum CouponApplyProductType {
//		全部("0"),跟团游("1"),机票("2"),团签证("3"),保险("4"),游通讯("5");
//		private String value;
//			
//		CouponApplyProductType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 优惠券适用渠道
//	 * @author zhanght
//	 */
//	public enum CouponApplyChannelType {
//		全部("0"),手机("1"),PC("2");
//		private String value;
//			
//		CouponApplyChannelType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 支付方式：1-支付宝  2-微信  3-银联  4-支付宝扫码  5-微信扫码
//	 * @author zhanght
//	 */
//	public enum PayType {
//		ALIPAY("1"),WEIXINPAY("2"), UNIONPAY("3"), ALIQRPAY("4"), WEIXINQRPAY("5");
//		private String value;
//			
//		PayType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//		
//		public static PayType getByCode(String code) {
//			if (!StringUtil.isNullOrBlank(code)) {
//				if ("1".equals(code)) {
//					return ALIPAY;
//				} else if ("2".equals(code)) {
//					return WEIXINPAY;
//				} else if ("3".equals(code)) {
//					return UNIONPAY;
//				}  else if ("4".equals(code)) {
//					return ALIQRPAY;
//				} else if ("5".equals(code)) {
//					return WEIXINQRPAY;
//				} 
//			}
//			return null;
//		}
//	}
//	
//	/**
//	 * 订单支付流水类型
//	 * @author zhanght
//	 */
//	public enum OrderPayJournalType {
//		订单支付("0"),改签收款("1");
//		private String value;
//			
//		OrderPayJournalType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * @ClassName: PayState 
//	 * @Description: 支付状态
//	 * @author: zhanght
//	 * @date: 2016年1月25日 下午3:02:23
//	 */
//	public enum PayState {
//		PROCESS("0"), SUCCESS("1"), FAIL("2"), REFUND("3"), ERROR("4"), PROCESS_FROZEN("5");
//
//		private String code;
//
//		PayState(String code) {
//			this.code = code;
//		}
//
//		public String getCode() {
//			return code;
//		}
//
//		public static PayState getByCode(String code) {
//			if (!StringUtil.isNullOrBlank(code)) {
//				if ("0".equals(code)) {
//					return PROCESS;
//				} else if ("1".equals(code)) {
//					return SUCCESS;
//				} else if ("2".equals(code)) {
//					return FAIL;
//				} else if ("3".equals(code)) {
//					return REFUND;
//				} else if ("4".equals(code)) {
//					return ERROR;
//				} else if ("5".equals(code)) {
//					return PROCESS_FROZEN;
//				}
//			}
//			return null;
//		}
//	}	
//	
//	/**
//	 * 订单使用类型记录
//	 * @author zhanght
//	 */
//	public enum OrderPersonType {
//		出行人("0"),乘机人("1"),被办人("2"),被保人("3");
//		private String value;
//			
//		OrderPersonType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 跟团游产品扩展表-特卖标示
//	 * @author zhanght
//	 */
//	public enum PackageTourSpecialSignType {
//		普通("0"),特卖("1"),折扣("2"),限时特卖("3");
//		private String value;
//			
//		PackageTourSpecialSignType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 申请退款状态
//	 * @author zhouzhao
//	 */
//	public enum RefundInfoStatus {
//		退款中("1"),退款完成("2");
//		private String value;
//		RefundInfoStatus(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
//	
//	/**
//	 * 退款方式状态
//	 * @author zhouzhao
//	 */
//	public enum RefundInfoType {
//		原卡退回("0"),优惠劵("1");
//		private String value;
//		RefundInfoType(String value) {
//			this.value = value;
//		}
//		
//		public String getValue() {
//			return value;
//		}
//	}
}
