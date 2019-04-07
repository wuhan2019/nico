package com.tico.tico.mapper;

import com.tico.tico.entities.Phone;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PhoneMapper {
    //所有手机
    List<Phone> getAll();
    //通过手机name获取手机所有信息
    Phone getPhoneByName(String name);
    //通过手机brand获取手机
    List<Phone> getPhonesLikeBrand(String brand);
    //通过手机type获取手机
    List<Phone> getPhonesLikeType(String type);
    //通过手机brand和type获取手机
    List<Phone> getPhonesLikeBrandAndType(@Param("brand") String brand, @Param("type") String type);
    //通过关键词查找相关的手机
    List<Phone> searchPhone(String key);
}
