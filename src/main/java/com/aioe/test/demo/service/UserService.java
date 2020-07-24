package com.aioe.test.demo.service;


import com.aioe.test.demo.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {

    User checkUser(String username,String password);

    void insertUser(User user);

    String findUsername(String username);

    String findInfo(User user);

    boolean findEmail(String email);
}
