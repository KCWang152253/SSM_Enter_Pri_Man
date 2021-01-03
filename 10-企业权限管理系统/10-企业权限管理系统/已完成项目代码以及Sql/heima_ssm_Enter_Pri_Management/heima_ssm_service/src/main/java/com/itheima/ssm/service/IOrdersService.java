package com.itheima.ssm.service;

import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Product;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/10/24 16:38
 * @Version 1.0
 * @Description TODO
 **/
public interface IOrdersService {
    List<Orders> findAll(int page,int size) throws Exception;

    Orders findById(String orderId) throws  Exception;
}
