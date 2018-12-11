package com.jdbc.dao;

import com.jdbc.userbean.User;
import com.jdbc.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> queryAll() {
      List<User> all=new ArrayList<User>();
      String sql="select * from students";
        Connection conn = DBUtil.open();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                User user=new User();
                user.setUid(rs.getString("uid"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setLink(rs.getString("link"));
                user.setRoles(rs.getString("roles"));
                all.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.release(conn, ps, rs);
        }
        return  all;
    }

    @Override
    public void insert(User user) {
        Connection conn = DBUtil.open();
        String sql="insert into students values (null,?,?,?,?,?)";
        PreparedStatement ps=null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUid());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPwd());
            ps.setString(4, user.getLink());
            ps.setString(5, user.getRoles());
            int rs=ps.executeUpdate();
            if(rs>0){
                System.out.println("添加成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.release(conn, ps);
        }
    }

    @Override
    public List<User> find(User user) {
        Connection conn = DBUtil.open();
        List<User> li=new ArrayList<User>();
        String sql="select * from students where uid=? or name=? or pwd=?" +
                " or link=? or roles=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
             ps= conn.prepareStatement(sql);
             ps.setString(1, user.getUid());
             ps.setString(2, user.getName());
             ps.setString(3, user.getPwd());
             ps.setString(4, user.getLink());
             ps.setString(5, user.getRoles());
             rs= ps.executeQuery();
             while (rs.next()){
                 User user1=new User();
                 user1.setUid(rs.getString("uid"));
                 user1.setName(rs.getString("name"));
                 user1.setPwd(rs.getString("pwd"));
                 user1.setLink(rs.getString("link"));
                 user1.setRoles(rs.getString("roles"));
                 li.add(user1);
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.release(conn, ps, rs);
        }
        return li;
    }


}
