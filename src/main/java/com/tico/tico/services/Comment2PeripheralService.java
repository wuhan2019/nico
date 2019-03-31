package com.tico.tico.services;

import com.tico.tico.entities.Comment2Peripheral;
import com.tico.tico.mapper.Comment2PeripheralMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Comment2PeripheralService {
    @Autowired
    Comment2PeripheralMapper comment2PeripheralMapper;
    public List<Comment2Peripheral> getAll(){
        return comment2PeripheralMapper.getAll();
    }
}
