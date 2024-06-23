package com.example.service.impl;

import com.example.common.R;
import com.example.dao.UserDao;
import com.example.pojo.bo.User;
import com.example.pojo.dto.UserDTO;
import com.example.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public R<String> login(UserDTO userDto) {
        User user = userDao.selectLoginUser(userDto.getUsername(), userDto.getPassword());
        if(user == null){
            return R.error("没有找到该用户");
        }
        if(user.getUsername().equals(userDto.getUsername()) && user.getPassword().equals(userDto.getPassword())){
            return R.success(user.getUsername() + "登录成功");
        }
        return R.error();
    }


}
