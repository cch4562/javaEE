package com.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtilTest {
    public static void main(String[] args) {
        Connection conn = DBUtil.open();
        String sql="select * from consumer";
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
              ps= conn.prepareStatement(sql);
              rs= ps.executeQuery();
            while (rs.next()){
                String username=rs.getString("username");
                String password=rs.getString("password");
                System.out.println(username+"  "+password);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.release(conn, ps, rs);
        }
    }

}
