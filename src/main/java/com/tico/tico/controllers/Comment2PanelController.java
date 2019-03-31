package com.tico.tico.controllers;

import com.tico.tico.entities.Comment2Panel;
import com.tico.tico.services.Comment2PanelService;
import com.tico.tico.services.Comment2PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Comment2PanelController {
    @Autowired
    Comment2PanelService comment2PanelService;
    @ResponseBody
    @RequestMapping("/comment2panel")
    public List<Comment2Panel> comment2Panel(){
        return comment2PanelService.getAll();
    }
}
