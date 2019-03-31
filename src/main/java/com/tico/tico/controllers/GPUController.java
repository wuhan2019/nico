package com.tico.tico.controllers;

import com.tico.tico.entities.GPU;
import com.tico.tico.services.GPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GPUController {
    @Autowired
    GPUService gpuService;
    @ResponseBody
    @RequestMapping("/gpu")
    public List<GPU> gpu(){
        return gpuService.getAll();
    }
}
