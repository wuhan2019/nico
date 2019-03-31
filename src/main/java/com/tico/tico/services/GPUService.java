package com.tico.tico.services;

import com.tico.tico.entities.GPU;
import com.tico.tico.mapper.GPUMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GPUService {
    @Autowired
    GPUMapper gpuMapper;
    public List<GPU> getAll(){
        return gpuMapper.getAll();
    }
}
