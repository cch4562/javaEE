<%--
  Created by IntelliJ IDEA.
  User: 94397
  Date: 2018/12/1
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jdbc.util.DBUtil" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.jdbc.dao.UserDao" %>
<%@ page import="com.jdbc.dao.UserDaoImpl" %>
<%@ page import="com.jdbc.userbean.User" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        UserDao userDao=new UserDaoImpl();
        User user=new User();
        user.setUid(request.getParameter("uid"));
        user.setName(request.getParameter("name"));
        user.setPwd(request.getParameter("pwd"));
        user.setLink(request.getParameter("link"));
        user.setRoles(request.getParameter("roles"));
        userDao.insert(user);
        out.print("新建学生成功 5s后跳转至学生信息列表");
        response.setHeader("Refresh", "5;url=list.jsp");


    %>
</body>
</html>
