package com.tico.tico.services;

import com.tico.tico.entities.SSD;
import com.tico.tico.mapper.SSDMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SSDService {
    @Autowired
    SSDMapper ssdMapper;
    public List<SSD> getAll(){
        return ssdMapper.getAll();
    }

    public SSD getSSDByName(String name){return ssdMapper.getSSDByName(name);}
    public  List<SSD> getSSDLikeBrand(String brand){return ssdMapper.getSSDLikeBrand(brand);}
    public  List<SSD> getSSDLikeType(String type){return ssdMapper.getSSDLikeType(type);}
    public  List<SSD> getSSDLikeBrandAndType( String brand, String type){return ssdMapper.getSSDLikeBrandAndType(brand, type);}
    public  List<SSD> searchSSD(String key){return ssdMapper.searchSSD(key);}
}
