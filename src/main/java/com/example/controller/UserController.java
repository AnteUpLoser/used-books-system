package com.example.controller;

import com.example.common.R;
import com.example.pojo.dto.UserDTO;
import com.example.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/admin/login")
    public R<String> adminLogin(@RequestBody UserDTO userDTO){
        return userService.login(userDTO);
    }


}
