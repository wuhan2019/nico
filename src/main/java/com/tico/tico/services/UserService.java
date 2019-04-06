package com.tico.tico.services;

import com.tico.tico.entities.User;
import com.tico.tico.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public List<User> getAll(){
        return userMapper.getAll();
    }
    public String getPasswordByName(String name){
        return userMapper.getPasswordByName(name);
    }
    public void putUser(User user){
        userMapper.putUser(user);
    }
}
