package com.spring.zhujie;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest2 {
    //注解 管理类
    @Test
    public void demo01(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ApplicationContext1.xml");
        UserDao userDao=(UserDao) applicationContext.getBean("userDao");
        userDao.save();
    }
    @Test
    public void demo02(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ApplicationContext1.xml");
        UserService userService=(UserService) applicationContext.getBean("userService");
        userService.save();
    }
}
