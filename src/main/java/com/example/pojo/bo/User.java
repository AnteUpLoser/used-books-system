package com.example.pojo.bo;

import lombok.Data;

@Data
public class User {
    private int uid;
    private String username;
    private String password;
    private String memo;
}
