package com.example.demo;

import com.example.demo.beans.Book;
import com.example.demo.mappers.BookMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages="com.example.demo.*")
public class SpringBootDemoApplicationTests {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void contextLoads() {
        String id = "10";
        Book book = bookMapper.selectById(id);
       System.out.println(book);


    }

}

