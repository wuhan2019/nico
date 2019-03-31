package com.tico.tico.mapper;

import com.tico.tico.entities.SSD;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SSDMapper {
    List<SSD> getAll();
}
