package com.tico.tico.mapper;

import com.tico.tico.entities.Panel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PanelMapper {
    List<Panel> getAll();

    Panel getPanelByName(String name);
    List<Panel> getPanelLikeBrand(String brand);
    List<Panel> getPanelLikeType(String type);
    List<Panel> getPanelLikeBrandAndType(@Param("brand") String brand, @Param("type") String type);
    List<Panel> searchPanel(String key);
}
