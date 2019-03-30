package com.tico.tico.mapper;

import com.tico.tico.entities.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getAll();
}
