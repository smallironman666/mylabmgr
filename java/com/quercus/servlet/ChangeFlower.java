package com.quercus.servlet;

import com.quercus.pojo.Flower;
import com.quercus.service.impl.FlowerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ChangeFlower")
public class ChangeFlower extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        /*接收*/
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Double price = Double.parseDouble(req.getParameter("price"));
        String production = req.getParameter("production");
        Flower flower = new Flower(id, name, price, production);
        /*处理*/
        FlowerServiceImpl flowerService = new FlowerServiceImpl();
        int change = flowerService.change(flower);

        /*响应*/
        if (change>0){
            /*跳转查询页面*/
            resp.sendRedirect(req.getContextPath()+"/FindAllFlower");
        }else{
            req.setAttribute("msg","添加失败！");
            req.getRequestDispatcher("/update.jsp").forward(req,resp);
        }
    }
}
