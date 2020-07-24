package com.aioe.test.demo.mapper;

import com.aioe.test.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {
    User checkUser(String username, String password);

    void insertUser(User user);

    String findUsername(String username);

    User findInfo(User user);

    String findEmail(String email);
}
