package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/11/7 21:55
 * @Description TODO
 **/
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    //根据roleId查询role，并查询出可以添加的权限
    @RequestMapping("/findRoleByIdAndPermission.do")
    public ModelAndView findRoleByIdAndPermission(@RequestParam(value = "roleId",required = true) String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = iRoleService.findById(roleId);
        mv.addObject("role",role);
        List<Permission> permissionList = iRoleService.findOtherPermission(roleId);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole")
    public String addRoleToUser(@RequestParam("roleId") String roleId,
                                @RequestParam("ids") String[] permissionIds){
        iRoleService.addRoleToUser(roleId,permissionIds);
        return "redirect:/role/findAll.do";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = iRoleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception{
        iRoleService.save(role);
        return "redirect:/role/findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Role role = iRoleService.findById(id);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }

    @RequestMapping("/deleteRole.do")
    public String deleteRole(String id) throws  Exception{
        iRoleService.deleteRoleById(id);
        return "redirect:/role/findAll.do";
    }


}
