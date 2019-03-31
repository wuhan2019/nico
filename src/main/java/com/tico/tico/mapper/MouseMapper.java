package com.tico.tico.mapper;

import com.tico.tico.entities.Mouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MouseMapper {
    List<Mouse> getAll();
}
