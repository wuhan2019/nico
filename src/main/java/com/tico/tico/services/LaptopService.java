package com.tico.tico.services;

import com.tico.tico.entities.Laptop;
import com.tico.tico.mapper.LaptopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {
    @Autowired
    LaptopMapper laptopMapper;
    public List<Laptop> getAll(){
        return laptopMapper.getAll();
    }
}
