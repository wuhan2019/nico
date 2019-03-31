package com.tico.tico.services;

import com.tico.tico.entities.Headset;
import com.tico.tico.mapper.HeadsetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadsetService {
    @Autowired
    HeadsetMapper headsetMapper;
    public List<Headset> getAll(){
        return headsetMapper.getAll();
    }
}
