package com.tico.tico.controllers;

import com.tico.tico.entities.Headset;
import com.tico.tico.services.HeadsetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HeadsetController {
    @Autowired
    HeadsetService headsetService;
    @ResponseBody
    @RequestMapping("/headset")
    public List<Headset> headset(){
        return headsetService.getAll();
    }
}
