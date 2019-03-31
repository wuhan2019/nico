package com.tico.tico.controllers;

import com.tico.tico.entities.Laptop;
import com.tico.tico.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LaptopController {
    @Autowired
    LaptopService laptopService;
    @ResponseBody
    @RequestMapping("/laptop")
    public List<Laptop> laptop(){
        return laptopService.getAll();
    }
}
