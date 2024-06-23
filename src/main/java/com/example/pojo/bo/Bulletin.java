package com.example.pojo.bo;


import com.example.util.TimeUtil;
import lombok.Data;

@Data
public class Bulletin {
    private Integer id;
    private String title;
    private String content;
//    @TableField(fill = FieldFill.INSERT)
    private Long notifyTime;
//    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;
    private Long deleteTime;
    private int isDelete;
}
