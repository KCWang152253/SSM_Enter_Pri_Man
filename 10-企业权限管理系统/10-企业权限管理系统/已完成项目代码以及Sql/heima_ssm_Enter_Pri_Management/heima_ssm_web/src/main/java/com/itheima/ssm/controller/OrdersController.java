package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/10/24 16:37
 * @Description TODO
 **/
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll(
            @RequestParam(value = "page",required = true,defaultValue = "1") Integer page,
            @RequestParam(value = "size",required = true,defaultValue = "4") Integer size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Orders> os = ordersService.findAll(page,size);
        //PageInfo就是一个分页Bean
        PageInfo<Orders> pageInfo = new PageInfo(os);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(value = "id",required = true)String orderId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders order = ordersService.findById(orderId);
        mv.addObject("orders",order);
        mv.setViewName("orders-show");
        return mv;
    }

}
