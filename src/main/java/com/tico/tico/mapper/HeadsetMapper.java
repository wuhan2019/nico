package com.tico.tico.mapper;

import com.tico.tico.entities.Headset;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HeadsetMapper {
    List<Headset> getAll();
}
