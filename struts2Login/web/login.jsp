<%--
  Created by IntelliJ IDEA.
  User: 94397
  Date: 2018/12/11
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/loginConsumer.action" method="post">
        <div>用户名:<input type="text" name="username"></div>
        <div>密&nbsp&nbsp码:<input type="password" name="password"></div>
        <div> <input type="submit" value="提交"/></div>
    </form>
</div>
</body>
</html>
