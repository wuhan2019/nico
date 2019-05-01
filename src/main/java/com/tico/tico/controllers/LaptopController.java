package com.tico.tico.controllers;


import com.tico.tico.entities.Laptop;
import com.tico.tico.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LaptopController {
    @Autowired
    LaptopService laptopService;
    @ResponseBody
    @RequestMapping("/laptop")
    public List<Laptop> laptop(){
        return laptopService.getAll();
    }


    @GetMapping("/getLaptopByName/{laptop_name}")
    public String getLaptopByName(@PathVariable("laptop_name") String name,
                               Model model)
    {
        Laptop laptop = laptopService.getLaptopByName(name);
        model.addAttribute("laptop",laptop);
        return "/success";
    }

    @GetMapping("/ getLaptopLikeBrand/{key}")
    public String getLaptopLikeBrand(@PathVariable("key")String key,
                                  Model model)
    {
       List<Laptop> laptops = laptopService.getLaptopLikeBrand(key);
        if(laptops!=null)
            model.addAttribute("laptopsByBrand",laptops);
        else
            model.addAttribute("laptopsByBrand"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getLaptopLikeType/{key}")
    public String getLaptopLikeType(@PathVariable("key")String key,
                                 Model model)
    {
        List<Laptop> laptops = laptopService.getLaptopLikeType(key);
        if(laptops!=null)
            model.addAttribute("laptopsByType",laptops);
        else
            model.addAttribute("laptopsByType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getLaptopLikeBrandAndType/{brand}/{type}")
    public String getLaptopLikeBrandAndType(@PathVariable("brand") String brand,
                                         @PathVariable("type") String type,
                                         Model model)
    {
        List<Laptop> laptops = laptopService.getLaptopLikeBrandAndType(brand, type);
        if(laptops!=null)
            model.addAttribute("laptopsByBrandAndType",laptops);
        else
            model.addAttribute("laptopsByBrandAndType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/searchLaptop/{key}")
    public String searchLaptop(@PathVariable("key") String key,
                            Model model){
        List<Laptop> laptops = laptopService.searchLaptop(key);
        if(laptops!=null){
            model.addAttribute("searchLaptop",laptops);
        }else{
            model.addAttribute("searchLaptop"
                    ,"找不到您要的商品！");
        }
        return "/success";
    }
}
