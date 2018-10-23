<%--
  Created by IntelliJ IDEA.
  User: pinnuli
  Date: 18-4-23
  Time: 上午8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort() + path + "/";
%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>注册</title>
</head>

<body>
<h2>注册页面</h2>
<hr/>
<form method="POST" action="${pageContext.request.contextPath }/register">
    <table>
        <tr>
            <td><label for="username">用户名:</label></td>
            <td><input type="text" name="username" id="username"/></td>
        </tr>
        <tr>
            <td><label for="password">密码:</label></td>
            <td><input type="password" name="password" id="password"/></td>
        </tr>
        <tr>
            <td><label for="email">邮箱:</label></td>
            <td><input type="email" name="email" id="email"/></td>
        </tr>
        <tr>
            <td><label for="validateCode">验证码:</label></td>
            <td>
                <img id="validateCode" class="validateCode" src="validateCode" onclick="change()" title="点击更换验证码"/>
            </td>
            <td><input type="text" name="validateCode"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="注册"/></td>
        </tr>
    </table>
</form>
</body>
<script type="text/javascript">
    /* 验证码*/
    function change() {
        var img = document.getElementById("validateCode");
        //防止缓存加上new Date
        img.src = "validateCode?" + new Date().getTime();
    }
</script>
</html>
