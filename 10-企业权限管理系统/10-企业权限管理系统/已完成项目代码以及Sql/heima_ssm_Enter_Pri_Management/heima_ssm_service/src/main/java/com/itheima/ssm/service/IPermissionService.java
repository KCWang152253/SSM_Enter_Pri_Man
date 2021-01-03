package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/11/7 22:38
 * @Version 1.0
 * @Description TODO
 **/
public interface IPermissionService {

    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    Permission findById(String id);

    void delById(String id);
}
