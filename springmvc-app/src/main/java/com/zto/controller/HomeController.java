package com.zto.controller;

import com.zto.domain.Book;
import com.zto.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    BookService bookService;

    /**
     * 返回文本内容
     * produces 解决返回中文乱码
     *
     * @return 字符串
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String hello() {
        bookService.aopTest();
        return "您好，springmvc";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String save(String name, int age) {
        return "{'名字：':'" + name + "','---年龄：':'" + age + "'}";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public String Add(@RequestParam("name") String userName, int age) {
        return "{'名字：':'" + userName + "','---年龄：':'" + age + "'}";
    }

    @RequestMapping(value = "/pojoParams", method = RequestMethod.POST)
    @ResponseBody
    public Book pojoParams(Book book) {
        return book;
    }

    //数组参数：同名请求参数可以直接映射到对应名称的形参数组对象中
    @RequestMapping(value = "/arrayParams", method = RequestMethod.POST)
    @ResponseBody
    public String[] arrayParams(String[] arr) {
        return arr;
    }

    //集合参数：同名请求参数可以使用@RequestParam注解映射到对应名称的集合对象中作为数据
    @RequestMapping(value = "/listParams", method = RequestMethod.POST)
    @ResponseBody
    public List<String> listParams(@RequestParam List<String> list) {
        return list;
    }

    //使用@RequestBody注解将外部传递的json数组数据映射到形参的集合对象中作为数据
    @RequestMapping(value = "/listParamForJson", method = RequestMethod.POST)
    @ResponseBody
    public String listParamForJson(@RequestBody List<String> likes) {
        System.out.println("list common(json)参数传递 list ==> " + likes);
        return "{'module':'list common for json param'}";
    }

    @RequestMapping(value = "/dataParam", method = RequestMethod.GET)
    @ResponseBody
    public String dataParam(Date date, @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1, @DateTimeFormat(pattern = "yyyy/MM/dd") Date date2) {
        System.out.println("参数传递 date ==> " + date);
        System.out.println("参数传递 date1(yyyy-MM-dd) ==> " + date1);
        System.out.println("参数传递 date2(yyyy/MM/dd HH:mm:ss) ==> " + date2);
        return "{'module':'data param'}";
    }

    /**
     * 注意
     * 1.该不能添加@ResponseBody,如果加了该注入，会直接将index.jsp当字符串返回前端
     * 2.方法需要返回String
     *
     * @return
     */
    @RequestMapping(value = "/toPage", method = RequestMethod.GET)
    public String toPage() {
        System.out.println("跳转页面");
        return "/WEB-INF/index.jsp";
    }
}
