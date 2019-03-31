package com.tico.tico.services;

import com.tico.tico.entities.Phone;
import com.tico.tico.mapper.PhoneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    @Autowired
    PhoneMapper phoneMapper;
    public List<Phone> getAll(){
        return phoneMapper.getAll();
    }
}
