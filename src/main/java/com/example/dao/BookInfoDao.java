package com.example.dao;

import com.example.pojo.bo.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookInfoDao {
    @Select("select * from book_info where book_id = #{id}")
    BookInfo selectInfoById(int id);

}
