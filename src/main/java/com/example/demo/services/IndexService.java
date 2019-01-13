package com.example.demo.services;

import com.example.demo.beans.Book;
import com.example.demo.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IndexService {
    @Autowired
    BookMapper bookMapper;

    public String index() {
        String id = "10";
        Book book = bookMapper.selectById(id);
       return  book.toString();
    }
}
