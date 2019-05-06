package com.mybatis.dao.Impl;

import com.mybatis.dao.UserDao;
import com.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
    @Override
    public User getUserById(Integer id) {
        SqlSession session = this.getSqlSession();
        User user = session.selectOne("user.getUserById", id);
        return user;
    }

    @Override
    public List<User> getUserByName(String name) {
        SqlSession session = this.getSqlSession();
        List<User> list = session.selectList("user.getUserByName", name);
        return list;
    }

    @Override
    public void insertUser(User user) {
        SqlSession session = this.getSqlSession();
        session.insert("user.insertUser", user);
//        session.commit(); 不用提交事务由spring管理
        System.out.println("添加成功");
    }

    @Override
    public void deleteUser(Integer id) {
        SqlSession session = this.getSqlSession();
        session.delete("user.deleteUser", id);
        System.out.println("删除成功");
    }
}
