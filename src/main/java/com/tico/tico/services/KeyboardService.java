package com.tico.tico.services;

import com.tico.tico.entities.Keyboard;
import com.tico.tico.mapper.KeyboardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyboardService {
    @Autowired
    KeyboardMapper keyboardMapper;
    public List<Keyboard> getAll(){
        return keyboardMapper.getAll();
    }
    public Keyboard getKeyboardByName(String name){return keyboardMapper.getKeyboardByName(name);}
    public List<Keyboard> getKeyboardLikeBrand(String brand){return keyboardMapper.getKeyboardLikeBrand(brand);}
    public  List<Keyboard> getKeyboardLikeType(String type){return keyboardMapper.getKeyboardLikeType(type);}
    public  List<Keyboard> getKeyboardLikeBrandAndType( String brand,  String type){return keyboardMapper.getKeyboardLikeBrandAndType(brand, type);}
    public List<Keyboard> searchKeyboard(String key){return keyboardMapper.searchKeyboard(key);}


}
