package com.tico.tico.mapper;

import com.tico.tico.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface UserMapper {
    List<User> getAll();
    //通过user_name查找user_password
    String getPasswordByName(String name);
    //写入注册数据
    void putUser(@Param("user") User user);
    //全局搜索商品，就像淘宝主页的搜索功能,这个key可以like name、type,返回商品的name
    List<String> search_globle(String key);

}
