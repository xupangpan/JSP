<%--
  Created by IntelliJ IDEA.
  User: 许
  Date: 2020/7/7
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎登录</title>
</head>
<body>
<div align="center">
    <from method="post"  action="<%=request.getContextPath()%>/login.htm">
        用户名:<input name="user" type="text"><br>
        密码:<input name="pass" type="password"><br>
        <button class="btn btn-info"> <a href="resgster.jsp">注册</a></button>
    </from>
</div>
</body>
</html>
