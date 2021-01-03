package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/10/28 22:58
 * @Version 1.0
 * @Description TODO
 **/
public interface IUserDao {

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class,
                    many = @Many(select = "com.itheima.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username) throws Exception;

    @Select("select * from users")
    public List<UserInfo> findAll();

    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    public void save(UserInfo userInfo);

    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,
            many = @Many(select = "com.itheima.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id);

    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    List<Role> findOtherRoles(String userId);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId,@Param("roleId") String roleId);
}
