package com.threefiveninetong.mchh.util;

import java.math.BigDecimal;

public class BigDecimalUtil {
	
	
	//加计算
	public static BigDecimal add(BigDecimal v1, BigDecimal v2){
		return v1.add(v2).setScale(16, BigDecimal.ROUND_DOWN);
	}
	
	
	//减法计算
	public static BigDecimal subtract(BigDecimal v1, BigDecimal v2){
		return v1.subtract(v2).setScale(16, BigDecimal.ROUND_DOWN);
	}
	
	
	//乘法计算
	public static BigDecimal multiply(BigDecimal v1, BigDecimal v2){
		return v1.multiply(v2).setScale(16, BigDecimal.ROUND_DOWN);
	}
	
	
	//除法计算
	public static BigDecimal divide(BigDecimal v1, BigDecimal v2){
		int r=v2.compareTo(BigDecimal.ZERO); 
		if(r==0){
			return BigDecimal.ZERO;
		}
		return v1.divide(v2).setScale(16, BigDecimal.ROUND_DOWN);
	}
	
	
	//判断金额是否为空，为空返回0
	public  static BigDecimal amountUtil(BigDecimal amount){
		 if(amount==null||amount.equals(null)||amount.equals("")){
			 amount=new BigDecimal(0.000000);
		 }
		  return amount;
	}
}
