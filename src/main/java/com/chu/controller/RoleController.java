package com.chu.controller;


import com.chu.domain.KvPageFather;
import com.chu.domain.Role;
import com.chu.service.RoleService;
import com.chu.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.*;

@Controller
@RequestMapping("/findRole")
public class RoleController extends FindController<Role>{

    @Autowired
    private RoleServiceImpl roleService;

    @RequestMapping("/role")
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        super.setFindService(roleService);
        super.findAll(request, response, new String[]{"rarity", "weapontype", "elementtype", "gender", "area", "breakthrough"});
        response.sendRedirect(request.getContextPath()+"/tableRole.jsp");
    }

    /*@RequestMapping("/findAll")
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String requestURI = request.getRequestURI();

        KvPageFather<Role> kvPageFather = new KvPageFather<>();
        kvPageFather.setPer(5);
        kvPageFather.setURI(requestURI);

        String page = request.getParameter("page");
        if (page != null && !page.equals("")) {
            kvPageFather.setPage(Integer.parseInt(page));
        } else {
            kvPageFather.setPage(1);
        }

        kvPageFather = roleService.findByPage(kvPageFather);
        Map<String, List<String>> map = roleService.findType();
        kvPageFather.setTypeMap(map);


        HttpSession session = request.getSession();
        session.setAttribute("kv", kvPageFather);
        response.sendRedirect(request.getContextPath() + "/tableRole.jsp");
    }

    @RequestMapping("/findByCondition")
    public void findByCondition(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String requestURI = request.getRequestURI();

        Map<String, String[]> map = request.getParameterMap();

        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String s : map.keySet()) {
            if (!s.equals("page")) {
                List<String> list = new ArrayList<>();
                for (String s1 : map.get(s)) {
                    list.add(s1);
                }
                System.out.println(list);
                hashMap.put(s, list);
            }
        }

        HttpSession session = request.getSession();
        KvPageFather<Role> kvPageFather = (KvPageFather<Role>) session.getAttribute("kv");

        String page = request.getParameter("page");
        if (page != null && !page.equals("")) {
            kvPageFather.setPage(Integer.parseInt(page));
        } else {
            kvPageFather.setPage(1);
        }

        //Map<String, List<String>> selectMap = kvPageFather.getSelectMap();

        if (hashMap.size() != 0 && hashMap != null) {
            kvPageFather.setSelectMap(hashMap);
        }
        kvPageFather = roleService.findByCondition(kvPageFather);
        kvPageFather.setURI(requestURI);

        session.setAttribute("kv", kvPageFather);

        response.sendRedirect(request.getContextPath() + "/tableRole.jsp");
    }*/


//
//    @RequestMapping("/find")
//    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//
//        HttpSession session = request.getSession();
//        String requestURI = request.getRequestURI();
//
//        KvPageFather<Role> kvPageFather = new KvPageFather<>();
//        kvPageFather.setPer(5);
//        kvPageFather.setURI(requestURI);
//
//        String page = request.getParameter("page");
//        if (page != null && !page.equals("")) {
//            kvPageFather.setPage(Integer.parseInt(page));
//        } else {
//            kvPageFather.setPage(1);
//        }
//
//        Map<String, String[]> parameterMap = request.getParameterMap();
//
//        HashMap<String, List<String>> selectMap = new HashMap<>();
//        for (String s : parameterMap.keySet()) {
//            if (!s.equals("page")) {
//                List<String> list = new ArrayList<>();
//                for (String s1 : parameterMap.get(s)) {
//                    list.add(s1);
//                }
//                selectMap.put(s, list);
//            }
//        }
//
//        //Map<String, List<String>> oldSelectMap = ((KvPageFather<Role>) session.getAttribute("kv")).getSelectMap();
//        if (selectMap.size() != 0 && selectMap != null) {
//            kvPageFather.setSelectMap(selectMap);
//        }/*else if (oldSelectMap!=null && oldSelectMap.size()!=0){
//            kvPageFather.setSelectMap(oldSelectMap);
//        }*/
//
//        Map<String, List<String>> typeMap = roleService.findType();
//        kvPageFather.setTypeMap(typeMap);
//        kvPageFather = roleService.findByCondition(kvPageFather);
//
//
//        session.setAttribute("kv", kvPageFather);
//        response.sendRedirect(request.getContextPath() + "/tableRole.jsp");
//    }
}
