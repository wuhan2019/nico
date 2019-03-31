package com.tico.tico.mapper;

import com.tico.tico.entities.Comment2Phone;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Comment2PhoneMapper {
    List<Comment2Phone> getAll();
}
