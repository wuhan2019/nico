package com.tico.tico.mapper;

import com.tico.tico.entities.GPU;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface GPUMapper {
    List<GPU> getAll();

    GPU getGPUByName(String name);
    List<GPU> getGPULikeBrand(String brand);
    List<GPU> getGPULikeType(String type);
    List<GPU> getGPULikeBrandAndType(@Param("brand") String brand, @Param("type") String type);
    List<GPU> searchGPU(String key);
}
