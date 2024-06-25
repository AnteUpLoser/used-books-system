package com.example.service;

import com.example.pojo.bo.BookInfo;
import com.example.pojo.vo.BooksPageVo;

public interface BookService {
    BooksPageVo getBooks(int pageNum, int pageSize);
    BookInfo getBookInfo(int bookId);
    String getBookTags(int bookId);
}
