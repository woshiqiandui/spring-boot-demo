package com.example.demo.mappers;

import com.example.demo.beans.BookDemo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDemoMapper {
    BookDemo selectByName(String name);

    BookDemo selectById(String id);
}
