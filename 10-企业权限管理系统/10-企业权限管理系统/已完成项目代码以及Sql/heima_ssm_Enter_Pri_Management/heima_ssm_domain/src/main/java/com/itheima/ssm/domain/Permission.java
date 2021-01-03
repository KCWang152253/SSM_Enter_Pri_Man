package com.itheima.ssm.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/10/28 21:38
 * @Description 资源权限类
 **/
@Data
public class Permission {
    private String id;
    private String permissionName;
    private String url;
    private List<Role> roles;
}
