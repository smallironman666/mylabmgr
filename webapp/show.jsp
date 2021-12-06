<%--
  Created by IntelliJ IDEA.
  User: quercus
  Date: 2021/12/6
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>花卉信息展示</title>
        <base href="<%=request.getContextPath()+"/"%>">
        <script type="text/javascript">
            function remove(id) {
                var flag = window.confirm("是否删除该数据？");
                if (flag){
                    window.location.href="RemoveFlower?id="+id;
                }
            }
        </script>
    </head>
    <body>

        <table border="1px" align="center">
            <tr>
                <th>花卉编号</th>
                <th>花卉名称</th>
                <th>花卉价格</th>
                <th>花卉产地</th>
                <th>操作</th>
            </tr>
            <%--
            for(flower f:flowers)
            items :  变量集合  相当于上面的flowers
            var : 集合中的变量  相当于上面的flower
            --%>
            <c:forEach items="${requestScope.flowers}" var="flower">
                <tr>
                    <th>${flower.id}</th>
                    <th>${flower.name}</th>
                    <th>${flower.price}</th>
                    <th>${flower.production}</th>
                    <th>
                        <a href="FindOneFlower?id=${flower.id}">修改</a>
                        <a href="javascript:void(0)" onclick="remove(${flower.id})">删除</a>
                        <%--javascript:void(0) 这个可以阻断href跳转--%>
                    </th>
                </tr>
            </c:forEach>


        </table>
        <br>
        <center>
            <form action="save.jsp">
                <input type="submit" value="添加数据">
            </form>
        </center>


    </body>
</html>
