package com.itheima.ssm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IOrdersDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/10/24 16:38
 * @Description TODO
 **/
@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page, int size) throws Exception {
        //参数pageNum是页码数  参数pageSize代表是每页显示条数
        Page<Object> pageObj = PageHelper.startPage(page, size);
        List<Orders> os = ordersDao.findAll();
        return os;
    }

    @Override
    public Orders findById(String orderId) throws Exception {
        return ordersDao.findById(orderId);
    }
}
