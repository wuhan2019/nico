package com.tico.tico.services;

import com.tico.tico.entities.SSD;
import com.tico.tico.mapper.SSDMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SSDService {
    @Autowired
    SSDMapper ssdMapper;
    public List<SSD> getAll(){
        return ssdMapper.getAll();
    }
}
