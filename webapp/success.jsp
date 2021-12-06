<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1 align="center">登录成功！！！</h1>
    <h2>欢迎使用猪猪实验室管理系统</h2>
    <a href="FindAllFlower"> 点击进入</a><br>
    <hr>


欢迎:<%=session.getAttribute("name")%>登录
<%--<hr/>--%>
<%--JSESSIONID:<%=session.getId()%>--%>
<%--<hr/>--%>
<a href="LoginOutSevlet">退出</a>
<%--<hr/>--%>
<%--Session有效时间:<%=session.getMaxInactiveInterval()%>--%>
<%--<%--%>
<%--session.setMaxInactiveInterval(10);--%>
<%--%>--%>

<hr/>
您是第<%=application.getAttribute("count")%>位访问的用户

</body>
</html>
<%--
 Session失效时机：（2种）

  A、自己手动注销session
     invalidate();
  B、超过最大活动时间
    1修改tomcat中web.xml中配置可以更改服务器中所有项目中所有session失效时间
      <session-config>
        <session-timeout>50</session-timeout>
     </session-config>

    2修改自己项目中web.xml当前项目中所有session发生改变，其他项目不受影响

    3修改当前项目的当前session
      session.setMaxInactiveInterval(10);

  C、关闭浏览器（注意 这种方式不是session真正失效了 而是保存到浏览器cookie中的jsessionid没有了
        造成了失效的假象 ，服务器端的session还是存在的，默认30分钟失效）


--%>
