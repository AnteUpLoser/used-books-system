package com.example.pojo.bo;

import lombok.Data;

@Data
public class Issue {
    private Integer id;
    private int uid;
    private String username;
    private String issue;
    private String createTime;
}
