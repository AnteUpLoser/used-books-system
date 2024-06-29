package com.example.controller;

import com.example.common.R;
import com.example.dao.BookDao;
import com.example.dao.BookInfoDao;
import com.example.dao.BookTagDao;
import com.example.pojo.bo.Book;
import com.example.pojo.bo.BookInfo;
import com.example.pojo.bo.BookTag;
import com.example.pojo.dto.BookDto;
import com.example.pojo.vo.BookInfoVo;
import com.example.pojo.vo.BookTagsVo;
import com.example.pojo.vo.BooksPageVo;
import com.example.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class BookController {
    @Resource
    private BookService bookService;
    @Resource
    private BookDao bookDao;
    @Resource
    private BookInfoDao bookInfoDao;
    @Resource
    private BookTagDao bookTagDao;

    //分页展示书籍基础数据
    @GetMapping("/get/books")
    public R<BooksPageVo> getBooks(@RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "10") Integer pageSize){
        return R.success(bookService.getBooks(pageNum, pageSize));
    }

    //展示书籍详细信息
    @GetMapping("/get/bookInfo/{bookId}")
    public R<BookInfoVo> getBookInfo(@PathVariable int bookId){
        BookInfo bookInfo = bookService.getBookInfo(bookId);
        BookInfoVo bookInfoVo = new BookInfoVo();
        bookInfoVo.setBookId(bookInfo.getBookId())
                .setCount(bookInfo.getCount())
                .setCreateTime(bookInfo.getCreateTime())
                .setDeleteTime(bookInfo.getDeleteTime())
                .setUpdateTime(bookInfo.getUpdateTime())
                .setPrice(bookInfo.getPrice())
                .setSerialNo(bookInfo.getSerialNo())
                .setTags(bookService.getBookTags(bookId));
        return R.success(bookInfoVo);
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

    //修改书籍信息
    @Transactional
    @PutMapping("/update/bookInfo")
    public R<String> updateBookInfo(@RequestBody BookDto bookDto){
        Book book = bookDto.getBook();
        BookInfo bookInfo = bookDto.getBookInfo();
        bookDao.updateBook(book);
        bookInfoDao.updateBookInfo(bookInfo);
        return R.success("修改书籍信息成功");
    }

    //获取书籍标签
    @GetMapping("/get/book/tags")
    public R<BookTagsVo> getBookTags(){
        List<BookTag> list = bookTagDao.selectAllTag();
        BookTagsVo bookTagsVo = new BookTagsVo();
        bookTagsVo.setTagList(list);
        return R.success(bookTagsVo);
    }

    //模糊查询书籍信息
    @GetMapping("/search/books")
    public R<List<Book>> VagueSearchBooks(@RequestParam String vagueInfo){
        List<Book> bookList = bookDao.selectVagueBooks(vagueInfo);
        if(bookList == null) return R.success(Collections.emptyList(),"无相关书籍信息");
        return R.success(bookList);
    }


}
