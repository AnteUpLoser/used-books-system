package com.example.dao;

import com.example.pojo.bo.BookInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BookInfoDao {
    @Select("select * from book_info where book_id = #{id}")
    BookInfo selectInfoById(int id);
    @Insert("insert into book_info (book_id, serial_no, price, create_time, update_time, count) values (#{bookId}, #{serialNo}, #{price}, #{createTime}, #{updateTime}, #{count});")
    void insertBookInfo(BookInfo bookInfo);
    @Update("UPDATE book_info SET serial_no = #{serialNo}, price = #{price}, update_time = #{updateTime}, " +
            "count = #{count} WHERE book_id = #{bookId}")
    void updateBookInfo(BookInfo bookInfo);

}
