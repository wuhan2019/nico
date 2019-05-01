package com.tico.tico.services;

import com.tico.tico.entities.Headset;
import com.tico.tico.mapper.HeadsetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadsetService {
    @Autowired
    HeadsetMapper headsetMapper;
    public List<Headset> getAll(){
        return headsetMapper.getAll();
    }
    public Headset getHeadsetByName(String name){return headsetMapper.getHeadsetByName(name);}
    public List<Headset> getHeadsetLikeBrand(String brand){return headsetMapper.getHeadsetLikeBrand(brand);}
    public  List<Headset> getHeadsetLikeType(String type){return  headsetMapper.getHeadsetLikeType(type);}
    public  List<Headset> getHeadsetLikeBrandAndType( String brand, String type){return headsetMapper.getHeadsetLikeBrandAndType(brand,type);}
    public  List<Headset> searchHeadset(String key){return headsetMapper.searchHeadset(key);}

}
