package com.tico.tico.services;

import com.tico.tico.entities.Comment2Phone;
import com.tico.tico.mapper.Comment2PhoneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Comment2PhoneService {
    @Autowired
    Comment2PhoneMapper comment2PhoneMapper;
    public List<Comment2Phone> getAll(){
        return comment2PhoneMapper.getAll();
    }
}
