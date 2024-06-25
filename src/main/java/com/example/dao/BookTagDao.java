package com.example.dao;

import com.example.pojo.bo.BookTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookTagDao {
    @Select("select * from book_tag;")
    List<BookTag> selectAllTag();
}
