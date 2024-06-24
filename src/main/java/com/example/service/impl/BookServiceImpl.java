package com.example.service.impl;

import com.example.dao.BookDao;
import com.example.dao.BookInfoDao;
import com.example.pojo.bo.Book;
import com.example.pojo.bo.BookInfo;
import com.example.pojo.vo.BooksPageVo;
import com.example.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;
    @Resource
    private BookInfoDao bookInfoDao;


    @Override
    public BooksPageVo getBooks(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> resList = bookDao.selectBooks();
        PageInfo<Book> pageInfo = new PageInfo<>(resList);
        BooksPageVo booksPageVo = new BooksPageVo();
        booksPageVo.setPageNum(pageInfo.getPageNum())
                .setPageSize(pageInfo.getPageSize())
                .setBooks(pageInfo.getList());
        return booksPageVo;
    }

    @Override
    public BookInfo getBookInfo(int bookId) {
        return bookInfoDao.selectInfoById(bookId);
    }
}
