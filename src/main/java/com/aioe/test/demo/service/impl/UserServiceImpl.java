package com.aioe.test.demo.service.impl;

import com.aioe.test.demo.mapper.UserMapper;
import com.aioe.test.demo.pojo.User;
import com.aioe.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required=true)
    private UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {
        return userMapper.checkUser(username,password);
    }
}
