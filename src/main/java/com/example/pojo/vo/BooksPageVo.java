package com.example.pojo.vo;

import com.example.pojo.bo.Book;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class BooksPageVo {
    private int pageNum;
    private int pageSize;
    private List<Book> books;
}
