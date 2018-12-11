package com.jdbc.test;

import com.jdbc.bean.UserBean;
import com.jdbc.util.DBUtil;

import java.sql.*;

public class TestJDBC_CRUD {
    public static void main(String []args){
        TestJDBC_CRUD ts=new TestJDBC_CRUD();
        ts.query();
       // ts.insert();
       // ts.delete();
       // ts.update();
        //ts.addUser(new UserBean("zhao", 17, "2001-8-12", 85));
        //int uid1=1;int uid2=2;int Money=30;
        //ts.changeMoney(uid1, uid2, Money);
    }
    public void query(){
        Connection conn = DBUtil.open();
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from users";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int age=rs.getInt("age");
                String birthday=rs.getString("birthday");
                int money =rs.getInt("money");
                System.out.println("id:"+id+"  "+"name:"+name+"  "+"age: "+age+"  "+
                        "birthday:"+birthday+"  "+"money:"+money);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.release(conn,ps,rs);
        }

    }
    public void insert(){
        Connection conn = DBUtil.open();
        String sql="insert into users values (null,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,"li");
            ps.setInt(2,16);
            ps.setString(3,"2002-9-16");
            ps.setInt(4,160);
            int rs = ps.executeUpdate();
            if(rs==1){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.release(conn,ps);
        }

    }
    public void delete(){
        Connection conn = DBUtil.open();
        String sql="delete from users where name='li'";
        PreparedStatement ps=null;
        try {
            ps = conn.prepareStatement(sql);
            int rs = ps.executeUpdate();
            if(rs==1){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.release(conn,ps);
        }

    }
    public void update(){
        Connection conn = DBUtil.open();
        String sql="update users set money=? where id=1";
        PreparedStatement ps=null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,120);
            int rs = ps.executeUpdate();
            if(rs==1){
                System.out.println("更新成功");
            }else{
                System.out.println("更新失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.release(conn, ps);
        }
    }
    public void addUser(UserBean usr){
        Connection conn = DBUtil.open();
        String sql="insert users values (null,?,?,?,?)";
        PreparedStatement ps=null;
        try {
             ps= conn.prepareStatement(sql);
             ps.setString(1, usr.getName());
             ps.setInt(2, usr.getAge());
             ps.setString(3, usr.getBirthday());
             ps.setInt(4, usr.getMoney());
            int rs = ps.executeUpdate();
            if(rs==1){
                System.out.println("添加新用户成功");
            }else{
                System.out.println("添加新用户失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtil.release(conn, ps);
        }

    }
    public void  changeMoney(int uid1,int uid2,int Money){
        Connection conn = DBUtil.open();
        String sql1="update users set money=money-"+Money+" where id="+uid1;
        String sql2="update users set money=money+"+Money+" where id="+uid2;
        Statement stmt=null;
        try {
            conn.setAutoCommit(false);
            stmt= conn.createStatement();
            int rs1 = stmt.executeUpdate(sql1);
            int rs2 = stmt.executeUpdate(sql2);
            conn.commit();
            if(rs1>0&&rs2>0) {
                System.out.println("转账成功");
            }else {
                System.out.println("转账失败");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }finally {
            DBUtil.release(conn,stmt);

        }

    }
}
