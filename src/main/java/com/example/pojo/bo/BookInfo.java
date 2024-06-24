package com.example.pojo.bo;

import lombok.Data;

/**
 * 对二手书信息的拓展
 * 主要针对二手书在系统的信息
 *
 */
@Data
public class BookInfo {
    private int bookId;
    private String serialNo; //书在系统中的流水号
    private double price;
    private String createTime;
    private String updateTime;
    private String deleteTime;
    private int count;  //余量
    private int isDelete;   //是否在上架
}
