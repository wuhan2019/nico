package com.tico.tico.mapper;

import com.tico.tico.entities.Memmory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemmoryMapper {
    List<Memmory> getAll();
}
