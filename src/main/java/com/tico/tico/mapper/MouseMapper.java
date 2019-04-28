package com.tico.tico.mapper;

import com.tico.tico.entities.Mouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MouseMapper {
    List<Mouse> getAll();


    Mouse getMouseByName(String name);
    List<Mouse> getMouseLikeBrand(String brand);
    List<Mouse> getMouseLikeType(String type);
    List<Mouse> getMouseLikeBrandAndType(@Param("brand") String brand, @Param("type") String type);
    List<Mouse> searchMouse(String key);
}
