package com.tico.tico.services;

import com.tico.tico.entities.Comment2Phone;
import com.tico.tico.mapper.Comment2PhoneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Comment2PhoneService {
    @Autowired
    Comment2PhoneMapper comment2PhoneMapper;
    public List<Comment2Phone> getAll(){
        return comment2PhoneMapper.getAll();
    }
    public List<Comment2Phone> getByName(String name){
        return comment2PhoneMapper.getByName(name);
    }
    public Double price_mark(String name){
        Double result = 0.0;
        if(comment2PhoneMapper.price_mark(name)!=null){
            result = comment2PhoneMapper.price_mark(name);
        }
        return result;
    }
    public Double screen_mark(String name){
        Double result = 0.0;
        if(comment2PhoneMapper.screen_mark(name)!=null){
            result = comment2PhoneMapper.screen_mark(name);
        }
        return result;
    }
    public Double fluency_mark(String name){
        Double result = 0.0;
        if(comment2PhoneMapper.fluency_mark(name)!=null){
            result = comment2PhoneMapper.fluency_mark(name);
        }
        return result;
    }
    public Double battery_mark(String name){
        Double result = 0.0;
        if(comment2PhoneMapper.battery_mark(name)!=null){
            result = comment2PhoneMapper.battery_mark(name);
        }
        return result;
    }
    public Double camera_mark(String name){
        Double result = 0.0;
        if(comment2PhoneMapper.camera_mark(name)!=null){
            result = comment2PhoneMapper.camera_mark(name);
        }
        return result;
    }

    public void addPhoneComment(Comment2Phone comment2Phone){
        comment2PhoneMapper.addPhoneComment(comment2Phone);
    }
}
