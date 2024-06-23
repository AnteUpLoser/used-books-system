package com.example.dao;

import com.example.pojo.bo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserDao{
    //查找有无此管理员
    User selectLoginUser(@Param("username") String username, @Param("pwd") String pwd);

}
