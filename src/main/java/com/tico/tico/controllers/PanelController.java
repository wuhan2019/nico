package com.tico.tico.controllers;


import com.tico.tico.entities.Comment2Panel;
import com.tico.tico.entities.Comment2Phone;
import com.tico.tico.entities.Panel;
import com.tico.tico.services.Comment2PanelService;
import com.tico.tico.services.PanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class PanelController {
    @Autowired
    PanelService panelService;
    @Autowired
    Comment2PanelService comment2PanelService;
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
       List<Comment2Panel> panelComments = comment2PanelService.getByName(name);
        double price_mark = comment2PanelService.price_mark(name);
        double screen_mark = comment2PanelService.screen_mark(name);
        double workspeed_mark = comment2PanelService.workspeed_mark(name);
        double battery_mark = comment2PanelService.battery_mark(name);
        double appearance_mark = comment2PanelService .appearance_mark(name);
        model.addAttribute("panelComments",panelComments);
        model.addAttribute("workspeed_mark",workspeed_mark);
        model.addAttribute("price_mark",price_mark);
        model.addAttribute("screen_mark",screen_mark);
        model.addAttribute("fluency_mark",appearance_mark);
        model.addAttribute("battery_mark",battery_mark);
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


    //来到新增评论
    @GetMapping("/addPanelComment/{panel_name}")
    public String addPhoneComment(@PathVariable("panel_name") String panel_name,Model model){
        //把要评论的手机先存起来
        model.addAttribute("panel_name",panel_name);
        //去填写评论信息页面
        return "/success";
    }
    //把评论信息打包发到数据库
    @PostMapping("/newPanelComment")
    public String newPanelComment(@RequestParam("comment_panel_context") String comment_panel_context,
                                  @RequestParam("comment_panel_price_mark") Double comment_panel_price_mark,
                                  @RequestParam("comment_panel_screen_mark") Double comment_panel_screen_mark,
                                  @RequestParam("comment_panel_workspeed_mark") Double comment_panel_workspeed_mark,
                                  @RequestParam("comment_panel_battery_mark") Double comment_panel_battery_mark,
                                  @RequestParam("comment_panel_camera_mark") Double comment_panel_camera_mark,
                                  @RequestParam("comment_panel_commentby") String comment_panel_commentby,
                                  HttpServletRequest request){

        String comment_phone_commentor = (String) request.getSession().getAttribute("user_name");
        Date comment_phone_time = new Date();
        Comment2Panel comment2Panel = new Comment2Panel(comment_phone_commentor,
                comment_panel_commentby,comment_phone_time,comment_panel_context,comment_panel_price_mark,
                comment_panel_screen_mark,comment_panel_workspeed_mark,comment_panel_battery_mark,
                comment_panel_camera_mark);
        //插入数据库，注意 ： 评论表中的coment_phode_replyto_name不要了。
        comment2PanelService.addPanelComment(comment2Panel);
        return "/success";
    }

}
