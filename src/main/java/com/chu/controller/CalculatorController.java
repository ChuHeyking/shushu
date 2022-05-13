package com.chu.controller;

import com.chu.domain.Calculate;
import com.chu.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping("/easyCal")
    public @ResponseBody Calculate esay(@RequestBody Calculate calculate){
        System.out.println(calculate);
        Calculate calculate1 = calculatorService.easyCalculate(calculate);
        System.out.println(calculate);
        return calculate1;
    }


}
