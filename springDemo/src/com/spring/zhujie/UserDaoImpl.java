package com.spring.zhujie;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
//@Repository是@Component的衍生注解，在dao层使用
@Repository("userDao")//相当于<bean id="userDao" class=""/>
public class UserDaoImpl implements UserDao {
    @Value("宝贝")//没有提供set方法注解就放到属性上
    private String name;

//    @Value("涵涵")//有提供set方法注解就放到set方法上
//    public void setName(String name) {
//        this.name = name;
//    }

    @Override
    public void save() {
        System.out.println("save执行了。。"+name);
    }
}
