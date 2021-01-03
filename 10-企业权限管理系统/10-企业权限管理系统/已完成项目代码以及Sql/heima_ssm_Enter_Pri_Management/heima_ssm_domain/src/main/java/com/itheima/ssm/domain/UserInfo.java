package com.itheima.ssm.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/10/28 21:36
 * @Description 用户信息类
 **/
@Data
public class UserInfo {
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private String statusStr;
    private List<Role> roles;


    public String getStatusStr() {
        if (status==0){
            statusStr="未开启";
        }else if (status==1){
            statusStr="开启";
        }
        return statusStr;
    }
}
