package com.tico.tico.controllers;

import com.tico.tico.entities.Memmory;
import com.tico.tico.services.MemmoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemmoryController {
    @Autowired
    MemmoryService memmoryService;
    @ResponseBody
    @RequestMapping("/memmory")
    public List<Memmory> memmory(){
        return memmoryService.getAll();
    }
}
