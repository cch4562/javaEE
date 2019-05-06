package com.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {
    //单例的SqlSessionfactory;
    private static SqlSessionFactory sqlSessionFactory;
    static {
        //创建build对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //查找配置文件
        try {
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            //加载配置文件
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取单例SqlSessionFactory
    public static SqlSession getSqlSessionFactory(){
        return sqlSessionFactory.openSession();
    }
}
