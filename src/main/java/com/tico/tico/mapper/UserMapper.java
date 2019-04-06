package com.tico.tico.mapper;

import com.tico.tico.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getAll();
    //通过user_name查找user_password
    String getPasswordByName(String name);
    //写入注册数据
    void putUser(@Param("user") User user);
}
