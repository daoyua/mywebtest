package com.test.server;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet(name = "DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html ;charset=UTF-8");
        String filename = request.getParameter("filename");
//        filename=new String(filename.getBytes("ISO-8859-1"),"UTF-8");
        String header = request.getHeader("User-Agent");
        if(header.contains("FireFox")){
//火狐浏览器   base64
}else{
    //IE CHOME
    filename= URLEncoder.encode(filename,"UTF-8");
}
        InputStream is = null;
        String realPath = getServletContext().getRealPath("download/" + filename);

        response.setHeader("Content-Disposition","attachment ; filename="+filename);
        is=new FileInputStream(realPath);
        ServletOutputStream outputStream = response.getOutputStream();
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        outputStream.close();
        is.close();
    }
}
