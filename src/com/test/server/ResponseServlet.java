package com.test.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResponseServlet")
public class ResponseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request,    HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("哈哈哈");

        String realPath = getServletContext().getRealPath("");
        System.out.println(realPath);
        //重定向
        response.sendRedirect("success.html");
        //跳转转发
//        request.getRequestDispatcher("success.html").forward(request,response);
    }
}
