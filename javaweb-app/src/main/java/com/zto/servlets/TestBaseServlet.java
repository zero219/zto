package com.zto.servlets;

import com.zto.baseServlets.BaseServlet;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


/**
 * ***** 该段代码主要演示继承自己定义的BaseServlet *****
 * <p>
 * <p>
 * <p>
 * UrlPattern: 精确匹配
 * loadOnStartup: 默认为-1，修改为0或者正整数，则会在服务器启动的时候，调用
 * 请求地址URL：http://localhost:8080/test
 */
@WebServlet(urlPatterns = "/test", loadOnStartup = 1)
public class TestBaseServlet extends BaseServlet {

    @Override
    protected void doGet(ServletRequest request, ServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("您请求了test中的get请求");
        System.out.println("Get...");
    }

    @Override
    protected void doPost(ServletRequest req, ServletResponse res) {
        System.out.println("Post...");
    }
}

