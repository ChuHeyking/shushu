package com.chu.controller;


import com.chu.domain.KvPageFather;
import com.chu.domain.Role;
import com.chu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/*
@Controller
@RequestMapping("/role")
public class OLDRoleController {

    @Autowired
    private RoleService roleService;


    @RequestMapping("/findAll")
    public @ResponseBody
    KvPageFather<Role> findAll(@RequestBody KvPageFather<Role> kvPageFather){
        kvPageFather.setPer(5);
        System.out.println(kvPageFather);
        kvPageFather = roleService.findByPage(kvPageFather);
        return kvPageFather;
    }

}
*/
