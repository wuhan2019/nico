package com.tico.tico.services;

import com.tico.tico.entities.Memmory;
import com.tico.tico.mapper.MemmoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemmoryService {
    @Autowired
    MemmoryMapper memmoryMapper;
    public List<Memmory> getAll(){
        return memmoryMapper.getAll();
    }
    public Memmory getMemmoryByName(String name){return memmoryMapper.getMemmoryByName(name);}
    public List<Memmory> getMemmoryLikeBrand(String brand){return memmoryMapper.getMemmoryLikeBrand(brand);}
    public List<Memmory> getMemmoryLikeType(String type){return memmoryMapper.getMemmoryLikeType(type);}
    public List<Memmory> getMemmoryLikeBrandAndType( String brand, String type){return memmoryMapper.getMemmoryLikeBrandAndType(brand, type);}
    public List<Memmory> searchMemmory(String key){return memmoryMapper.searchMemmory(key);}



}
