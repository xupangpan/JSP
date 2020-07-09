<%--
  Created by IntelliJ IDEA.
  User: 许
  Date: 2020/7/8
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<div align="center">
    <form method="post" action="<%=request.getContextPath()%>/register.htm">
        <card>
        用户名：<input type="text" name="username"><br>
        密码  ：<input type="password" name="password"><br>
        <button type="submit">注册</button>
        <button type="submit"> <a href="login.jsp">请登录</a></button>
        </card>
    </form>
</div>
</body>
</html>
