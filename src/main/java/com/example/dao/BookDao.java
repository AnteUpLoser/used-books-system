package com.example.dao;

import com.example.pojo.bo.Book;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface BookDao {
    List<Book> selectBooks();
    List<Book> selectVagueBooks(@Param("pattern") String pattern);

    @Insert("insert into book (name, author, publish_from, pages, word_count, isbn) VALUES (#{name}, #{author}, #{publishFrom}, #{pages}, #{wordCount},#{isbn})")
    @Options(useGeneratedKeys = true, keyProperty = "bookId")
    void insertBook(Book book);
    @Select("select * from book where book_id = #{bookId};")
    Book selectById(int bookId);
    @Update("UPDATE book SET name = #{name}, author = #{author}, cover = #{cover}, publish_from = #{publishFrom}, " +
            "pages = #{pages}, word_count = #{wordCount}, isbn = #{isbn} WHERE book_id = #{bookId}")
    void updateBook(Book book);

}
