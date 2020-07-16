package com.aioe.test.demo.mapper;

import com.aioe.test.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserMapper {
    User checkUser(String username, String password);
}
