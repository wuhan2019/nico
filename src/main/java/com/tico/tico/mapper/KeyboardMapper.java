package com.tico.tico.mapper;

import com.tico.tico.entities.Keyboard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface KeyboardMapper {
    List<Keyboard> getAll();

    Keyboard getKeyboardByName(String name);
    List<Keyboard> getKeyboardLikeBrand(String brand);
    List<Keyboard> getKeyboardLikeType(String type);
    List<Keyboard> getKeyboardLikeBrandAndType(@Param("brand") String brand, @Param("type") String type);
    List<Keyboard> searchKeyboard(String key);
}
