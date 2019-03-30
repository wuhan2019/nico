package com.tico.tico.controllers;

import com.tico.tico.entities.User;
import com.tico.tico.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @ResponseBody
    @RequestMapping("/user")
    public List<User> user(){
        System.out.println(userService.getAll());
        return userService.getAll();
    }
}
