package com.heima.ssm.utils;

import org.springframework.beans.propertyeditors.PropertiesEditor;
import java.util.Date;


/**
 * @Author panghl
 * @Date 2020/10/27 16:04
 * @Description 日期与字符串转换
 **/
public class DateStringEditor extends PropertiesEditor {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Date date = DateUtils.string2Date(text, "yyyy-MM-dd HH-mm");
        super.setValue(date);
    }

}
