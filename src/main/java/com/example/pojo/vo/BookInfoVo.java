package com.example.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BookInfoVo {
    private int bookId;
    private String serialNo; //书在系统中的流水号
    private double price;
    private String createTime;
    private String updateTime;
    private String deleteTime;
    private String tags;
    private int count;  //余量
    private int isDelete;   //是否在上架
}
