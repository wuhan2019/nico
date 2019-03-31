package com.tico.tico.mapper;

import com.tico.tico.entities.GPU;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GPUMapper {
    List<GPU> getAll();
}
