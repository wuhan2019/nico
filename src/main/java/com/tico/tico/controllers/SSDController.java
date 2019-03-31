package com.tico.tico.controllers;

import com.tico.tico.entities.SSD;
import com.tico.tico.services.SSDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SSDController {
    @Autowired
    SSDService ssdService;
    @ResponseBody
    @RequestMapping("/ssd")
    public List<SSD> ssd(){
        return ssdService.getAll();
    }
}
