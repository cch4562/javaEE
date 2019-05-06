package com.mybatis.dao;

import com.mybatis.pojo.User;

import java.util.List;

public interface UserDao {
    User getUserById(Integer id);
    List<User> getUserByName(String name);
    void insertUser(User user);
}
