/**
 * 
 */
package com.itinna.smalltool.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 日期处理工具
 * 
 * @author tinna.xie
 *
 */
public class DateUtils extends org.apache.commons.lang.time.DateUtils {

    private static Logger      logger           = Logger.getLogger(DateUtils.class);

    public static final String DATE_FORMATTER_1 = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMATTER_2 = "yyyy-MM-dd";

    public static final String DATE_FORMATTER_3 = "HH:mm:ss";

    public static final String DATE_FORMATTER_4 = "yyyyMMddHHmmss";

    public static String format(Date date, String format) {
        String ret = null;
        if (date == null || StringUtils.isEmpty(format)) {
            return ret;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        ret = sdf.format(date);

        return ret;
    }

    public static Date format(String date, String format) {
        Date ret = null;
        try {
            if (StringUtils.isNotEmpty(date) && StringUtils.isNotEmpty(format)) {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                ret = sdf.parse(date);
            }
        } catch (ParseException e) {
            logger.error(e);
            System.out.println(e);
            ret = null;
        }
        return ret;
    }

    /**
     * 日期天数加减计算
     * @param date 被加减日期
     * @param days 天数
     * @return
     */
    public static Date addDays(Date date, int days) {
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, days);
            date = cal.getTime();
        }
        return date;
    }

    /**
     * 日期天数加减计算
     * @param date 被加减日期，格式为：yyyy-MM-dd
     * @param days 天数
     * @return
     */
    public static Date addDays(String date, int days) {
        Date dt = format(date, DATE_FORMATTER_2);
        return addDays(dt, days);
    }

    public static void main(String[] args) {
        String date = "2012-03-31";
        Date dt = format(date, DATE_FORMATTER_2);
        System.out.println(dt);
        dt = addDays(dt, -1);
        System.out.println(dt);
    }

}
