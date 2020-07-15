package com.aioe.test.demo.service;


import com.aioe.test.demo.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {

    User checkUser(String username,String password);

}
