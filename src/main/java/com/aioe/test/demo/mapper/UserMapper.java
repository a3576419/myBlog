package com.aioe.test.demo.mapper;

import com.aioe.test.demo.pojo.User;

public interface UserMapper {
    User checkUser(String username, String password);
}
