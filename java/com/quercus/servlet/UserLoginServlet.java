package com.quercus.servlet;

import com.quercus.pojo.User;
import com.quercus.service.UserService;
import com.quercus.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        /*接受前台页面中的数据信息*/
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        /*数据处理，连接数据库进行数据比较返回结果*/
        UserService userService = new UserServiceImpl();
        User user = userService.login(uname, pwd);
        /*根据返回结果给用户作出响应*/
        if (user != null) {
            /*证明当前用户存在*/
            /******************使用application对象实现人数统计案例******************/
            ServletContext servletContext = req.getServletContext();
            //获得之前登录成功用户数量
            Integer count = (Integer) servletContext.getAttribute("count");
            if (count == null) {
                //当前用户是第一个登录的
                count = 1;
            } else {
                count++;
            }
            //计算完成在把count值重新设置到ServletContext对象中
            servletContext.setAttribute("count", count);
            /******************使用session实现欢迎XX登录**********************/

            //获得/创建  session对象
            HttpSession session = req.getSession();
            //把用户信息保存到session中
            session.setAttribute("name", uname);
            resp.sendRedirect(req.getContextPath()+"/success.jsp");
        } else {
            /*登录失败*/
            req.setAttribute("msg", "用户不存在，请与管理员联系!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
