package com.tico.tico.mapper;

import com.tico.tico.entities.Comment2Laptop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Comment2LaptopMapper {
    List<Comment2Laptop> getAll();
}
