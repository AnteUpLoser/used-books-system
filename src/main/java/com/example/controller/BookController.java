package com.example.controller;

import com.example.common.R;
import com.example.pojo.bo.BookInfo;
import com.example.pojo.vo.BooksPageVo;
import com.example.service.BookService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {
    @Resource
    private BookService bookService;

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


}
