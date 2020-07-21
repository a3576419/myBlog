package com.aioe.test.demo.service.impl;

import com.aioe.test.demo.mapper.UserMapper;
import com.aioe.test.demo.pojo.User;
import com.aioe.test.demo.service.UserService;
import com.aioe.test.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {
        return userMapper.checkUser(username, Utils.md5Code(password));
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
