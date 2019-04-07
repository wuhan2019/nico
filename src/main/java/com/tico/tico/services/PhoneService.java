package com.tico.tico.services;

import com.tico.tico.entities.Phone;
import com.tico.tico.mapper.PhoneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    @Autowired
    PhoneMapper phoneMapper;
    public List<Phone> getAll(){
        return phoneMapper.getAll();
    }
    //通过phone_name,得到手机所有信息
    public Phone getPhoneByName(String name){
        return phoneMapper.getPhoneByName(name);
    }
    //通过手机brand获取手机
    public List<Phone> getPhonesLikeBrand(String brand){
        return phoneMapper.getPhonesLikeBrand(brand);
    }
    //通过手机type获取手机
    public List<Phone> getPhonesLikeType(String type){
        return phoneMapper.getPhonesLikeType(type);
    }
    //通过手机brand和type获取手机
    public List<Phone> getPhonesLikeBrandAndType(String brand,String type){
        return phoneMapper.getPhonesLikeBrandAndType(brand,type);
    }
    //搜索手机
    public List<Phone> searchPhone(String key){
        return phoneMapper.searchPhone(key);
    }
}
