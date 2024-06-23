package com.example.service;


import com.example.common.R;
import com.example.pojo.dto.UserDTO;

public interface UserService {
    R<String> login(UserDTO user);
}
