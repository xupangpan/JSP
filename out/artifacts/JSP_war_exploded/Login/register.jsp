<%--
  Created by IntelliJ IDEA.
  User: 许
  Date: 2020/7/8
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <title>注册</title>
</head>
<body>
<div align="center">
    <form method="post" action="<%=request.getContextPath()%>/register.htm">
        用户名：<input type="text" name="username"><br>
        密码  ：<input type="password" name="password"><br>
        <button class="btn btn-info">注册</button>
        <button class="btn btn-info"> <a href="login.jsp">请登录</a></button>
    </form></div>
</body>
</html>
