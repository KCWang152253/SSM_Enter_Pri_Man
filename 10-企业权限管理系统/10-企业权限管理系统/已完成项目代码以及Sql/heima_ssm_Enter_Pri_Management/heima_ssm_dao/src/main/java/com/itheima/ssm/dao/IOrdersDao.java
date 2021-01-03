package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/10/24 16:38
 * @Version 1.0
 * @Description TODO
 **/
public interface IOrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "product", column = "productId", javaType = Product.class,
                    one = @One(select = "com.itheima.ssm.dao.IProductDao.findById"))
    })
    List<Orders> findAll() throws Exception;

    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "product",column = "productId",javaType = Product.class,
            one = @One(select = "com.itheima.ssm.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,
            one = @One(select = "com.itheima.ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,
            many = @Many(select = "com.itheima.ssm.dao.ITravellerDao.findByOrdersId"))
    })
    Orders findById(String ordersId) throws Exception;

}
