package com.tico.tico.controllers;

import com.tico.tico.entities.Comment2Laptop;
import com.tico.tico.services.Comment2LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Comment2LaptopController {
    @Autowired
    Comment2LaptopService comment2LaptopService;
    @ResponseBody
    @RequestMapping("/comment2laptop")
    public List<Comment2Laptop> comment2Laptop(){
        return comment2LaptopService.getAll();
    }
}
