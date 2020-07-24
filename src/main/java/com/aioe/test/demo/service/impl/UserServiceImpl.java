package com.aioe.test.demo.service.impl;

import com.aioe.test.demo.mapper.UserMapper;
import com.aioe.test.demo.pojo.User;
import com.aioe.test.demo.service.UserService;
import com.aioe.test.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public String findUsername(String username) {
        String username1 = userMapper.findUsername(username);
        if (username1==null){
            return "success";
        }
        return "failed";
    }

    @Override
    public String findInfo(User user) {
        user = userMapper.findInfo(user);
        if (user==null){
            return "success";
        }
        return "failed";
    }

    @Override
    public boolean findEmail(String email) {
        String isEmail = userMapper.findEmail(email);
        if (isEmail==null){
            return true;
        }
        return false;
    }

}
