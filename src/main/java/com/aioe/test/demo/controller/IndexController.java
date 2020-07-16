package com.aioe.test.demo.controller;


import com.aioe.test.demo.handler.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/login")
    public String loginRoot(){
        return "index";
    }
    @GetMapping("/blog")
    public String blog(){
        return "blogDetails";
    }
    @GetMapping("/blogIndex")
    public String blogLogin(){
        return "admin/index";
    }
    @GetMapping("/blogsInput")
    public String blogsInput(){
        return "admin/blogs-input";
    }
}
