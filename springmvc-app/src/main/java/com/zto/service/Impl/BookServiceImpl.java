package com.zto.service.Impl;

import com.zto.mapper.BookMapper;
import com.zto.domain.Book;
import com.zto.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getAll() {
        return bookMapper.getAll();
    }

    @Override
    public Book selectById(int id) {
        return bookMapper.selectById(id);
    }

    @Override
    public void Test() {
        System.out.println("Test");
    }

    @Override
    public void aopTest() {
        System.out.println("aopTest");
    }
}
