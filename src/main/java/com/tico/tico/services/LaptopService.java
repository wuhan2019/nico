package com.tico.tico.services;

import com.tico.tico.entities.Laptop;
import com.tico.tico.mapper.LaptopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {
    @Autowired
    LaptopMapper laptopMapper;
    public List<Laptop> getAll(){
        return laptopMapper.getAll();
    }
    public  Laptop getLaptopByName(String name){return laptopMapper.getLaptopByName(name);}
    public List<Laptop> getLaptopLikeBrand(String brand){return laptopMapper.getLaptopLikeBrand(brand);}
    public List<Laptop> getLaptopLikeType(String type){return  laptopMapper.getLaptopLikeType(type);}
    public  List<Laptop> getLaptopLikeBrandAndType( String brand, String type){return laptopMapper.getLaptopLikeBrandAndType(brand, type);}
    public List<Laptop> searchLaptop(String key){return laptopMapper.searchLaptop(key);}


}
