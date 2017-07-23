package com.threefiveninetong.mchh.util;

public class GeographicalUtil {
	/**
	 * 方法: getAround <br>
	 * 描述: 根据经纬度和半径计算经纬度范围 <br>
	 * 作者: zhouzhao <br>
	 * 时间: 2013-12-18 上午11:23:40
	 * @param longitude 经度
	 * @param latitude 纬度
	 * @param raidus 半径, 单位:米
	 * @return { minLongitude, minLatitude, maxLongitude, maxLatitude }
	 */
	public static double[] getScope(double longitude, double latitude, int raidus) {
		double degree = (24901 * 1609) / 360.0;
		double raidusMile = raidus;

		double dpmLat = 1 / degree;
		double radiusLat = dpmLat * raidusMile;
		double minLatitude = latitude - radiusLat;
		double maxLatitude = latitude + radiusLat;

		double mpdLng = degree * Math.cos(latitude * (Math.PI / 180));
		double dpmLng = 1 / mpdLng;
		double radiusLng = dpmLng * raidusMile;
		double minLongitude = longitude - radiusLng;
		double maxLongitude = longitude + radiusLng;
		return new double[] { minLongitude, minLatitude, maxLongitude, maxLatitude };
	}
}
