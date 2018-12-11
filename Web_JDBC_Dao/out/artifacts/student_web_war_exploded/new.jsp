<%--
  Created by IntelliJ IDEA.
  User: 94397
  Date: 2018/12/1
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="JS/checkAndQuery.js">
    </script>
    <style>
        #div1{
            background-color: whitesmoke;
            width: 50%;
            margin: 0 auto;
            text-align: center;
        }
    </style>
</head>
<body style="margin-top: 150px">
    <div id="div1">
        <form  action="newConfirm.jsp" method="post" onsubmit="return check()">
            <h2><label>请输入学生信息：</label></h2>
            <label>学  号： </label>
            <input type="text" name="uid" id="uid"/><br/>
            <label>姓  名：</label>
            <input type="text" name="name" id="name" /><br/>
            <label>密    码：</label>
            <input type="text" name="pwd" id="pwd" /><br/>
            <label>联系方式：</label>
            <input type="text" name="link" id="link"/><br/>
            <label>职    位：</label>
            <input type="text" name="roles" id="roles"/><br/>
            <br/>
            <input type="reset" value="重新输入"/>
            <input type="submit" value="提交"/>

        </form>
    </div>
</body>
</html>
