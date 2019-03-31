package com.tico.tico.controllers;

import com.tico.tico.entities.Mouse;
import com.tico.tico.services.MouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MouseController {
    @Autowired
    MouseService mouseService;
    @ResponseBody
    @RequestMapping("/mouse")
    public List<Mouse> mouse(){
        return mouseService.getAll();
    }
}
