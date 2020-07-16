package com.aioe.test.demo.service.impl;

import com.aioe.test.demo.handler.NotFoundException;
import com.aioe.test.demo.mapper.TypesMapper;
import com.aioe.test.demo.pojo.Type;
import com.aioe.test.demo.service.TypesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypesServiceImpl implements TypesService {

    @Autowired
    private TypesMapper typesMapper;

    @Override
    public Type saveType(Type type) {
        return typesMapper.saveType(type);
    }

    @Override
    public void deleteType(Long id) {
        typesMapper.deleteType(id);
    }

    @Override
    public Type updateType(Long id, Type type) {
        Type type1 = typesMapper.findTypeById(id);
        if (type1 == null){
            throw new NotFoundException("不存在的类型");
        }
        //BeanUtils.copyProperties(type,type1);
        return typesMapper.saveType(type);
    }

    @Override
    public Type getType(Long id) {
        return null;
    }


    @Override
    public List<Type> pageType(Type type) {
        return null;
    }

}
