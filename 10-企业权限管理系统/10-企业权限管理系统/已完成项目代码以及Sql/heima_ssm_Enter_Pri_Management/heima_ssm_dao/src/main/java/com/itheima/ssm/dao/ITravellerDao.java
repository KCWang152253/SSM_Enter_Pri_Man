package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/10/27 21:52
 * @Version 1.0
 * @Description TODO
 **/
public interface ITravellerDao {

    @Select("select * from traveller where id in " +
            "(select travellerId from order_traveller where orderId = #{ordersId}) ")
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
