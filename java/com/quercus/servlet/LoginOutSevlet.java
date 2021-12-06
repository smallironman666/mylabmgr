package com.quercus.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginOutSevlet")
public class LoginOutSevlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         //[1]获得当前session对象
        HttpSession session = req.getSession();
        //[2]注销session
        session.invalidate();
        //session.removeAttribute("name");  移除session 中指定属性，没有销毁sessiob
        //[3]跳转到登录页面   req.getContextPath()--->/servlet03_war_exploded
         resp.sendRedirect(req.getContextPath()+"/login.jsp");

    }
}
