package com.mybatis.dao;

import com.mybatis.dao.Impl.UserDaoImpl;
import com.mybatis.pojo.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao=new UserDaoImpl();
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
        user.setUsername("小宝宝");
        user.setUser_password("12342");
        user.setUser_age(10);
        userDao.insertUser(user);
    }
}