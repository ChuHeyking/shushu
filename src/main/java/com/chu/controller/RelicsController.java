package com.chu.controller;

import com.chu.domain.Relics;
import com.chu.service.impl.RelicsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/findRelics")
public class RelicsController extends FindController<Relics> {

    @Autowired
    private RelicsServiceImpl relicsService;


    @RequestMapping("/relics")
    public void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
        super.setFindService(relicsService);
        super.findAll(request, response,new String[]{"lowestRarity", "highestRarity"});
        response.sendRedirect(request.getContextPath() + "/tableRelics.jsp");
    }
}
