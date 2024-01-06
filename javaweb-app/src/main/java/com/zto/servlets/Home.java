package com.zto.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * ***** 该代码独立，主要演示继承HttpServlet，重写get、post、delete等等请求 *****
 * HttpServlet是Servlet的子类，主要用来简化请求的
 * <p>
 * <p>
 * <p>
 * UrlPattern：精确匹配
 * loadOnStartup：默认为-1，修改为0或者正整数，则会在服务器启动的时候，调用
 * 请求地址URL：http://localhost:8080/home
 */
@WebServlet(urlPatterns = "/home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        //接收url中name的值
        String username = servletRequest.getParameter("username") == null ? "lisi" : servletRequest.getParameter("username");
        //获取请求头中浏览器的值
        String agent = servletRequest.getHeader("User-Agent");
        //使用response对象 设置响应数据
        servletResponse.setHeader("content-type", "text/html;charset=utf-8");
        Writer writer = servletResponse.getWriter();
        writer.write("<h1>" + username + ",欢迎您！</h1><br/>");
        writer.write("<h1>浏览器版本是:" + agent + "</h1><br/>");
    }

    @Override
    protected void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("post请求");
    }
}
