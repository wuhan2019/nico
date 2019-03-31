package com.tico.tico.controllers;

import com.tico.tico.entities.Panel;
import com.tico.tico.services.PanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PanelController {
    @Autowired
    PanelService panelService;
    @ResponseBody
    @RequestMapping("/panel")
    public List<Panel> panel(){
        return panelService.getAll();
    }
}
