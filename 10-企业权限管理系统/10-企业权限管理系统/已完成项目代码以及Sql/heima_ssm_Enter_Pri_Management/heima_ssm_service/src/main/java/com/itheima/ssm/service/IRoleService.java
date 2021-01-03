package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/11/7 21:58
 * @Version 1.0
 * @Description TODO
 **/
public interface IRoleService {

    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception ;

    Role findById(String id) throws Exception;

    void deleteRoleById(String id) throws Exception;

    List<Permission> findOtherPermission(String roleId);

    void addRoleToUser(String roleId, String[] permissionId);
}
