package com.spring.rumen;

public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("save执行了");
    }
}
