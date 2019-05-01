package com.tico.tico.controllers;

import com.tico.tico.entities.Keyboard;
import com.tico.tico.services.KeyboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class KeyboardController {
    @Autowired
    KeyboardService keyboardService;
    @ResponseBody
    @RequestMapping("/keyboard")
    public List<Keyboard> keyboard(){
        return keyboardService.getAll();
    }

    @GetMapping("/getKeyboardByName/{keyboard_name}")
    public String getKeyboardByName(@PathVariable("keyboard_name") String name,
                               Model model)
    {
        Keyboard keyboard = keyboardService.getKeyboardByName(name);
        model.addAttribute("keyboard",keyboard);
        return "/success";
    }

    @GetMapping("/ getKeyboardLikeBrand/{key}")
    public String getKeyboardLikeBrand(@PathVariable("key")String key,
                                  Model model)
    {
       List<Keyboard> keyboards = keyboardService.getKeyboardLikeBrand(key);
        if(keyboards!=null)
            model.addAttribute("keyboardsByBrand",keyboards);
        else
            model.addAttribute("keyboardsByBrand"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getKeyboardLikeType/{key}")
    public String getKeyboardLikeType(@PathVariable("key")String key,
                                 Model model)
    {
        List<Keyboard> keyboards = keyboardService.getKeyboardLikeType(key);
        if(keyboards!=null)
            model.addAttribute("keyboardsByType",keyboards);
        else
            model.addAttribute("keyboardsByType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getKeyboardLikeBrandAndType/{brand}/{type}")
    public String getKeyboardLikeBrandAndType(@PathVariable("brand") String brand,
                                         @PathVariable("type") String type,
                                         Model model)
    {
        List<Keyboard> keyboards = keyboardService.getKeyboardLikeBrandAndType(brand, type);
        if(keyboards!=null)
            model.addAttribute("keyboardsByBrandAndType",keyboards);
        else
            model.addAttribute("keyboardsByBrandAndType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/searchKeyboard/{key}")
    public String searchKeyboard(@PathVariable("key") String key,
                            Model model){
        List<Keyboard> keyboards = keyboardService.searchKeyboard(key);
        if(keyboards!=null){
            model.addAttribute("searchKeyboard",keyboards);
        }else{
            model.addAttribute("searchKeyboard"
                    ,"找不到您要的商品！");
        }
        return "/success";
    }
}
