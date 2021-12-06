<%--
  Created by IntelliJ IDEA.
  User: quercus
  Date: 2021/12/6
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>修改花卉信息</title>
        <base href="<%=request.getContextPath()+"/"%>">
    </head>
    <body>
        <h3 align="center">修改花卉信息</h3>
        <hr>

        <center>
            <form action="ChangeFlower" method="post">
                <p>
                    花卉编号：<input type="text" name="id" value="${requestScope.flower.id}">
                </p>
                <p>
                    花卉名称：<input type="text" name="name" value="${requestScope.flower.name}">
                </p>
                <p>
                    花卉价格：<input type="text" name="price" value="${requestScope.flower.price}">
                </p>
                <p>
                    花卉产地：<input type="text" name="production" value="${requestScope.flower.production}">
                </p>
                <p>
                    <input type="submit" value="确认修改">
                    ${requestScope.msg}
                </p>
            </form>
        </center>
    </body>
</html>
