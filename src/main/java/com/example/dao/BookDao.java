package com.example.dao;

import com.example.pojo.bo.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;


import java.util.List;

@Mapper
public interface BookDao {
    List<Book> selectBooks();
    @Insert("insert into book (name, author, publish_from, pages, word_count, isbn) VALUES (#{name}, #{author}, #{publishFrom}, #{pages}, #{wordCount},#{isbn})")
    @Options(useGeneratedKeys = true, keyProperty = "bookId")
    void insertBook(Book book);
}
