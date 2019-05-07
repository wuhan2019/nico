package com.tico.tico.controllers;

import com.tico.tico.entities.Comment2Peripheral;
import com.tico.tico.entities.Headset;
import com.tico.tico.services.Comment2PeripheralService;
import com.tico.tico.services.HeadsetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class HeadsetController {
    @Autowired
    HeadsetService headsetService;
    @Autowired
    Comment2PeripheralService comment2PeripheralService;
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
        List<Comment2Peripheral> panelComments = comment2PeripheralService.getByName(name);
        double mark = comment2PeripheralService.mark(name);
        model.addAttribute("mark",mark);
        model.addAttribute("comment2Peripheral",panelComments);
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

    //来到新增评论
    @GetMapping("/addHeadsetComment/{Headset_name}")
    public String addHeadsetComment(@PathVariable("Headset_name") String Headset_name,Model model){
        //把要评论的手机先存起来
        model.addAttribute("Headset_name",Headset_name);
        //去填写评论信息页面
        return "/success";
    }
    //把评论信息打包发到数据库
    @PostMapping("/newHeadsetComment")
    public String newHeadsetComment(@RequestParam("comment_peripheral_context") String comment_peripheral_context,
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
