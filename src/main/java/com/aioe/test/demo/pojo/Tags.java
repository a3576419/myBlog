package com.aioe.test.demo.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tags implements Serializable {
    private Long id;
    private String name;

    private List<Blog>blogs = new ArrayList<>();


    public Tags() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Tags{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}
