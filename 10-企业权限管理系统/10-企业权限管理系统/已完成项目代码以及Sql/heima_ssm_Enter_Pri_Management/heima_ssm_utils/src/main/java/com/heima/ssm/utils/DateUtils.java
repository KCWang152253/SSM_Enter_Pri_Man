package com.heima.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author panghl
 * @Date 2020/10/24 14:24
 * @Description TODO
 **/
public class DateUtils {

    //日期转换成字符串

    public static String date2String(Date date,String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String returnStr = sdf.format(date);
        return returnStr;
    }

    //字符串转换成日期

    public static Date string2Date(String str,String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = null;
        try {
            parse = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

}
