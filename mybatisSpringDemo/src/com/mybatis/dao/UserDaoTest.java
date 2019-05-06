package com.mybatis.dao;

import com.mybatis.dao.Impl.UserDaoImpl;
import com.mybatis.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {
    private ApplicationContext applicationContext;
    private UserDao userDao;
    @Before
    public void init(){
        this.applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        this.userDao = applicationContext.getBean(UserDao.class);
    }
    @Test
    public void testGetUserById(){
        User user = userDao.getUserById(3);
        System.out.println(user);
    }
    @Test
    public void testGetUserByName(){
        List<User> list = userDao.getUserByName("宝");
        for (User user:list){
            System.out.println(user);
        }
    }
    @Test
    public void testInsertUser(){
        User user=new User();
        user.setUsername("大宝宝");
        user.setUser_password("12342");
        user.setUser_age(11);
        userDao.insertUser(user);
    }
    @Test
    public void testDeleteUser(){
        userDao.deleteUser(10);
    }
}