package com.tico.tico.mapper;

import com.tico.tico.entities.Comment2Phone;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Comment2PhoneMapper {
    List<Comment2Phone> getAll();
    //通过手机name找到关于该手机的所有评论信息
    List<Comment2Phone> getByName(String name);
    //平均值
    double price_mark(String name);
    double screen_mark(String name);
    double fluency_mark(String name);
    double battery_mark(String name);
    double camera_mark(String name);
}
