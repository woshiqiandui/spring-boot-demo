package com.example.demo.mappers;

import com.example.demo.beans.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    Book selectByName(String name);

    Book selectByAge(Integer age);
}
