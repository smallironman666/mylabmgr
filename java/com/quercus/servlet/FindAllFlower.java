package com.quercus.servlet;

import com.quercus.pojo.Flower;
import com.quercus.service.impl.FlowerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindAllFlower")
public class FindAllFlower extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        /*接收前台数据*/
        /*处理*/
        FlowerServiceImpl flowerService = new FlowerServiceImpl();
        List<Flower> flowers = flowerService.findAll();
        /*响应*/
        req.setAttribute("flowers",flowers);
        req.getRequestDispatcher("/show.jsp").forward(req,resp);
    }
}
