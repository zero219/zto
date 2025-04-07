package com.zto.mapper;

import com.zto.domain.Book;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {
    @Select("select * from tbl_book")
    List<Book> getAll();

    Book selectById(int id);

}
