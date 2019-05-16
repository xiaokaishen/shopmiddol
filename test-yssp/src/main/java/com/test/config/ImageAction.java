package com.test.config;

import java.io.FileInputStream;
import java.io.IOException;  
import java.io.OutputStream;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ImageAction extends HttpServlet {  
    private static final long serialVersionUID = -1L;  

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        this.doPost(request, response);  
    }  

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("id");
        //存储所在路径--动态id来确定具体图片
        String url="http://sc.middol.com/images"+"/"+id+".jpg";
        //存储所在路径--目前写死为1.jpg
       // String url="E:/home/images/f2854897-eef9-4842-9f84-84721883c524.jpg";
        //读取本地图片输入流  
        FileInputStream inputStream = new FileInputStream(url);
        int i = inputStream.available();  
        //byte数组用于存放图片字节数据  
        byte[] buff = new byte[i];  
        inputStream.read(buff);  
        //记得关闭输入流  
        inputStream.close();  
        //设置发送到客户端的响应内容类型  
        response.setContentType("image/*");  
        OutputStream out = response.getOutputStream();  
        out.write(buff);  
        //关闭响应输出流  
        out.close();  
    }  
}  