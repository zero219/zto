package com.zto.service;

import com.zto.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();

    Book selectById(int id);

    void Test();

    void aopTest();


}
