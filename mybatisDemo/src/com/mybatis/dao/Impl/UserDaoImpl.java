package com.mybatis.dao.Impl;

import com.mybatis.dao.UserDao;
import com.mybatis.pojo.User;
import com.mybatis.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUserById(Integer id) {
        SqlSession session = SqlSessionFactoryUtils.getSqlSessionFactory();
        User user = session.selectOne("user.getUserById", id);
        session.close();
        return user;
    }

    @Override
    public List<User> getUserByName(String name) {
        SqlSession session = SqlSessionFactoryUtils.getSqlSessionFactory();
        List<User> list = session.selectList("user.getUserByName", name);
        session.close();
        return list;
    }

    @Override
    public void insertUser(User user) {
        SqlSession session = SqlSessionFactoryUtils.getSqlSessionFactory();
        session.insert("user.insertUser", user);
        session.commit();
        System.out.println("添加成功");
        session.close();
    }
}
