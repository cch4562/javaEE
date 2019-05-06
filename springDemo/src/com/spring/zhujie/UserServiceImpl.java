package com.spring.zhujie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Service是@Component的衍生注解，在service层用
@Service("userService")//相当于<bean id="userService" class="">
public class UserServiceImpl implements UserService {
    //@Autowired
    //注入Dao
    @Resource(name = "userDao")
    private UserDao userDao;
    @Override
    public void save() {
        userDao.save();
        System.out.println("service执行了。。");
    }
}
