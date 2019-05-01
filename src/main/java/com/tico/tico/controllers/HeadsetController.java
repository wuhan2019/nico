package com.tico.tico.controllers;

import com.tico.tico.entities.Headset;
import com.tico.tico.services.HeadsetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/getHeadsetByName/{headset_name}")
    public String getGpuByName(@PathVariable("headset_name") String name,
                               Model model)
    {
        Headset headset = headsetService.getHeadsetByName(name);
        model.addAttribute("headset",headset);
        return "/success";
    }

    @GetMapping("/getHeadsetLikeBrand/{key}")
    public String getHeadsetLikeBrand(@PathVariable("key")String key,
                                  Model model)
    {
        List<Headset> headsets = headsetService.getHeadsetLikeBrand(key);
        if(headsets!=null)
            model.addAttribute("headsetsByBrand",headsets);
        else
            model.addAttribute("headsetsByBrand"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getHeadsetLikeType/{key}")
    public String getHeadsetLikeType(@PathVariable("key")String key,
                                      Model model)
    {
        List<Headset> headsets = headsetService.getHeadsetLikeType(key);
        if(headsets!=null)
            model.addAttribute("headsetsByType",headsets);
        else
            model.addAttribute("headsetsByType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }


    @GetMapping("/getHeadsetLikeBrandAndType/{brand}/{type}")
    public String getHeadsetLikeBrandAndType(@PathVariable("brand") String brand,
                                             @PathVariable("type") String type,
                                     Model model)
    {
        List<Headset> headsets = headsetService.getHeadsetLikeBrandAndType(brand, type);
        if(headsets!=null)
            model.addAttribute("headsetsByBrandAndType",headsets);
        else
            model.addAttribute("headsetsByBrandAndType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }


    @GetMapping("/searchHeadset/{key}")
    public String searchGPU(@PathVariable("key") String key,
                            Model model){
        List<Headset> headsets = headsetService.searchHeadset(key);
        if(headsets!=null){
            model.addAttribute("searchHeadset",headsets);
        }else{
            model.addAttribute("searchHeadset"
                    ,"找不到您要的商品！");
        }
        return "/success";
    }
}
