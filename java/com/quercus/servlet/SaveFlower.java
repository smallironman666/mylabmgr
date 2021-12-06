package com.quercus.servlet;

import com.quercus.pojo.Flower;
import com.quercus.service.impl.FlowerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SaveFlower")
public class SaveFlower extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        /*接收*/
        String name = req.getParameter("name");
        Double price = Double.parseDouble(req.getParameter("price"));
        String production = req.getParameter("production");
        Flower flower = new Flower(null, name, price, production);
        /*处理*/
        FlowerServiceImpl flowerService = new FlowerServiceImpl();
        int save = flowerService.save(flower);
        /*响应*/
        if (save>0){
            /*添加成功天跳转查询所有的flower页面*/
            resp.sendRedirect(req.getContextPath()+"/FindAllFlower");
        }else{
            req.setAttribute("msg","添加失败！");
            req.getRequestDispatcher("/save.jsp").forward(req,resp);
        }
    }
}
