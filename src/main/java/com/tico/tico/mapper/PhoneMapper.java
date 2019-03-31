package com.tico.tico.mapper;

import com.tico.tico.entities.Phone;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PhoneMapper {
    List<Phone> getAll();
}
