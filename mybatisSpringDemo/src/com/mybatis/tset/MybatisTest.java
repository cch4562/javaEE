package com.mybatis.tset;

import com.mybatis.pojo.User;
import com.mybatis.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTest {
    @Test
    //根据id查找
    public void demo01(){
        SqlSession session = SqlSessionFactoryUtils.getSqlSessionFactory();
        User user = session.selectOne("user.getUserById", 2);
        System.out.println(user);
        session.close();
    }
    @Test
    //根据用户名查找
    public void demo02(){
        SqlSession session = SqlSessionFactoryUtils.getSqlSessionFactory();
        List<User> list = session.selectList("user.getUserByName", "宝");
        for(User user:list){
            System.out.println(user);
        }
        session.close();
    }
    @Test
    //添加用户
    public void demo03(){
        SqlSession session = SqlSessionFactoryUtils.getSqlSessionFactory();
        User user=new User();
        user.setUsername("宝婷婷");
        user.setUser_password("1234");
        user.setUser_age(16);
        session.insert("user.insertUser", user);
        //提交事务
        session.commit();
        System.out.println("添加成功");
        session.close();
    }
    @Test
    //修改用户
    public void demo04(){
        SqlSession session = SqlSessionFactoryUtils.getSqlSessionFactory();
        User user=new User();
        user.setUser_id(6l);
        user.setUsername("宝宝");
        session.update("user.updateUser",user);
        session.commit();
        System.out.println("修改成功");
        session.close();
    }
    @Test
    //删除用户
    public void demo05(){
        SqlSession session = SqlSessionFactoryUtils.getSqlSessionFactory();
        session.delete("user.deleteUser",6);
        session.commit();
        System.out.println("删除成功");
        session.close();
    }
}
