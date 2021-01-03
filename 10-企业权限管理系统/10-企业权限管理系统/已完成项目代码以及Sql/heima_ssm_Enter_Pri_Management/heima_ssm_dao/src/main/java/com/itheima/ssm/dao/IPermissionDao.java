package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/11/7 17:00
 * @Version 1.0
 * @Description TODO
 **/
public interface IPermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    List<Permission> findPermissionByRoleId(String id) throws Exception;

    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);

    @Select("select * from permission where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "id", property = "roles", javaType = java.util.List.class,
                    many = @Many(select = "com.itheima.ssm.dao.IRoleDao.findRoleByPermissionId"))
    })
    Permission findById(String id);

    @Delete("delete from role_permission where permissionId = #{id}")
    void delRole_PermissionByPermissionId(String id);

    @Delete("delete from permission where id = #{id}")
    void delById(String id);
}
