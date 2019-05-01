package com.tico.tico.services;

import com.tico.tico.entities.Mouse;
import com.tico.tico.mapper.MouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MouseService {
    @Autowired
    MouseMapper mouseMapper;
    public List<Mouse> getAll(){
        return mouseMapper.getAll();
    }
    public Mouse getMouseByName(String name){return mouseMapper.getMouseByName(name);}
    public List<Mouse> getMouseLikeBrand(String brand){return mouseMapper.getMouseLikeBrand(brand);}
    public List<Mouse> getMouseLikeType(String type){return mouseMapper.getMouseLikeType(type);}
    public  List<Mouse> getMouseLikeBrandAndType( String brand,  String type){return mouseMapper.getMouseLikeBrandAndType(brand, type);}
    public  List<Mouse> searchMouse(String key){return mouseMapper.searchMouse(key);}
}
