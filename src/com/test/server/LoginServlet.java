package com.test.server;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGET");
        ServletConfig servletConfig = getServletConfig();
//        System.out.println( servletConfig.getServletName());
        ServletContext servletContext = getServletContext();
        Properties properties=new Properties();
        //H:\java\mywebtest\out\artifacts\mywebtest_war_exploded\config.properties

//        servletContext
        //相对路径
        InputStream resourceAsStream = servletContext.getResourceAsStream("WEB-INF/files/config.properties");
        properties.load(resourceAsStream);
        //绝对路劲
//        String realPath = servletContext.getRealPath("WEB-INF/files/config.properties");//
//        System.out.println("realPath="+realPath);
//        properties.load(new FileInputStream(realPath));
        String name = properties.getProperty("name");
        System.out.println("name="+name);
//        servletConfig.getServletName()
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPOST=");
       doGet(req,resp);
    }
}
