package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/10/29 20:23
 * @Version 1.0
 * @Description TODO
 **/
public interface IRoleDao {

    //根据用户id查询出所有对应的角色

    @Select("select * from role where id in(select roleId from users_role where userId=#{userId})")
    @Results({
        @Result(id = true,column = "id",property = "id"),
        @Result(property = "permissions",column = "id",javaType = java.util.List.class,
        many =  @Many(select = "com.itheima.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);


    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "id",property = "permissions",javaType = java.util.List.class,
            many = @Many(select = "com.itheima.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(String id);

    @Delete("delete from role where id = #{id}")
    void delById(String id);

    @Delete("delete from users_role where roleId = #{id}")
    void deleteFromUser_RoleByRoleId(String id);
    @Delete("delete from role_permission where roleId = #{id}")
    void deleteFromRole_PermissionByRoleId(String id);

    @Select("select * from role where id  in ( select roleId from role_permission where permissionId = #{id})")
    List<Role> findRoleByPermissionId(String id);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermission(String roleId);

    @Insert("insert into role_permission(permissionId,roleId) values(#{permissionId},#{roleId})")
    void addRoleToUser(@Param("roleId")String roleId,@Param("permissionId") String permissionId);
}
