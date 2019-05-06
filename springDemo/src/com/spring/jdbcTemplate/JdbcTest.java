package com.spring.jdbcTemplate;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;

public class JdbcTest {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Test
    public void demo01(){
        //创建jbdc连接池
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springdemo");
        dataSource.setUsername("root");
        dataSource.setPassword("chji1976");
        //创建jdbc模板
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update("insert into user values (null ,?,?)", "涵涵","123");

    }
}
