package com.tico.tico.services;

import com.tico.tico.entities.Mouse;
import com.tico.tico.mapper.MouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MouseService {
    @Autowired
    MouseMapper mouseMapper;
    public List<Mouse> getAll(){
        return mouseMapper.getAll();
    }
}
