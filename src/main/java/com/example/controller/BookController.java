package com.example.controller;

import com.example.common.R;
import com.example.dao.BookDao;
import com.example.dao.BookInfoDao;
import com.example.pojo.bo.Book;
import com.example.pojo.bo.BookInfo;
import com.example.pojo.dto.BookDto;
import com.example.pojo.vo.BooksPageVo;
import com.example.service.BookService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


@RestController
public class BookController {
    @Resource
    private BookService bookService;
    @Resource
    private BookDao bookDao;
    @Resource
    private BookInfoDao bookInfoDao;

    //分页展示书籍基础数据
    @GetMapping("/get/books")
    public R<BooksPageVo> getBooks(@RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "10") Integer pageSize){
        return R.success(bookService.getBooks(pageNum, pageSize));
    }

    //展示书籍详细信息
    @GetMapping("/get/bookInfo/{bookId}")
    public R<BookInfo> getBookInfo(@PathVariable int bookId){

        return R.success(bookService.getBookInfo(bookId));
    }


    //添加书籍信息
    @Transactional
    @PostMapping("/add/new/bookInfo")
    public R<String> addNewBookInfo(@RequestBody BookDto bookDto){
        bookDao.insertBook(bookDto.getBook());
        BookInfo bookInfo = bookDto.getBookInfo();
        bookInfo.setBookId(bookDto.getBook().getBookId());
        bookInfoDao.insertBookInfo(bookInfo);
        return R.success("新增书籍成功");
    }


}
