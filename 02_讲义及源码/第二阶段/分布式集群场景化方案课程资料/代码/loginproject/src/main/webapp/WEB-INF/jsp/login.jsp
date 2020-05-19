<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
    <title>系统登录</title>

    <style>
        div{
            width:300px;
            height:100px;
            position: absolute;
            top:50%;
            left:50%;
            margin-top: -50px ;
            margin-left:-150px;
        }
    </style>
</head>
<body>
<h2>我是服务器：${pageContext.request.localPort}</h2>
<h2>当前sessionId：${pageContext.session.id}</h2>
    <div>
        <form method="post" action="${pageContext.request.contextPath}/login/loginSystem">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="password"> <input type="submit" value="登录"></td>
                </tr>
            </table>

        </form>
    </div>
</body>
</html>
