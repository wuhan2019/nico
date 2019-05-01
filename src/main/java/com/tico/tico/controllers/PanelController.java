package com.tico.tico.controllers;


import com.tico.tico.entities.Panel;
import com.tico.tico.services.PanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/getPanelByName/{panel_name}")
    public String getPanelByName(@PathVariable("panel_name") String name,
                               Model model)
    {
       Panel panel = panelService.getPanelByName(name);
        model.addAttribute("panel",panel);
        return "/success";
    }

    @GetMapping("/getPanelLikeBrand/{key}")
    public String getPanelLikeBrand(@PathVariable("key")String key,
                                  Model model)
    {
        List<Panel> panels = panelService.getPanelLikeBrand(key);
        if(panels!=null)
            model.addAttribute("panelsByBrand",panels);
        else
            model.addAttribute("panelsByBrand"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getPanelLikeType/{key}")
    public String getPanelLikeType(@PathVariable("key")String key,
                                 Model model)
    {
        List<Panel> panels = panelService.getPanelLikeType(key);
        if(panels!=null)
            model.addAttribute("panelsByType",panels);
        else
            model.addAttribute("panelsByType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getPanelLikeBrandAndType/{brand}/{type}")
    public String getPanelLikeBrandAndType(@PathVariable("brand") String brand,
                                         @PathVariable("type") String type,
                                         Model model)
    {
        List<Panel> panels = panelService.getPanelLikeBrandAndType(brand, type);
        if(panels!=null)
            model.addAttribute("panelsByBrandAndType",panels);
        else
            model.addAttribute("panelsByBrandAndType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/searchPanel/{key}")
    public String searchPanel(@PathVariable("key") String key,
                            Model model){
        List<Panel> panels = panelService.searchPanel(key);
        if(panels!=null){
            model.addAttribute("searchPanel",panels);
        }else{
            model.addAttribute("searchPanel"
                    ,"找不到您要的商品！");
        }
        return "/success";
    }
}
