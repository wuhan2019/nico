package com.tico.tico.controllers;


import com.tico.tico.entities.Comment2Peripheral;
import com.tico.tico.entities.Memmory;
import com.tico.tico.services.Comment2PeripheralService;
import com.tico.tico.services.MemmoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class MemmoryController {
    @Autowired
    MemmoryService memmoryService;
    @Autowired
    Comment2PeripheralService comment2PeripheralService;
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
        List<Comment2Peripheral> panelComments = comment2PeripheralService.getByName(name);
        double mark = comment2PeripheralService.mark(name);
        model.addAttribute("mark",mark);
        model.addAttribute("comment2Peripheral",panelComments);
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

    //来到新增评论
    @GetMapping("/addMemmoryComment/{Memmory_name}")
    public String addMemmoryComment(@PathVariable("Memmory_name") String Memmory_name,Model model){
        //把要评论的手机先存起来
        model.addAttribute("SSD_name",Memmory_name);
        //去填写评论信息页面
        return "/success";
    }
    //把评论信息打包发到数据库
    @PostMapping("/newMemmoryComment")
    public String newMemmoryComment(@RequestParam("comment_peripheral_context") String comment_peripheral_context,
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
