package com.mybatis.pojo;

import java.util.List;

public class User {
    private Long user_id;
    private String username;
    private String user_password;
    private Integer user_age;
    private List<Linkman> linkman;

    public List<Linkman> getLinkman() {
        return linkman;
    }

    public void setLinkman(List<Linkman> linkman) {
        this.linkman = linkman;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Integer getUser_age() {
        return user_age;
    }

    public void setUser_age(Integer user_age) {
        this.user_age = user_age;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_age=" + user_age +
                '}';
    }
}
