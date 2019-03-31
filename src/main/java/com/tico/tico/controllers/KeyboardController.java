package com.tico.tico.controllers;

import com.tico.tico.entities.Keyboard;
import com.tico.tico.services.KeyboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class KeyboardController {
    @Autowired
    KeyboardService keyboardService;
    @ResponseBody
    @RequestMapping("/keyboard")
    public List<Keyboard> keyboard(){
        return keyboardService.getAll();
    }
}
