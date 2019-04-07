package com.tico.tico.controllers;

import com.tico.tico.entities.Comment2Phone;
import com.tico.tico.entities.Phone;
import com.tico.tico.services.Comment2PhoneService;
import com.tico.tico.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PhoneController {
    @Autowired
    PhoneService phoneService;
    @Autowired
    Comment2PhoneService comment2PhoneService;
    @ResponseBody
    @RequestMapping("/phone")
    public List<Phone> phone(){
        return phoneService.getAll();
    }

    //通过phone_name获取该手机所有信息，包括评论信息
    //把href="/getPhoneByName/phone_name"就行了
    @GetMapping("/getPhoneByName/{phone_name}")
    public String getPhoneByName(@PathVariable("phone_name") String name,
                                 Model model){


        Phone phone = phoneService.getPhoneByName(name);
        //添加评论信息
        List<Comment2Phone> phoneComments = comment2PhoneService.getByName(name);
        //求出，评论里的评分的平均值，求完了放到model里
        double price_mark = comment2PhoneService.price_mark(name);
        double screen_mark = comment2PhoneService.screen_mark(name);
        double fluency_mark = comment2PhoneService.fluency_mark(name);
        double battery_mark = comment2PhoneService.battery_mark(name);
        double camera_mark = comment2PhoneService.camera_mark(name);
        model.addAttribute("phone",phone);
        model.addAttribute("phoneComments",phoneComments);
        model.addAttribute("price_mark",price_mark);
        model.addAttribute("screen_mark",screen_mark);
        model.addAttribute("fluency_mark",fluency_mark);
        model.addAttribute("battery_mark",battery_mark);
        model.addAttribute("camera_mark",camera_mark);
        return "/success";
    }

    //我们按照两个标准筛选手机，“品牌”“类型”
    @GetMapping("/getPhonesLikeBrand/{key}")
    public String getPhonesLikeBrand(@PathVariable("key")String key,
                                    Model model){
        List<Phone> phones = phoneService.getPhonesLikeBrand(key);
        if(phones!=null)
            model.addAttribute("phonesByBrand",phones);
        else
            model.addAttribute("phonesByBrand"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }
    @GetMapping("/getPhonesLikeType/{key}")
    public String getPhonesLikeType(@PathVariable("key") String key,
                                    Model model){
        List<Phone> phones = phoneService.getPhonesLikeType(key);
        if(phones!=null)
            model.addAttribute("phonesByType",phones);
        else
            model.addAttribute("phonesByType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }
    @GetMapping("/getPhonesLikeBrandAndType/{brand}/{type}")
    public String getPhonesLikeBrandAndType(@PathVariable("brand") String brand,
                                            @PathVariable("type") String type,
                                            Model model){
        List<Phone> phones = phoneService.getPhonesLikeBrandAndType(brand,type);
        if(phones!=null)
            model.addAttribute("phonesByBrandAndType",phones);
        else
            model.addAttribute("phonesByBrandAndType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    //通过关键词检索手机
    @GetMapping("/searchPhone/{key}")
    public String searchPhone(@PathVariable("key") String key,
                              Model model){
        List<Phone> phones = phoneService.searchPhone(key);
        if(phones!=null){
            model.addAttribute("searchPhone",phones);
        }else{
            model.addAttribute("searchPhone"
                    ,"找不到您要的商品！");
        }
        return "/success";
    }

    //把指定的商品加入对比队列
    @GetMapping("addToCompare/{name}")
    public String addToCompare(@PathVariable("name") String name,
                               HttpServletRequest request){
        List<String> phoneList = (List<String>) request.getSession().getAttribute("phoneList");
        phoneList.add(name);
        return "/success";
    }
    //进行对比
    @GetMapping("/phoneCompare")
    public String phoneCompare(HttpServletRequest request,Model model){
        List<String> phoneList = (List<String>) request.getSession().getAttribute("phoneList");
        List<Phone> result = new ArrayList<>();
        if(phoneList.size()<=1){
            model.addAttribute("phoneCompare","请选择两个以上的商品");
        }else{
            for(String name:phoneList){
                result.add(phoneService.getPhoneByName(name));
            }
            model.addAttribute("phoneCompare",result);
        }

        return "/success";
    }
}
