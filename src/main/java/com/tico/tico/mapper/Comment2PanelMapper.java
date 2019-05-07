package com.tico.tico.mapper;

import com.tico.tico.entities.Comment2Laptop;
import com.tico.tico.entities.Comment2Panel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface Comment2PanelMapper {
    List<Comment2Panel> getAll();

    List<Comment2Panel> getByName(String name);
    double price_mark(String name);
    double screen_mark(String name);
    double workspeed_mark(String name);
    double battery_mark(String name);
    double appearance_mark(String name);
    void addPanelComment(@Param("panelComment") Comment2Panel panelComment);
}
