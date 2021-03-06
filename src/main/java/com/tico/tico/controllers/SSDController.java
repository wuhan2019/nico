package com.tico.tico.controllers;


import com.tico.tico.entities.Comment2Laptop;
import com.tico.tico.entities.Comment2Panel;
import com.tico.tico.entities.Comment2Peripheral;
import com.tico.tico.entities.SSD;
import com.tico.tico.services.Comment2PeripheralService;
import com.tico.tico.services.SSDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class SSDController {
    @Autowired
    SSDService ssdService;
    @Autowired
    Comment2PeripheralService comment2PeripheralService;
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
        List<Comment2Peripheral> panelComments = comment2PeripheralService.getByName(name);
        double mark = comment2PeripheralService.mark(name);
        model.addAttribute("mark",mark);
        model.addAttribute("comment2Peripheral",panelComments);
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

    //来到新增评论
    @GetMapping("/addSSDComment/{SSD_name}")
    public String addSSDComment(@PathVariable("SSD_name") String SSD_name,Model model){
        //把要评论的手机先存起来
        model.addAttribute("SSD_name",SSD_name);
        //去填写评论信息页面
        return "/success";
    }
    //把评论信息打包发到数据库
    @PostMapping("/newSSDComment")
    public String newSSDComment(@RequestParam("comment_peripheral_context") String comment_peripheral_context,
                                   @RequestParam("comment_peripheral_mark") Double comment_peripheral_mark,
                                   @RequestParam("comment_peripheral_commentby") String comment_peripheral_commentby,
                                   HttpServletRequest request){

        String comment_peripheral_commentor = (String) request.getSession().getAttribute("user_name");
        Date comment_peripheral_time = new Date();
        Comment2Peripheral comment2Peripheral = new Comment2Peripheral(comment_peripheral_commentor,comment_peripheral_commentby,comment_peripheral_time,comment_peripheral_context,comment_peripheral_mark);
        //插入数据库，注意 ： 评论表中的coment_phode_replyto_name不要了。
        comment2PeripheralService.addPeripheralComment(comment2Peripheral);
        return "/success";
    }
}
