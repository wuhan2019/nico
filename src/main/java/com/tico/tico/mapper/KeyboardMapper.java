package com.tico.tico.mapper;

import com.tico.tico.entities.Keyboard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KeyboardMapper {
    List<Keyboard> getAll();
}
