package com.example.pojo.vo;

import com.example.pojo.bo.BookTag;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookTagsVo {
    private List<BookTag> tagList;
}
