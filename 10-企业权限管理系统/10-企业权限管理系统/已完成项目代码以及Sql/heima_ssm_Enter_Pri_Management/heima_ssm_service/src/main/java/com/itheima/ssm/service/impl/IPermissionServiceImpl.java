package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IPermissionDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/11/7 22:38
 * @Description TODO
 **/
@Service
public class IPermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }

    @Override
    public Permission findById(String id) {
        return permissionDao.findById(id);
    }

    @Override
    public void delById(String id) {
        //从role_permission表删除
        permissionDao.delRole_PermissionByPermissionId(id);
        //从资源权限表中删除
        permissionDao.delById(id);
    }
}
