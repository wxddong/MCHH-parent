package com.threefiveninetong.mchh.util;

import java.util.Date;

public class DateSzie {
    public static String size(Date beginTime, Date endTime) {
        // 拿到系统时间
        String status = "8";
        Date time = new Date();
        // 当系统时间大于结束时间，代表活动已结束
        if (beginTime != null && endTime != null) {
            if (time.compareTo(endTime) > 0) {
                status = "2";
            }
            // 当系统时间大于活动开始时间代表活动还没开始
            if (time.compareTo(beginTime) < 0) {
                status = "0";
            }
            // 当系统时间大于或者等于活动开始时间，且系统时间也小于或者等于结束时间 代表活动进行中
            if (time.compareTo(beginTime) >= 0 && time.compareTo(endTime) <= 0) {
                status = "1";
            }
        }
        return status;
    }

}
