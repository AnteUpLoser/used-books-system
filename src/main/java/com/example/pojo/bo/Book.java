package com.example.pojo.bo;

import lombok.Data;

/**
 * 二手书基础信息
 */
@Data
public class Book {
    private int bookId;
    private String name;
    private String author;
    private String cover;   //封面
    private String publishFrom;  //出版社信息
    private int pages;  //页数
    private long wordCount; //字数
    private String isbn;
}
