package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/10/23 23:51
 * @Version 1.0
 * @Description TODO
 **/
public interface IProductDao {

    //根据id查询产品
    @Select("select * from product where id = #{id}")
    public Product findById(String id) throws Exception;

    //查询所有产品信息
    @Select("select * from product")
    List<Product> findAll () throws Exception;

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws  Exception;
}
