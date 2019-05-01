package com.tico.tico.controllers;


import com.tico.tico.entities.SSD;
import com.tico.tico.services.SSDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/getSSDByName/{ssd_name}")
    public String getSSDByName(@PathVariable("ssd_name") String name,
                               Model model)
    {
        SSD ssd = ssdService.getSSDByName(name);
        model.addAttribute("ssd",ssd);
        return "/success";
    }

    @GetMapping("/getSSDLikeBrand/{key}")
    public String getSSDLikeBrand(@PathVariable("key")String key,
                                  Model model)
    {
       List<SSD> ssds = ssdService.getSSDLikeBrand(key);
        if(ssds!=null)
            model.addAttribute("ssdsByBrand",ssds);
        else
            model.addAttribute("ssdsByBrand"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getSSDLikeType/{key}")
    public String getSSDLikeType(@PathVariable("key")String key,
                                 Model model)
    {
        List<SSD> ssds = ssdService.getSSDLikeType(key);
        if(ssds!=null)
            model.addAttribute("ssdsByType",ssds);
        else
            model.addAttribute("ssdsByType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getSSDLikeBrandAndType/{brand}/{type}")
    public String getSSDLikeBrandAndType(@PathVariable("brand") String brand,
                                         @PathVariable("type") String type,
                                         Model model)
    {
        List<SSD> ssds = ssdService.getSSDLikeBrandAndType(brand, type);
        if(ssds!=null)
            model.addAttribute("ssdsByBrandAndType",ssds);
        else
            model.addAttribute("ssdsByBrandAndType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/searchSSD/{key}")
    public String searchSSD(@PathVariable("key") String key,
                            Model model){
        List<SSD> ssds = ssdService.searchSSD("key");
        if(ssds!=null){
            model.addAttribute("searchSSD",ssds);
        }else{
            model.addAttribute("searchSSD"
                    ,"找不到您要的商品！");
        }
        return "/success";
    }
}
