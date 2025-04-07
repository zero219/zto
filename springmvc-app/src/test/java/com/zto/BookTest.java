package com.zto;

import com.zto.config.SpringConfig;
import com.zto.domain.Book;
import com.zto.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookTest {

    @Autowired
    private BookService bookService;

    @Test
    public void getAllTest() {
        List<Book> all = bookService.getAll();
        System.out.println(all);
    }

    @Test
    public void selectByIdTest() {
        Book book = bookService.selectById(1);
        System.out.println(book);
    }

    @Test
    public void aopTest() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = ctx.getBean(BookService.class);
        bookService.aopTest();
        bookService.Test();
    }
}
