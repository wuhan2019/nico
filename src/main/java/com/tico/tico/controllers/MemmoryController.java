package com.tico.tico.controllers;


import com.tico.tico.entities.Memmory;
import com.tico.tico.services.MemmoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemmoryController {
    @Autowired
    MemmoryService memmoryService;
    @ResponseBody
    @RequestMapping("/memmory")
    public List<Memmory> memmory(){
        return memmoryService.getAll();
    }

    @GetMapping("/getMemmoryByName/{memmory_name}")
    public String getMemmoryByName(@PathVariable("memmory_name") String name,
                               Model model)
    {
        Memmory memmory = memmoryService.getMemmoryByName(name);
        model.addAttribute("memmory",memmory);
        return "/success";
    }

    @GetMapping("/ getMemmoryLikeBrand/{key}")
    public String getMemmoryLikeBrand(@PathVariable("key")String key,
                                  Model model)
    {
        List<Memmory> memmories = memmoryService.getMemmoryLikeBrand(key);
        if(memmories!=null)
            model.addAttribute("memmoriesByBrand",memmories);
        else
            model.addAttribute("memmoriesByBrand"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getMemmoryLikeType/{key}")
    public String getMemmoryLikeType(@PathVariable("key")String key,
                                 Model model)
    {
        List<Memmory> memmories = memmoryService.getMemmoryLikeType(key);
        if(memmories!=null)
            model.addAttribute("memmoriesByType",memmories);
        else
            model.addAttribute("memmoriesByType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getMemmoryLikeBrandAndType/{brand}/{type}")
    public String getMemmoryLikeBrandAndType(@PathVariable("brand") String brand,
                                         @PathVariable("type") String type,
                                         Model model)
    {
        List<Memmory> memmories = memmoryService.getMemmoryLikeBrandAndType(brand, type);
        if(memmories!=null)
            model.addAttribute("memmoriesByBrandAndType",memmories);
        else
            model.addAttribute("memmoriesByBrandAndType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/searchMemmory/{key}")
    public String searchMemmory(@PathVariable("key") String key,
                            Model model){
        List<Memmory> memmories = memmoryService.searchMemmory(key);
        if(memmories!=null){
            model.addAttribute("searchMemmory",memmories);
        }else{
            model.addAttribute("searchMemmory"
                    ,"找不到您要的商品！");
        }
        return "/success";
    }
}
