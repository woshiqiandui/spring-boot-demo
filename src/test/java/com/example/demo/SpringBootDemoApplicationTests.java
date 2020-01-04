package com.example.demo;

import com.example.demo.mappers.BookDemoMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.demo.beans.BookDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages="com.example.demo.*")
public class SpringBootDemoApplicationTests {

    @Autowired
    private BookDemoMapper bookDemoMapper;

    @Test
    public void contextLoads() {
        String id = "10";
        BookDemo bookDemo = bookDemoMapper.selectById(id);
       System.out.println(bookDemo);

    }
    @Test
    public void test1() {

        // JDBC模板依赖于连接池来获得数据的连接，所以必须先要构造连接池
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://47.98.135.123:5555/test?useUnicode=true&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("wsqd19950428");

        // 创建JDBC模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 这里也可以使用构造方法
        jdbcTemplate.setDataSource(dataSource);

        // sql语句
        String sql = "select * from book";
        //Long num = (long) jdbcTemplate.queryForObject(sql, Long.class);





    }
}

