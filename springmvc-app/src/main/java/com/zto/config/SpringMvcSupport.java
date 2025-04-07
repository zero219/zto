package com.zto.config;

import com.zto.interceptor.ProjectInterceptor;
import com.zto.interceptor.SystemInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    //注入拦截器
    @Autowired
    private ProjectInterceptor projectInterceptor;

    @Autowired
    private SystemInterceptor systemInterceptor;

    /**
     * 设置静态资源访问过滤，但是jsp不属于静态文件，所以不能拦截；
     * 解决方法有两种：
     * 1、将所有的jsp文件放入到WEB-INF文件夹下，这样用户是直接不能访问WEB-INF文件下的jsp文件的，可以使用请求访问，例：/home/toPage。
     * 2、jsp如果不放在WEB-INF文件下，spring mvc是无法拦截的，这种情况下需要用最原始的servlet的Filter接口。
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //当访问/pages/????时候，从/pages目录下查找内容
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        /**
         * 配置拦截器
         * 配置多个拦截器
         * 当配置多个拦截器时，形成拦截器链
         * 拦截器链的运行顺序参照拦截器添加顺序为准
         * 当拦截器中出现对原始处理器的拦截，后面的拦截器均终止运行
         * 当拦截器运行中断，仅运行配置在前面的拦截器的afterCompletion操作
         */
        registry.addInterceptor(projectInterceptor).addPathPatterns("/books", "/book/*");
        registry.addInterceptor(systemInterceptor).addPathPatterns("/books", "/book/*");
    }
}
