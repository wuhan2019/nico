package com.tico.tico.services;

import com.tico.tico.entities.Comment2Peripheral;
import com.tico.tico.mapper.Comment2PeripheralMapper;
import org.apache.ibatis.annotations.Param;
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
    public List<Comment2Peripheral> getByName(String name){return comment2PeripheralMapper.getByName(name);}
    public double mark(String name){return comment2PeripheralMapper.mark(name);}
    public void addPeripheralComment(@Param("peripheralComment") Comment2Peripheral peripheralComment){comment2PeripheralMapper.addPeripheralComment(peripheralComment);}
}
