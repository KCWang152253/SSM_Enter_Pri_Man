package com.itheima.ssm.domain;

import lombok.Data;
import org.springframework.security.core.userdetails.User;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/10/28 21:37
 * @Description 角色类
 **/
@Data
public class Role {
    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<User> users;
}
