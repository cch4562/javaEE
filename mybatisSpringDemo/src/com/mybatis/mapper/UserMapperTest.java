package com.mybatis.mapper;

import com.mybatis.pojo.Linkman;
import com.mybatis.pojo.QueryVo;
import com.mybatis.pojo.User;
import com.mybatis.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {
    private ApplicationContext applicationContext;
    private UserMapper mapper;
    @Before
    public void init(){
        this.applicationContext= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        mapper = this.applicationContext.getBean(UserMapper.class);
    }

    @Test
    public void testGetUserById(){
        //获取代理对象
        User user = mapper.getUserById(7);
        System.out.println(user);
    }
    @Test
    public void testGetUserByName(){
        List<User> list = mapper.getUserByName("宝");
        for(User user:list){
            System.out.println(user);
        }
    }
    @Test
    public void testInsertUser(){
        User user=new User();
        user.setUsername("哈哈宝贝");
        user.setUser_password("73221");
        user.setUser_age(13);
        mapper.insertUser(user);
        System.out.println("添加成功");
    }
    @Test
    //传递包装的pojo
    public void testQueryUserByQueryVo(){
        User user=new User();
        //设置查询条件
        user.setUsername("宝");
        QueryVo queryVo=new QueryVo();
        //设置到包装对象中
        queryVo.setUser(user);
        List<User> list = mapper.queryUserByQueryVo(queryVo);
        for(User user1:list){
            System.out.println(user1);
        }
    }
    @Test
    //统计条数
    public void testUserCount(){
        int count = mapper.userCount();
        System.out.println(count);
    }
    @Test
    //resultMap统计所有
    public void testQueryAll(){
        List<User> list = mapper.queryAll();
        for(User user:list){
            System.out.println(user);
        }
    }
    @Test
    //根据条件查询if
    public void testQueryUserByIf(){
        User user=new User();
        user.setUsername("宝");
        user.setUser_age(18);
        List<User> list = mapper.queryUserByIf(user);
        for(User user1:list){
            System.out.println(user1);
        }
    }
    @Test
    //根据条件查询where标签
    public void testQueryUserByWhere(){
        User user=new User();
        user.setUsername("宝");
        user.setUser_password("321");
        List<User> list = mapper.queryUserByWhere(user);
        for(User user1:list){
            System.out.println(user1);
        }
    }
    @Test
    //一对多查询
    public void testUserToLinkman(){
        List<User> list = mapper.userToLinkman();
        for(User user:list){
            System.out.print(user);
            if(user.getLinkman().size()!=0){
                System.out.println();
                for(Linkman linkman:user.getLinkman()){
                    System.out.println("联系人"+linkman);
                }
                continue;
            }
            System.out.println("     没有联系人");
        }
    }
}