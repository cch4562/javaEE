package com.spring.rumen;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest1 {
    @Test
    public void demo01(){
        //类在Spring中管理
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserService userService=(UserService)applicationContext.getBean("UserService");
        userService.save();
    }
    @Test
    public void demo02(){
        //构造方法注入属性
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        User user = (User) applicationContext.getBean("User1");
        System.out.println(user);
    }
    @Test
    public void demo03(){
        //SpEL注入属性
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        User user = (User) applicationContext.getBean("User2");
        System.out.println(user);
    }
}
