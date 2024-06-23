package com.example.util;

public class TimeUtil {
    private TimeUtil(){}

    public static long getCurUnix(){
        // 获取当前时间戳，单位为毫秒
        long currentTimeMillis = System.currentTimeMillis();

        //转换秒
        return currentTimeMillis / 1000;
    }
}
