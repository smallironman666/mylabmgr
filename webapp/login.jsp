<%--
  Created by IntelliJ IDEA.
  User: quercus
  Date: 2021/12/5
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="viewport" content="width=device-width,initial-scale=3.0">
        <title>登录页面</title>
        <base href="<%=request.getContextPath()+"/"%>">
    </head>
    <body>
        <h1 align="center">登录页面</h1>
        <center>
            <form action="UserLoginServlet" method="post">
                <p>
                    <input type="text" name="uname">
                    <%--这里用到了EL表达式，简化了msg的非空判断--%>
                </p>
                <p>
                    <input type="password" name="pwd">
                </p>
                <p>
                    <input type="submit" value="提交">${requestScope.msg}
                </p>
            </form>
        </center>

    </body>
</html>
