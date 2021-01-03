package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/10/23 23:53
 * @Version 1.0
 * @Description TODO
 **/
public interface IProductService {

    List<Product> findAll() throws Exception;

    void save(Product product)  throws Exception;

}
