package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @Author panghl
 * @Date 2020/10/24 13:14
 * @Description TODO
 **/
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

/*    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new DateStringEditor());
    }*/

    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        System.out.println(product.toString());
        productService.save(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList",ps);
        mv.setViewName("product-list");
        return mv;
    }

}
