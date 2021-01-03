package com.itheima.ssm.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author panghl
 * @Date 2020/11/9 21:11
 * @Description TODO
 **/
@Data
public class SysLog {
    private String id;
    private Date visitTime;
    private String visitTimeStr;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;

    public String getVisitTimeStr() {
        if (visitTime!=null){
            visitTimeStr = visitTime.toString();
        }
        return visitTimeStr;
    }
}

