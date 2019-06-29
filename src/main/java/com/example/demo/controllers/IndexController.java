package com.example.demo.controllers;


import com.example.demo.services.IndexService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /* 约等于@Controller + @ResponseBody 但是也有缺陷：不能返回jsp或者html*/


public class IndexController {

    @Autowired
    IndexService indexService;
    @RequestMapping("/index")
    String index(){
        return indexService.index();
    }

}
