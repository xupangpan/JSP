<%--
  Created by IntelliJ IDEA.
  User: 许
  Date: 2020/7/7
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>欢迎登录</title>
</head>
<body>
<div align="center">
    <form method="post" action="<%=request.getContextPath()%>/login.htm">
        <card>
            用户名：<input type="text" name="username"><br>
            密码 ： <input type="password" name="password"><br>
            <button type="submit">登录</button>
            <button type="submit"> <a href="register.jsp">注册</a></button>
        </card>
    </form>
</div>
</body>
</html>
