package com.tico.tico.services;

import com.tico.tico.entities.Memmory;
import com.tico.tico.mapper.MemmoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemmoryService {
    @Autowired
    MemmoryMapper memmoryMapper;
    public List<Memmory> getAll(){
        return memmoryMapper.getAll();
    }
}
