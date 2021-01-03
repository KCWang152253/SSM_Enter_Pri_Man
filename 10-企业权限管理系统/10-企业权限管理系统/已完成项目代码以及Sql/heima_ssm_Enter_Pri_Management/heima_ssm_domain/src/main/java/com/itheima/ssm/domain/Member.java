package com.itheima.ssm.domain;

import lombok.Data;

/**
 * @Author panghl
 * @Date 2020/10/24 16:34
 * @Description TODO
 **/
@Data
public class Member {
    private String id;
    private String name;
    private String nickname;
    private String phoneNum;
    private String email;
}
