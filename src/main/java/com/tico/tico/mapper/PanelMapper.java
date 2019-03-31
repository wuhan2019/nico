package com.tico.tico.mapper;

import com.tico.tico.entities.Panel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PanelMapper {
    List<Panel> getAll();
}
