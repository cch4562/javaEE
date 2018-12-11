package com.jdbc.bean;

public class UserBean {
    private String name;
    private int age;
    private String birthday;
    private int money;
    public UserBean(String name,int age,String birthday,int money){
        this.name=name;
        this.age=age;
        this.birthday=birthday;
        this.money=money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
