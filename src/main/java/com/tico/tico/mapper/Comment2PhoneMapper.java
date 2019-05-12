package com.tico.tico.mapper;

import com.tico.tico.entities.Comment2Phone;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface Comment2PhoneMapper {
    List<Comment2Phone> getAll();
    //通过手机name找到关于该手机的所有评论信息
    List<Comment2Phone> getByName(String name);
    //平均值
    Double price_mark(String name);
    Double screen_mark(String name);
    Double fluency_mark(String name);
    Double battery_mark(String name);
    Double camera_mark(String name);
    //插入一条评论
    void addPhoneComment(@Param("phoneComment")Comment2Phone phoneComment);
}
