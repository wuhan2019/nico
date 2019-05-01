package com.tico.tico.controllers;

import com.tico.tico.entities.GPU;
import com.tico.tico.services.GPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/getGpuByName/{gpu_name}")
    public String getGpuByName(@PathVariable("gpu_name") String name,
                                 Model model)
    {
        GPU gpu = gpuService.getGpuByName(name);
        model.addAttribute("gpu",gpu);
        return "/success";
    }

    @GetMapping("/ getGPULikeBrand/{key}")
    public String getGPULikeBrand(@PathVariable("key")String key,
                                  Model model)
    {
        List<GPU> gpus = gpuService.getGPULikeBrand(key);
        if(gpus!=null)
            model.addAttribute("gpusByBrand",gpus);
        else
            model.addAttribute("gpusByBrand"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getGPULikeType/{key}")
    public String getGPULikeType(@PathVariable("key")String key,
                                  Model model)
    {
        List<GPU> gpus = gpuService.getGPULikeType(key);
        if(gpus!=null)
            model.addAttribute("gpusByType",gpus);
        else
            model.addAttribute("gpusByType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getGPULikeBrandAndType/{brand}/{type}")
    public String getGPULikeBrandAndType(@PathVariable("brand") String brand,
                                            @PathVariable("type") String type,
                                            Model model)
    {
        List<GPU> gpus = gpuService.getGPULikeBrandAndType(brand,type);
        if(gpus!=null)
            model.addAttribute("gpusByBrandAndType",gpus);
        else
            model.addAttribute("gpusByBrandAndType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/searchGPU/{key}")
    public String searchGPU(@PathVariable("key") String key,
                              Model model){
        List<GPU> gpus = gpuService.searchGPU(key);
        if(gpus!=null){
            model.addAttribute("searchGPU",gpus);
        }else{
            model.addAttribute("searchGPU"
                    ,"找不到您要的商品！");
        }
        return "/success";
    }
}
