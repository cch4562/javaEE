package com.mybatis.pojo;

public class Linkman {
    private Long link_id;
    private String link_name;
    private String link_phone;
    private String sex;
    //关联user
    private User user;

    public Long getLink_id() {
        return link_id;
    }

    public void setLink_id(Long link_id) {
        this.link_id = link_id;
    }

    public String getLink_name() {
        return link_name;
    }

    public void setLink_name(String link_name) {
        this.link_name = link_name;
    }

    public String getLink_phone() {
        return link_phone;
    }

    public void setLink_phone(String link_phone) {
        this.link_phone = link_phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Linkman{" +
                "link_id=" + link_id +
                ", link_name='" + link_name + '\'' +
                ", link_phone='" + link_phone + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
