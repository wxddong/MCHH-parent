package com.threefiveninetong.mchh.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * double转换类
 * @author zhanght
 */
public class DoubleUtil {
	
	//默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;
	/** 
	 * @Title: transfDouble 
	 * @Description: TODO double转字符串，默认取小数点后两位，四舍五入
	 * @param: @param param
	 * @param: @return
	 * @return: String
	 */
	public static String transfDouble(double param) {
		return transfDouble(param,"#0.##",null);
	}
    
	/** 
	 * @Title: transfDouble 
	 * @Description: TODO double转字符串，四舍五入
	 * @param: @param param double参数
	 * @param: @param pattern 取值格式
	 * @param: @return
	 * @return: String
	 */
	public static String transfDouble(double param,String pattern) {
		return transfDouble(param,pattern,null);
	}
	
	/**
	 * @Title: transfDouble 
	 * @Description: TODO double转字符串，默认取小数点后两位
	 * @param: @param param 参数
	 * @param: @param mode 取值模式
	 * @param: @return
	 * @return: String
	 */
	public static String transfDouble(double param,RoundingMode mode) {
		//double保存两位
		DecimalFormat df  = new DecimalFormat();
		//取值方式floor多余部分去除
		df.setRoundingMode(mode);
		return transfDouble(param,"#0.##",mode);
	}
	
	/** 
	 * @Title: transfDouble 
	 * @Description: TODO double转字符串
	 * @param: @param param 参数
	 * @param: @param pattern 取值格式
	 * @param: @param mode 取值模式
	 * @param: @return
	 * @return: String
	 */
	public static String transfDouble(double param,String pattern,RoundingMode mode) {
		//double保存两位
		DecimalFormat df  = new DecimalFormat(pattern);
		//取值方式floor多余部分去除
		if(mode!=null)
			df.setRoundingMode(mode);
		return df.format(param);
	}
	/**
	 * 判断double 是否能转换为int true-是  false-否
	 * @param param
	 * @return
	 */
	public static boolean whetherDouble(Double param) {
		if (param%1 == 0) {
			return true;
		} else {
			return false;
		}
	}

    /**  
    * 对double数据进行取精度.  
    * @param value  double数据.  
    * @param scale  精度位数(保留的小数位数).  
    * @param roundingMode  精度取值方式.  
    * @return 精度计算后的数据.  
    */  
   public static double round(double value, int scale, int roundingMode) {   
       BigDecimal bd = new BigDecimal(value);   
       bd = bd.setScale(scale, roundingMode);   
       double d = bd.doubleValue();   
       bd = null;   
       return d;   
   }   

   /** 
	 * @Title: add 
	 * @Description: TODO 相加
	 * @param: @param d1 
	 * @param: @param d2
	 * @param: @return
	 * @return: double
	 */
   public static double add(double d1,double d2){ 
       BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
       BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
       return bd1.add(bd2).doubleValue(); 
   } 
   
   /** 
    * 多位double加法运算
    * @param doubles
    * @return
    */
   public static double addMore(double...doubles) {
	   BigDecimal out = BigDecimal.ZERO;
	   for (double d : doubles) {
		   out = out.add(new BigDecimal(d));
	   }
	   return out.doubleValue();
   }
   
   /** 
	 * @Title: sub 相减
	 * @Description: TODO
	 * @param: @param d1
	 * @param: @param d2
	 * @param: @return
	 * @return: double
	 */
	public static double sub(double d1,double d2){ 
       BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
       BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
       return bd1.subtract(bd2).doubleValue(); 
   } 

   /** 
	 * @Title: mul 
	 * @Description: TODO 乘法 
	 * @param: @param d1
	 * @param: @param d2
	 * @param: @return
	 * @return: double
	 */
	public static double mul(double d1,double d2){ 
       BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
       BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
       return bd1.multiply(bd2).doubleValue(); 
   } 
   
   /** 
	 * @Title: div 
	 * @Description: TODO 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入。
	 * @param: @param v1 被除数
	 * @param: @param v2 除数
	 * @param: @return 两个参数的商
	 * @return: double
	 */
	public static double div(double d1,double d2){
       return div(d1,d2,DEF_DIV_SCALE);
   }


   /** 
    * double 除法 
    * @param d1 
    * @param d2 
    * @param scale 四舍五入 小数点位数 
    * @return 
    */ 
   public static double div(double d1,double d2,int scale){ 
	   //  当然在此之前，你要判断分母是否为0，   
       //  为0你可以根据实际需求做相应的处理 
	   if(scale<0){
           throw new IllegalArgumentException(
               "The scale must be a positive integer or zero");
       }

       BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
       BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
       return bd1.divide 
              (bd2,scale,BigDecimal.ROUND_HALF_UP).doubleValue(); 
   } 

	
}
