package com.tico.tico.mapper;

import com.tico.tico.entities.Laptop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LaptopMapper {
    List<Laptop> getAll();
}
