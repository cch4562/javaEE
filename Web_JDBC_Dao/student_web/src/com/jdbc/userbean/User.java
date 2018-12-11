package com.jdbc.userbean;

public class User {
    private  String uid;
    private  String name;
    private  String pwd;
    private  String link;
    private  String roles;

    //获得学生学号
    public String getUid() {
        return uid;
    }
    //设置学生学号
    public void setUid(String uid) {
        this.uid = uid;
    }
    //获得学生姓名
    public String getName() {
        return name;
    }
    //设置学生姓名
    public void setName(String name) {
        this.name = name;
    }
    //获得密码
    public String getPwd() {
        return pwd;
    }
    //设置密码
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    //获得联系方式
    public String getLink() {
        return link;
    }
    //设置联系方式
    public void setLink(String link) {
        this.link = link;
    }
    //获得职位
    public String getRoles() {
        return roles;
    }
    //设置职位
    public void setRoles(String roles) {
        this.roles = roles;
    }
}
