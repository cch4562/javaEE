package com.spring.rumen;

public class UserServiceImpl implements UserService {
    //采用set方法注入
    private UserDao userDao;
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
       userDao.save();
        System.out.println("Service的save执行了。。"+user);
    }
}
