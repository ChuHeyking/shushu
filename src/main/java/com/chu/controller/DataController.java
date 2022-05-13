package com.chu.controller;

import com.chu.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @RequestMapping("/weaponRarityDeletePoint")
    public void weaponRarityDeletePoint(){
        dataService.update1();
        System.out.println("0000000000000");
    }
}
