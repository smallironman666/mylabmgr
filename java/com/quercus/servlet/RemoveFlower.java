package com.quercus.servlet;

import com.quercus.service.impl.FlowerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RemoveFlower")
public class RemoveFlower extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        /*接收*/
        int id = Integer.parseInt(req.getParameter("id"));
        /*处理*/
        FlowerServiceImpl flowerService = new FlowerServiceImpl();
        int remove = flowerService.remove(id);
        /*响应*/
        resp.sendRedirect(req.getContextPath()+"/FindAllFlower");
    }
}
