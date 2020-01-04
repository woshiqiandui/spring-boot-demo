package com.example.demo.services;

import com.example.demo.beans.BookDemo;
import com.example.demo.mappers.BookDemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IndexService {
    @Autowired
    BookDemoMapper bookDemoMapper;

    public String index() {
        String id = "10";
        BookDemo bookDemo = bookDemoMapper.selectById(id);
       return  bookDemo.toString();
    }
}
