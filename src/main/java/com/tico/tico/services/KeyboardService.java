package com.tico.tico.services;

import com.tico.tico.entities.Keyboard;
import com.tico.tico.mapper.KeyboardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyboardService {
    @Autowired
    KeyboardMapper keyboardMapper;
    public List<Keyboard> getAll(){
        return keyboardMapper.getAll();
    }
}
