package com.zto.baseServlets;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;

/**
 * Servlet生命周期
 */
public class BaseServlet implements Servlet {

    private ServletConfig servletConfig;

    /**
     * 初始化方法
     * 1.调用时机：默认情况下，Servlet被第一次访问时，调用
     * * loadOnStartup: 默认为-1，修改为0或者正整数，则会在服务器启动的时候，调用
     * 2.调用次数: 1次
     *
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println("init...");
    }

    /**
     * 提供服务
     * 1.调用时机:每一次Servlet被访问时，调用
     * 2.调用次数: 多次
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //获取请求方式，根据不同的请求方式进行不同的业务处理
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //1. 获取请求方式
        String method = request.getMethod();
        //2. 判断
        if ("GET".equals(method)) {
            // get方式的处理逻辑
            doGet(servletRequest, servletResponse);
        } else if ("POST".equals(method)) {
            // post方式的处理逻辑
            doPost(servletRequest, servletResponse);
        } else {
        }
    }

    //获取ServletConfig对象
    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    /**
     * 该方法用来返回Servlet的相关信息，没有什么太大的用处，一般我们返回一个空字符串即可
     */
    @Override
    public String getServletInfo() {
        return "";
    }

    /**
     * 销毁方法
     * 1.调用时机：内存释放或者服务器关闭的时候，Servlet对象会被销毁，调用
     * 2.调用次数: 1次
     */
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }


    protected void doGet(ServletRequest req, ServletResponse res) throws IOException {
        System.out.println("doGet...");
    }

    protected void doPost(ServletRequest req, ServletResponse res) {
        System.out.println("doPost...");
    }
}
