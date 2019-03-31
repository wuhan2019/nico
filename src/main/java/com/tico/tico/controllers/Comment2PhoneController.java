package com.tico.tico.controllers;

import com.tico.tico.entities.Comment2Phone;
import com.tico.tico.services.Comment2PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Comment2PhoneController {
    @Autowired
    Comment2PhoneService comment2PhoneService;
    @ResponseBody
    @RequestMapping("/comment2phone")
    public List<Comment2Phone> comment2Phone(){
        return comment2PhoneService.getAll();
    }
}
