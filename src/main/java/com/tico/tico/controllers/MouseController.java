package com.tico.tico.controllers;


import com.tico.tico.entities.Mouse;
import com.tico.tico.services.MouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MouseController {
    @Autowired
    MouseService mouseService;
    @ResponseBody
    @RequestMapping("/mouse")
    public List<Mouse> mouse(){
        return mouseService.getAll();
    }

    @GetMapping("/getMouseByName/{mouse_name}")
    public String getMouseByName(@PathVariable("mouse_name") String name,
                               Model model)
    {
        Mouse mouse = mouseService.getMouseByName(name);
        model.addAttribute("mouse",mouse);
        return "/success";
    }

    @GetMapping("/getMouseLikeBrand/{key}")
    public String getMouseLikeBrand(@PathVariable("key")String key,
                                  Model model)
    {
       List<Mouse> mouses = mouseService.getMouseLikeBrand(key);
        if(mouses!=null)
            model.addAttribute("mousesByBrand",mouses);
        else
            model.addAttribute("mousesByBrand"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getMouseLikeType/{key}")
    public String getMouseLikeType(@PathVariable("key")String key,
                                 Model model)
    {
        List<Mouse> mouses = mouseService.getMouseLikeType(key);
        if(mouses!=null)
            model.addAttribute("mousesByType",mouses);
        else
            model.addAttribute("mousesByType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getMouseLikeBrandAndType/{brand}/{type}")
    public String getMouseLikeBrandAndType(@PathVariable("brand") String brand,
                                         @PathVariable("type") String type,
                                         Model model)
    {
        List<Mouse> mouses = mouseService.getMouseLikeBrandAndType(brand, type);
        if(mouses!=null)
            model.addAttribute("mousesByBrandAndType",mouses);
        else
            model.addAttribute("mousesByBrandAndType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/searchMouse/{key}")
    public String searchMouse(@PathVariable("key") String key,
                            Model model){
        List<Mouse> mouses = mouseService.searchMouse(key);
        if(mouses!=null){
            model.addAttribute("searchMouse",mouses);
        }else{
            model.addAttribute("searchMouse"
                    ,"找不到您要的商品！");
        }
        return "/success";
    }
}
