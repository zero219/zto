package com.zto.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping(produces = "application/json;charset=utf-8")
    public String hello() {
        return "您好，book";
    }

    @GetMapping(value = "/getBook")
    public String getBook() {
        int i = 1/0;
        return "book";
    }
}
