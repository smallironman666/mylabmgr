<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>花卉信息展示</title>
        <base href="<%=request.getContextPath()+"/"%>">
        <script type="text/javascript">
            function remove(id) {
                var flag = window.confirm("是否删除该数据？");
                if (flag) {
                    window.location.href = "RemoveFlower?id=" + id;
                }
            }

            // function change(size) {
            //     window.location.href = "FindAllFlower?size=" + size;
            // }

            function ch2(index, size) {
                var na = document.getElementById("name").value;
                var pr = document.getElementById("price").value;
                window.location.href = "FindAllFlower?index=" + index + "&size=" + size + "&name=" + na + "&price=" + pr;
            }

            function re() {
                window.location.href = "FindAllFlower?index=${requestScope.pageBean.index}&size=${requestScope.pageBean.size}&name=&price=";
            }
        </script>
    </head>
    <body>
        <center>
            <form action="FindAllFlower" method="post">
                名称：<input type="text" name="name" id="name" value="${requestScope.name}">
                价格>：<input type="text" name="price" id="price" value="${requestScope.price}">
                <input type="submit" value="提交">
                <input type="reset" value="重置" onclick="re()">
            </form>
        </center>

        <table border="1px" align="center">
            <tr>
                <th>猪猪编号</th>
                <th>猪猪名称</th>
                <th>猪猪价格</th>
                <th>猪猪产地</th>
                <th>操作</th>
            </tr>
            <%--
            for(flower f:flowers)
            items :  变量集合  相当于上面的flowers
            var : 集合中的变量  相当于上面的flower
            --%>
            <c:forEach items="${requestScope.pageBean.list}" var="flower">
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
            <tr>
                <th colspan="5">
                    <a href="javascript:ch2(1,${requestScope.pageBean.size})">首页</a>
                    <c:if test="${requestScope.pageBean.index>1}">
                        <a href="javascript:ch2(${requestScope.pageBean.index-1},${requestScope.pageBean.size})">上一页</a>
                    </c:if>

                    <%--遍历展示页数数组--%>
                    <c:forEach items="${requestScope.pageBean.numbers}" var="num">
                        <c:if test="${requestScope.pageBean.index==num}">
                            [<a href="javascript:ch2(${num},${requestScope.pageBean.size})">${num}</a>]
                        </c:if>
                        <c:if test="${requestScope.pageBean.index!=num}">
                            <a href="javascript:ch2(${num},${requestScope.pageBean.size})">${num}</a>
                        </c:if>
                    </c:forEach>

                    <c:if test="${requestScope.pageBean.index<requestScope.pageBean.totalPageCount}">
                        <a href="javascript:ch2(${requestScope.pageBean.index+1}, ${requestScope.pageBean.size})">下一页</a>
                    </c:if>

                    <a href="javascript:ch2(${requestScope.pageBean.totalPageCount},${requestScope.pageBean.size})">尾页</a>

                    每页显示
                    <select onchange="ch2(1,this.value)">
                        <c:forEach begin="2" end="10" step="2" var="size">

                            <option value="${size}"
                                    <c:if test="${requestScope.pageBean.size==size}">selected</c:if> >${size}</option>
                        </c:forEach>
                    </select>
                    条记录,一共
                    ${requestScope.pageBean.totalCount}
                    条记录数
                </th>
            </tr>

        </table>
        <br>
        <center>
            <form action="save.jsp">
                <input type="submit" value="添加数据">
            </form>
        </center>


    </body>
</html>
