package com.tico.tico.services;

import com.tico.tico.entities.Comment2Laptop;
import com.tico.tico.mapper.Comment2LaptopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Comment2LaptopService {
    @Autowired
    Comment2LaptopMapper comment2LaptopMapper;
    public List<Comment2Laptop> getAll(){
        return comment2LaptopMapper.getAll();
    }
}
