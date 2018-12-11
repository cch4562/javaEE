package com.jdbc.dao;

import com.jdbc.userbean.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao {
    //查询全部
    public List queryAll ();
    public void insert(User user);
    public List find(User user);

}
