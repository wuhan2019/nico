package com.tico.tico.mapper;

import com.tico.tico.entities.Laptop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface LaptopMapper {
    List<Laptop> getAll();

    Laptop getLaptopByName(String name);
    List<Laptop> getLaptopLikeBrand(String brand);
    List<Laptop> getLaptopLikeType(String type);
    List<Laptop> getLaptopLikeBrandAndType(@Param("brand") String brand,@Param("type") String type);
    List<Laptop> searchLaptop(String key);
}
