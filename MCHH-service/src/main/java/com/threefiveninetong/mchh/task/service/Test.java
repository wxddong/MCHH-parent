package com.threefiveninetong.mchh.task.service;

import java.util.Calendar;
import java.util.Date;

import com.threefiveninetong.mchh.util.DateStyle;
import com.threefiveninetong.mchh.util.DateUtil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String aa=DateUtil.dateToString(DateUtil.addInteger(new Date(),Calendar.DATE, 3),DateStyle.YYYY_MM_DD);
		System.out.println(aa);
	}

}
