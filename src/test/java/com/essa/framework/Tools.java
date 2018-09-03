package com.essa.framework;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {

    /**
     * 获取当前时间
     * @return MMdd_HHmmss
     */
    public static String getCurrentTime() {
		SimpleDateFormat format = new SimpleDateFormat("MMdd_HHmmss");
		Date today = new Date();
		String time = format.format(today);
		return time;
	}
    /**
     * 使用当前时间作为工厂货号
     * @return yyyyMMddHHmmss
     */
    public static String getFactoryNo() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Date today = new Date();
		String time = format.format(today);
		return time;
	}
    
    /**
     * 获取当前分和秒，另外加一个随机数，作为注册邮箱的区分的数字
     * @return
     */
    public static String getTime() {
		SimpleDateFormat format = new SimpleDateFormat("mmss");
		Date today = new Date();
		String time = format.format(today);
		int i = (int)(1+Math.random()*(10-1+1));
		return time+i;
	}
    
}
