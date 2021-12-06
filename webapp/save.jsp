<%--
  Created by IntelliJ IDEA.
  User: quercus
  Date: 2021/12/6
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>添加花卉信息</title>
        <base href="<%=request.getContextPath()+"/"%>">
    </head>
    <body>
        <h3 align="center">添加花卉信息</h3>
        <hr>
        <center>
            <form action="SaveFlower" method="post">
                <p>
                    花卉名称：<input type="text" name="name">
                </p>
                <p>
                    花卉价格：<input type="text" name="price">
                </p>
                <p>
                    花卉产地：<input type="text" name="production">
                </p>
                <p>
                    <input type="submit" value="提交">
                    ${requestScope.msg}
                </p>
            </form>
        </center>

    </body>
</html>
