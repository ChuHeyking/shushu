package com.chu.controller;


import com.chu.domain.KvPageFather;
import com.chu.domain.Role;
import com.chu.domain.Weapon;
import com.chu.service.WeaponService;
import com.chu.service.impl.WeaponServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/findWeapon")
public class WeaponController extends FindController<Weapon>{

    @Autowired
    private WeaponServiceImpl weaponService;

    @RequestMapping("/weapon")
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        super.setFindService(weaponService);
        super.findAll(request, response, new String[]{"type","weaponRarity","access"});
        response.sendRedirect(request.getContextPath()+"/tableWeapon.jsp");
    }

    //    @Autowired
//    private WeaponService weaponService;
//
//    @RequestMapping("/weapon")
//    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//
//        HttpSession session = request.getSession();
//        String requestURI = request.getRequestURI();
//
//        KvPageFather<Weapon> kvPageFather = new KvPageFather<>();
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
//        Map<String, List<String>> typeMap = weaponService.findType();
//        kvPageFather.setTypeMap(typeMap);
//        kvPageFather = weaponService.findByCondition(kvPageFather);
//
//
//        session.setAttribute("kv", kvPageFather);
//        response.sendRedirect(request.getContextPath() + "/tableWeapon.jsp");
//    }

}
