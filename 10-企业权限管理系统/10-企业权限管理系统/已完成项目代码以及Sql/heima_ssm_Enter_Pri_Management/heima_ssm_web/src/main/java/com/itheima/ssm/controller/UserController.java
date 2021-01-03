package com.itheima.ssm.controller;

/**
 * @Author panghl
 * @Date 2020/11/5 22:06
 * @Description TODO
 **/

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


/*    @GetMapping("/showLoginName")
    public Map<String,String> showName(){
        //获取用户登录名
        String name = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        return map;
    }*/

    //查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(String id) throws Exception{
        //根据用户id查询用户
        UserInfo userInfo = userService.findById(id);
        //根据用户id查询可以添加的角色
        List<Role> ohtherRoles = userService.findOtherRoles(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",userInfo);
        mv.addObject("roleList",ohtherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("addRoleToUser")
    //只有tom用户才能完成save操作
    @PreAuthorize("authentication.principal.username=='tom'")
    public String addRoleToUser(@RequestParam(value = "userId",required = true) String userId,
                                @RequestParam(value = "ids",required = true) String[] roleIds) throws Exception{
        userService.addRoleToUser(userId,roleIds);
        return "redirect:/user/findAll.do";
    }

    @RequestMapping("/findAll.do")
    //只有ROLE_ADMIN角色才能findAll操作
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<UserInfo> infos = userService.findAll();
        mv.addObject("userList",infos);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception{
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception{
        UserInfo userInfo = userService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }


}
