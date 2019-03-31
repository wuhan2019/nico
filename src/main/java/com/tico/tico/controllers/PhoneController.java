package com.tico.tico.controllers;

import com.tico.tico.entities.Phone;
import com.tico.tico.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PhoneController {
    @Autowired
    PhoneService phoneService;
    @ResponseBody
    @RequestMapping("/phone")
    public List<Phone> phone(){
        return phoneService.getAll();
    }
}
