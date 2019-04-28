package com.tico.tico.mapper;

import com.tico.tico.entities.Headset;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface HeadsetMapper {
    List<Headset> getAll();

    Headset getHeadsetByName(String name);
    List<Headset> getHeadsetLikeBrand(String brand);
    List<Headset> getHeadsetLikeType(String type);
    List<Headset> getHeadsetLikeBrandAndType(@Param("brand") String brand, @Param("type") String type);
    List<Headset> searchHeadset(String key);
}
