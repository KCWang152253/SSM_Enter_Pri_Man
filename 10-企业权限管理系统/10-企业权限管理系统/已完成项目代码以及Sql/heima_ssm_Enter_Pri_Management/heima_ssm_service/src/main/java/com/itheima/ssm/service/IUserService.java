package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/10/28 22:54
 * @Version 1.0
 * @Description TODO
 **/
public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll()  throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id);

    List<Role> findOtherRoles(String userId);

    void addRoleToUser(String userId, String[] roleIds) throws Exception;
}
