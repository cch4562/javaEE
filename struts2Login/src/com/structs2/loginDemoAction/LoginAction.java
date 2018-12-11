package com.structs2.loginDemoAction;
import com.jdbc.util.DBUtil;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAction extends ActionSupport {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String execute(){
        Connection conn = DBUtil.open();
        String sql="select * from consumer";
        PreparedStatement ps=null;
        ResultSet rs=null;
        int flag=0;
        try {
            ps= conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()){
                if(rs.getString("username").equals(this.username)&&
                rs.getString("password").equals(this.password)){
                   flag=1;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.release(conn, ps, rs);
        }
        if(flag==1)
            return "success";
        else
            return "fail";
    }


}
