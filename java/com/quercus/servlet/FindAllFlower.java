package com.quercus.servlet;

import com.quercus.pojo.Flower;
import com.quercus.service.FlowerService;
import com.quercus.service.impl.FlowerServiceImpl;
import com.quercus.util.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindAllFlower")
public class FindAllFlower extends HttpServlet {
    FlowerService flowerServiceImpl = new FlowerServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        /*接收前台数据*/
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        /*当前页数*/
        String index = req.getParameter("index");
        String sizeChanged = req.getParameter("size");
        int ind = 1;
        if (index != null && !"".equals(index)) {
            ind = Integer.parseInt(index);
        }
        int siz = 8;
        if (sizeChanged != null && !"".equals(sizeChanged)) {
            siz = Integer.parseInt(sizeChanged);
        }
        /*从pageBean获取下标*/
        PageBean pageBean = new PageBean();
        /*把当前的页数和size设置到pageBean中*/
        pageBean.setIndex(ind);
        pageBean.setSize(siz);

        /*设置查询记录总条数*/
        pageBean.setTotalCount(flowerServiceImpl.findCount(name, price));
        /*获取开始下标*/
        int start = pageBean.getStartRow();
        /*获取每页显示的条数*/
        int size = pageBean.getSize();

        /*处理*/
        FlowerServiceImpl flowerService = new FlowerServiceImpl();
        List<Flower> flowers = flowerService.findMore(start, size, name, price);
        pageBean.setList(flowers);
        /*响应*/
//        req.setAttribute("flowers", flowers);
        req.setAttribute("pageBean", pageBean);
        req.setAttribute("name", name);
        req.setAttribute("price", price);
        req.getRequestDispatcher("/show.jsp").forward(req, resp);
    }
}
