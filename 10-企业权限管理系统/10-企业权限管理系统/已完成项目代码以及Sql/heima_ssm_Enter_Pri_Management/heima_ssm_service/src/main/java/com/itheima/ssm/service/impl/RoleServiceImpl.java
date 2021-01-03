package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/11/7 21:58
 * @Description TODO
 **/
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(String id) throws Exception {
        return roleDao.findById(id);
    }

    @Override
    public void deleteRoleById(String id) throws Exception {
        //从user_role表中删除
        roleDao.deleteFromUser_RoleByRoleId(id);
        //从role_permission表中删除
        roleDao.deleteFromRole_PermissionByRoleId(id);
        //从role表中删除
        roleDao.delById(id);
    }

    @Override
    public List<Permission> findOtherPermission(String roleId) {
        return roleDao.findOtherPermission(roleId);
    }

    @Override
    public void addRoleToUser(String roleId, String[] permissionIds) {
        for (String permissionId:permissionIds) {
            roleDao.addRoleToUser(roleId,permissionId);
        }
    }
}
