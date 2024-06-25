package com.example.pojo.dto;

import com.example.pojo.bo.Book;
import com.example.pojo.bo.BookInfo;
import lombok.Data;

@Data
public class BookDto {
    private Book book;
    private BookInfo bookInfo;
}
