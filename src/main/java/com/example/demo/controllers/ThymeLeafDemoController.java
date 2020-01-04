package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ThymeLeafDemoController {

    @RequestMapping("/testThymeleaf")
    public String demo(Map<String,Object> paramMap){
        paramMap.put("name","陈迁对");
        paramMap.put("age",24);
        return "testThymeleaf";
    }
}
