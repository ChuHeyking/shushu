package com.chu.controller;

import com.chu.domain.KvPageFather;
import com.chu.domain.Relics;
import com.chu.domain.Weapon;
import com.chu.service.FindService;
import com.chu.service.impl.FindServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FindController<T> {

    private FindService<T> findService;

    public FindService<T> getFindService() {
        return findService;
    }

    public void setFindService(FindService<T> findService) {
        this.findService = findService;
    }

    public void findAll(HttpServletRequest request, HttpServletResponse response,String[] fields) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        String requestURI = request.getRequestURI();

        KvPageFather<T> kvPageFather = new KvPageFather<>();
        kvPageFather.setPer(5);
        kvPageFather.setURI(requestURI);
        kvPageFather.setFields(fields);

        String page = request.getParameter("page");
        if (page != null && !page.equals("")) {
            kvPageFather.setPage(Integer.parseInt(page));
        } else {
            kvPageFather.setPage(1);
        }

        Map<String, String[]> parameterMap = request.getParameterMap();

        HashMap<String, List<String>> selectMap = new HashMap<>();
        for (String s : parameterMap.keySet()) {
            if (!s.equals("page")) {
                List<String> list = new ArrayList<>();
                for (String s1 : parameterMap.get(s)) {
                    list.add(s1);
                }
                selectMap.put(s, list);
            }
        }

        //Map<String, List<String>> oldSelectMap = ((KvPageFather<Role>) session.getAttribute("kv")).getSelectMap();
        if (selectMap.size() != 0 && selectMap != null) {
            kvPageFather.setSelectMap(selectMap);
        }/*else if (oldSelectMap!=null && oldSelectMap.size()!=0){
            kvPageFather.setSelectMap(oldSelectMap);
        }*/

        kvPageFather = findService.findByCondition(kvPageFather);
        Map<String, List<String>> typeMap = findService.findType(kvPageFather);
        kvPageFather.setTypeMap(typeMap);

        //System.out.println(kvPageFather);

        session.setAttribute("kv", kvPageFather);
    }

}
