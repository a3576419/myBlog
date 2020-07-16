package com.aioe.test.demo.service;

import com.aioe.test.demo.pojo.Type;

import java.util.List;

public interface TypesService {

    Type saveType(Type type);

    void deleteType(Long id);

    Type updateType(Long id, Type type);

    Type getType(Long id);

    List<Type> pageType(Type type);
}
