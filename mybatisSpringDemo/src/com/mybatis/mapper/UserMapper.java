package com.mybatis.mapper;

import com.mybatis.pojo.QueryVo;
import com.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    User getUserById(Integer id);
    List<User> getUserByName(String name);
    void insertUser(User user);
    List<User> queryUserByQueryVo(QueryVo vo);
    int userCount();
    List<User> queryAll();
    List<User> queryUserByIf(User user);
    List<User> queryUserByWhere(User user);
    List<User> userToLinkman();
}
