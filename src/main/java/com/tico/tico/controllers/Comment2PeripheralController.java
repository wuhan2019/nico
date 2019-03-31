package com.tico.tico.controllers;

import com.tico.tico.entities.Comment2Peripheral;
import com.tico.tico.services.Comment2PeripheralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Comment2PeripheralController {
    @Autowired
    Comment2PeripheralService comment2PeripheralService;
    @ResponseBody
    @RequestMapping("/comment2peripheral")
    public List<Comment2Peripheral> comment2Peripheral(){
        return comment2PeripheralService.getAll();
    }
}
