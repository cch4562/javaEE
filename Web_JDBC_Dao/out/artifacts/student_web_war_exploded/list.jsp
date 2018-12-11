<%@ page import="com.jdbc.dao.UserDao" %>
<%@ page import="com.jdbc.dao.UserDaoImpl" %>
<%@ page import="com.jdbc.userbean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: 94397
  Date: 2018/12/1
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="JS/checkAndQuery.js"></script>
    <style>
        .na{
            text-align:center;
        }
        #new{
            position: absolute;
            font-size: 25px;
            color:deepskyblue;
            text-decoration: none;
            padding-left: 460px;
            bottom: 30px;
        }

        #div2{
            background-color: whitesmoke;
            width:90%;
            height: 40px;
            margin: 0 auto;
            text-align: center;
        }
        input{
            width: 90px;
            height: 30px;
        }
        .tian{
            background-color: white;
            height: 30px;
        }
        #tb1{
            border: 1px solid black;
            text-align: center;
            background-color: #add8e6;
            width: 90%;
            margin: 0 auto;
        }
        #tb2{
            border: 1px solid black;
            text-align: center;
            background-color: #add8e6;
            width: 90%;
            margin: 0 auto;

        }



    </style>



</head>
<body>

    <h2 align="center" >学生信息表</h2>
    <div id="div2">
        <form action="" method="post"  if="fm1">
            <label>学  号： </label>
            <input type="text" name="uid" id="uid"/>
            <label>姓  名：</label>
            <input type="text" name="name" id="name" />
            <label>密    码：</label>
            <input type="text" name="pwd" id="pwd" />
            <label>联系方式：</label>
            <input type="text" name="link" id="link"/>
            <label>职    位：</label>
            <input type="text" name="roles" id="roles"/>
            <input type="submit" value="查询"  />

         </form>

    </div>
    <div class="tian">

    </div>
    <table  id="tb1">
        <thead>
            <tr>
                <td class="na">学号</td>
                <td class="na">姓名</td>
                <td class="na">密码</td>
                <td class="na">联系方式</td>
                <td class="na">职位</td>
            </tr>
        </thead>
        <tbody>
        <%
            UserDao userDao=new UserDaoImpl();
            List<User> all=userDao.queryAll();
            Iterator<User> it=all.iterator();
            while (it.hasNext()){
                User user=it.next();
                out.print(" <tr>" +
                        "       <td class=\"na\">"+user.getUid()+"</td>\n" +
                        "       <td class=\"na\">"+user.getName()+"</td>\n" +
                        "       <td class=\"na\">"+user.getPwd()+"</td>\n" +
                        "       <td class=\"na\">"+user.getLink()+"</td>\n" +
                        "       <td class=\"na\">"+user.getRoles()+"</td>\n" +
                        " </tr>");
            }

        %>
        </tbody>

    </table>

    <a href="new.jsp" id="new">增加学生</a>

    <div class="tian">

    </div>
    <div class="tian">

    </div>
    <h3 >查询结果</h3>
    <table class="tb" id="tb2">
        <thead>
            <tr>
                <td class="na">学号</td>
                <td class="na">姓名</td>
                <td class="na">密码</td>
                <td class="na">联系方式</td>
                <td class="na">职位</td>
            </tr>
        </thead>
        <tbody>
    <%
        request.setCharacterEncoding("UTF-8");
        User user=new User();
        user.setUid(request.getParameter("uid"));
        user.setName(request.getParameter("name"));
        user.setPwd(request.getParameter("pwd"));
        user.setLink(request.getParameter("link"));
        user.setRoles(request.getParameter("roles"));
        List<User> li=userDao.find(user);
        Iterator<User> it1 = li.iterator();
        while (it1.hasNext()){
            User user1=it1.next();
            out.print(" <tr>" +
                    "       <td class=\"na\">"+user1.getUid()+"</td>\n" +
                    "       <td class=\"na\">"+user1.getName()+"</td>\n" +
                    "       <td class=\"na\">"+user1.getPwd()+"</td>\n" +
                    "       <td class=\"na\">"+user1.getLink()+"</td>\n" +
                    "       <td class=\"na\">"+user1.getRoles()+"</td>\n" +
                    " </tr>");
        }

    %>
        </tbody>

    </table>


</body>
</html>
