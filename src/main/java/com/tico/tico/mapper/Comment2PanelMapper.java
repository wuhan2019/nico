package com.tico.tico.mapper;

import com.tico.tico.entities.Comment2Panel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface Comment2PanelMapper {
    List<Comment2Panel> getAll();
}
