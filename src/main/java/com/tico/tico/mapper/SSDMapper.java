package com.tico.tico.mapper;

import com.tico.tico.entities.SSD;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SSDMapper {
    List<SSD> getAll();

    SSD getSSDByName(String name);
    List<SSD> getSSDLikeBrand(String brand);
    List<SSD> getSSDLikeType(String type);
    List<SSD> getSSDLikeBrandAndType(@Param("brand") String brand,@Param("type") String type);
    List<SSD> searchSSD(String key);
}
