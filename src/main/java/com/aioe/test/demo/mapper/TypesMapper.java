package com.aioe.test.demo.mapper;

import com.aioe.test.demo.pojo.Type;

public interface TypesMapper {
    Type saveType(Type type);

    void deleteType(Long id);

    Type findTypeById(Long id);
}
