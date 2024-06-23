package com.example.service;


import com.example.common.R;
import com.example.pojo.dto.UserDto;

public interface UserService {
    R<String> login(UserDto user);
}
