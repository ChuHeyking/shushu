package com.chu.controller;

import com.chu.domain.Book;
import com.chu.domain.Kv;
import com.chu.domain.Role;
import com.chu.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
@RequestMapping("/tianFu")
public class TianFuController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/getAll")
    public @ResponseBody
    Kv getAll() throws IOException {

        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_WEEK);
        String dayString = "%" + day + "%";
        List<Book> books = bookService.findAll(dayString);


//        for (Book book : books) {
//            System.out.println(book);
//        }

        day = day - 1;
        String src = "";
        String weekDay = "";
        if (day == 1 || day == 4) {
            if (day == 1) {
                weekDay = "星期一";
            } else {
                weekDay = "星期四";
            }
            src = "14";
        } else if (day == 2 || day == 5) {
            if (day == 2) {
                weekDay = "星期二";
            } else {
                weekDay = "星期五";
            }
            src = "25";
        } else if (day == 3 || day == 6) {
            if (day == 3) {
                weekDay = "星期三";
            } else {
                weekDay = "星期六";
            }
            src = "36";
        } else {
            weekDay = "星期天";
            src = "00";
        }
        Kv kv = new Kv();
        kv.setSrc(src);
        kv.setDay(weekDay);
        kv.setBooks(books);
        return kv;
    }

/*    @RequestMapping("/getAll")
    public @ResponseBody
    ModelAndView getAll() throws IOException {

        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_WEEK);
        String dayString = "%" + day + "%";
        List<Book> books = bookService.findAll(dayString);
*//*        for (Book book : books) {
            System.out.println(book);
        }*//*
        day = day - 1;
        String src = "";
        if (day == 1 || day == 4) {
            src = "14";
        } else if (day == 2 || day == 5) {
            src = "25";
        } else if (day == 3 || day == 6) {
            src = "36";
        } else {
            src = "00";
        }
        Kv kv = new Kv();
        kv.setSrc(src);
        kv.setBooks(books);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("kv",kv);
        return mv;
    }*/


    /*        for (Book book : books) {
                List<String> roleNames = book.getRoleNames();
                List<String> list = new ArrayList<>();
                for (String roleName : roleNames) {
                    list.add("\""+roleName+"\"");
                }
                book.setRoleNames(list);
            }*/
    @RequestMapping("/getA")
    public String getA() {


        return "main";
    }
/*    @RequestMapping("/getAll")
    public @ResponseBody String getAll(@RequestBody Kv kv){
        Calendar cal = Calendar.getInstance();
        int i = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(i);
        System.out.println(kv);
        //Kv kv = new Kv();
        kv.setSrc("img/tainfu/tianfu1.jpg");
        return "{\"src\":\"img/tainfu/tianfu1.jpg\"}";       //一定要用双引号""，而字符串外面也有双引号，所以得用\"反斜杠双引号。
    }*/

/*    @RequestMapping("/getAll")
    public void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Calendar cal = Calendar.getInstance();
        int i = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(i);
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("{\"src\":\"img/tainfu/tianfu1.jpg\"}");
    }*/
}
