package com.jdbc.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
    //private static String driver;

    /*声明数据库连接的参数*/
    private static String url;
    private static String username;
    private static String password;



    static {


        /*使用类加载器获取src底下的资源文件*/
        InputStream is= DBUtil.class.getClassLoader().getResourceAsStream("config.properties");
        Properties prop =new Properties();
        try {

            prop.load(is);

            /*写入3个参数值*/
            url = prop.getProperty("url");
            username= prop.getProperty("username");
            password= prop.getProperty("password");



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*打开连接数据库*/
    public static Connection open() {

        try {
            //Class.forName(driver); //不需要显示加载驱动了
            return  DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /*释放数据库资源*/
    public static void release(Connection conn, Statement stmt, ResultSet rs) {
        closeRs(rs);
        closeStmt(stmt);
        closeCon(conn);
    }
    public static void release(Connection conn, Statement stmt) {
        closeStmt(stmt);
        closeCon(conn);
    }

    private static void closeRs(ResultSet rs) {
        try {
            if(rs!=null) {
                rs.close();
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            rs=null;
        }
    }

    private static void closeStmt(Statement stmt) {
        try {
            if(stmt!=null) {
                stmt.close();
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            stmt=null;
        }
    }
    private static void closeCon(Connection conn) {
        try {
            if(conn!=null) {
                conn.close();
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            conn=null;
        }
    }


}
