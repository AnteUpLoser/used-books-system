package com.example.pojo.bo;


import com.example.util.TimeUtil;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Bulletin {
    private Integer id;
    private String title;
    private String content;
    private Long notifyTime;
    private Long updateTime;
    private Long deleteTime;
    private int isDelete;
}
