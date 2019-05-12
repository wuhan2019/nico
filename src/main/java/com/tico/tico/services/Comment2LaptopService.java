package com.tico.tico.services;

import com.tico.tico.entities.Comment2Laptop;
import com.tico.tico.mapper.Comment2LaptopMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Comment2LaptopService {
    @Autowired
    Comment2LaptopMapper comment2LaptopMapper;
    public List<Comment2Laptop> getAll(){
        return comment2LaptopMapper.getAll();
    }
    public List<Comment2Laptop> getByName(String name){return comment2LaptopMapper.getByName(name);}
    public Double price_mark(String name){return comment2LaptopMapper.price_mark(name);}
    public Double screen_mark(String name){return comment2LaptopMapper.screen_mark(name);}
    public Double workspeed_mark(String name){return comment2LaptopMapper.workspeed_mark(name);}
    public Double battery_mark(String name){return comment2LaptopMapper.battery_mark(name);}
    public Double radiation_mark(String name){return comment2LaptopMapper.radiation_mark(name);}
    public Double appearance_mark(String name){return comment2LaptopMapper.appearance_mark(name);}
    public void addLaptopComment(@Param("laptopComment") Comment2Laptop laptopComment){comment2LaptopMapper.addLaptopComment(laptopComment);}
}
