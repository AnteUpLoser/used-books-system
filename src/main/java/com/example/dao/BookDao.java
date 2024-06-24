package com.example.dao;

import com.example.pojo.bo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookDao {
    List<Book> selectBooks();
}
