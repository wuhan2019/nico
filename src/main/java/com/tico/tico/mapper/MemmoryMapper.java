package com.tico.tico.mapper;

import com.tico.tico.entities.Memmory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MemmoryMapper {
    List<Memmory> getAll();

    Memmory getMemmoryByName(String name);
    List<Memmory> getMemmoryLikeBrand(String brand);
    List<Memmory> getMemmoryLikeType(String type);
    List<Memmory> getMemmoryLikeBrandAndType(@Param("brand") String brand, @Param("type") String type);
    List<Memmory> searchMemmory(String key);
}
