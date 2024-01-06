package com.zto.servlets;

import com.zto.baseServlets.BaseHttpServlet;
import com.zto.entity.User;
import com.zto.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 该段代码用于演示继承自己封装的BaseHttpServlet
 */
@WebServlet("/user/*")
public class UserServlet extends BaseHttpServlet {
    private UserService service = new UserService();

    // 请求地址URL：http://localhost:8080/user/selectAll
    public void selectAll(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {

        //1. 获取请求方式
        String method = servletRequest.getMethod();
        //2. 判断
        if ("GET".equals(method)) {
            // get方式的处理逻辑
            this.getSelectAll(servletRequest, servletResponse);
        } else if ("POST".equals(method)) {
            // post方式的处理逻辑
            this.postSelectAll(servletRequest, servletResponse);
        } else {
            System.out.println("未知的请求");
        }
    }

    private void getSelectAll(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws IOException {
        List<User> users = service.selectAll();
        System.out.println(users);
    }

    private void postSelectAll(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        this.getSelectAll(servletRequest, servletResponse);
    }

    // 请求地址URL：http://localhost:8080/user/selectAll?username=lisi
    private void getTest(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws IOException {

        //get获取请求参数的统一方式
        String params = servletRequest.getQueryString();
        System.out.println("get获取请求参数的统一方式" + params);

        /**
         * http://localhost:8080/user/selectAll?name=李四；接收name乱码问题
         */
        String username = servletRequest.getParameter("username");
        System.out.println("解决乱码前：" + username);
        //：用getParameter获取中文有乱码问题
        username = new String(username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println("解决乱码后：" + username);

        //重定向
        servletResponse.sendRedirect("/home?username=" + username);

        System.out.println("GetSelectAll...");

    }

    private void postTest(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        //post获取请求参数的统一方式
        BufferedReader br = servletRequest.getReader();
        //设置字符输入流的编码，设置的字符集要和页面保持一致
        String result = br.readLine();
        //URL解码
        String decode = URLDecoder.decode(result, "utf-8");
        System.out.println("URL解码后:" + decode);
        //URL编码
        String encode = URLEncoder.encode(decode, "utf-8");
        System.out.println("URL编码:" + encode);

        servletResponse.setHeader("content-type", "text/html;charset=utf-8");
        //返回状态码
        servletResponse.setStatus(222);
        //返回请求头部
        servletResponse.setHeader("location", "PostSelectAll");
        //返回输出流
        Writer writer = servletResponse.getWriter();
        writer.write("<h1>提交成功</h1>");

        System.out.println("PostSelectAll...");
    }
}
