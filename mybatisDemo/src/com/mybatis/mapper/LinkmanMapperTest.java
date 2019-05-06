package com.mybatis.mapper;

import com.mybatis.pojo.Linkman;
import com.mybatis.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LinkmanMapperTest {
    @Test
    //一对一查询测试
    public void testLinkmanToUser(){
        SqlSession session = SqlSessionFactoryUtils.getSqlSessionFactory();
        LinkmanMapper mapper = session.getMapper(LinkmanMapper.class);
        List<Linkman> list = mapper.linkmanToUser();
        for(Linkman linkman:list){
            System.out.println(linkman);
            System.out.println("联系的用户"+linkman.getUser());
        }
        session.close();
    }
}