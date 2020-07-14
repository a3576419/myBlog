package com.aioe.test.demo.controller;


import com.aioe.test.demo.handler.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping("/{id}/{name}")
    public String index(@PathVariable Integer id, @PathVariable String name){
//        int i = 9/0;
//        if (true){
//            throw  new NotFoundException("博客不存在 404");
//        }
        System.out.println("----------index----------");
        System.out.println("id========="+id+"name===="+name);
        return "test";
    }
}
