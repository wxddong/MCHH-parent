package com.threefiveninetong.mchh.util;

import java.util.Random;

public final class SecretKeyUtil {
	/**
	 * 生成随机密码
	 * 
	 * @return
	 */
	public static String getPass() {
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random rand = new Random();
		for (int i = 10; i > 1; i--) {
			int index = rand.nextInt(i);
			int tmp = array[index];
			array[index] = array[i - 1];
			array[i - 1] = tmp;
		}
		int result = 0;
		for (int i = 0; i <= 6; i++) {
			result = result * 10 + array[i];
		}
		// long now = System.currentTimeMillis();//一个13位的时间戳
		String paymentID = String.valueOf(result);
		return paymentID;
	}

	/**
	 * 生成订单编号
	 * 
	 * @return
	 */
	public static String getNumber() {
		int r1 = (int) (Math.random() * (10));// 产生2个0-9的随机数
		int r2 = (int) (Math.random() * (10));
		long now = System.currentTimeMillis();// 一个13位的时间戳
		String paymentID = String.valueOf(r1) + String.valueOf(r2)
				+ String.valueOf(now);
		return paymentID; 
	}

	// 生成5位随机数
	public static String getPassNumber() {
		int n = 0;
		n = (int) (Math.random() * 100000);
		while (n < 10000 || !handle(n)) {
			n = (int) (Math.random() * 100000);
		}
		return String.valueOf(n);
	}

	public static boolean handle(int n) {
		int[] list = new int[5];
		for (int i = 0; i < 5; i++) {
			list[i] = n % 10;
			n = n / 10;
		}
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (list[i] == list[j])
					return false;
			}
		}
		return true;
	}
}
