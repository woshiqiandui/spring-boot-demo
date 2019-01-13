package com.example.demo.controllers;

import com.example.demo.beans.Book;
import com.example.demo.mappers.BookMapper;
import com.example.demo.services.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /* 约等于@Controller + @ResponseBody 但是也有缺陷：不能返回jsp或者html*/
@SpringBootApplication
// 需要扫描整个demo 包
@ComponentScan(basePackages = {"com.example.demo"})
public class DemoApplication {

    @Autowired
    IndexService indexService;
    @RequestMapping
    String index(){
        return indexService.index();
    }
    public static void main(String[] args){
        SpringApplication.run(DemoApplication.class,args);
    }
}
