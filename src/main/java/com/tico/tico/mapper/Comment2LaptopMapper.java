package com.tico.tico.mapper;

import com.tico.tico.entities.Comment2Laptop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface Comment2LaptopMapper {
    List<Comment2Laptop> getAll();


    List<Comment2Laptop> getByName(String name);
    double price_mark(String name);
    double screen_mark(String name);
    double workspeed_mark(String name);
    double battery_mark(String name);
    double radiation_mark(String name);
    double appearance_mark(String name);
    void addLaptopComment(@Param("laptopComment") Comment2Laptop laptopComment);
}
