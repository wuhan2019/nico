package com.tico.tico.controllers;

import com.tico.tico.entities.Comment2Phone;
import com.tico.tico.entities.Phone;
import com.tico.tico.services.Comment2PhoneService;
import com.tico.tico.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PhoneController {
    @Autowired
    PhoneService phoneService;
    @Autowired
    Comment2PhoneService comment2PhoneService;

    @RequestMapping("/phone")
    public String phone(Model model){
        List<Phone> phones = phoneService.getAll();
        for (Phone phone:phones){
            phone.getPics();
        }
        model.addAttribute("phones",phones);
        return "/phone";
    }

    //通过phone_name获取该手机所有信息，包括评论信息
    //把href="/getPhoneByName/phone_name"就行了
    @GetMapping("/getPhoneByName/{phone_name}")
    public String getPhoneByName(@PathVariable("phone_name") String name,
                                 Model model){


        Phone phone = phoneService.getPhoneByName(name);
        phone.getPics();
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
        return "/phoneDetails";
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
    @PostMapping("/searchPhone")
    public String searchPhone(@PathVariable("key") String key,
                              Model model){
        List<Phone> phones = phoneService.searchPhone(key);
        if(phones!=null){
            model.addAttribute("searchPhone",phones);
        }else{
            model.addAttribute("searchPhoneError"
                    ,"找不到您要的商品！");
        }
        return "/phoneSearch";
    }

    //把指定的商品加入对比队列
    @GetMapping("addToCompare/{name}")
    public String addToCompare(@PathVariable("name") String name,
                               Model model,HttpServletRequest request){
        List<String> phoneList = (List<String>) request.getSession().getAttribute("phoneList");
        phoneList.add(name);
        List<Phone> result = new ArrayList<>();
        for(String pname:phoneList){
            result.add(phoneService.getPhoneByName(pname));
        }
        model.addAttribute("phoneCompare",result);
        return "/compare";
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

    //来到新增评论
    @GetMapping("/addPhoneComment/{phone_name}")
    public String addPhoneComment(@PathVariable("phone_name") String phone_name,Model model){
        //把要评论的手机先存起来
        model.addAttribute("phone_name",phone_name);
        //去填写评论信息页面
        return "/success";
    }
    //把评论信息打包发到数据库
    @PostMapping("/newPhoneComment")
    public String newPhoneComment(@RequestParam("comment_phone_context") String comment_phone_context,
                                  @RequestParam("comment_phone_price_mark") Double comment_phone_price_mark,
                                  @RequestParam("comment_phone_screen_mark") Double comment_phone_screen_mark,
                                  @RequestParam("comment_phone_fluency_mark") Double comment_phone_fluency_mark,
                                  @RequestParam("comment_phone_battery_mark") Double comment_phone_battery_mark,
                                  @RequestParam("comment_phone_camera_mark") Double comment_phone_camera_mark,
                                  @RequestParam("comment_phone_commentby") String comment_phone_commentby,
                                  HttpServletRequest request,Model model){

        String comment_phone_commentor = (String) request.getSession().getAttribute("user_name");
        Comment2Phone comment2Phone = new Comment2Phone(comment_phone_commentor,
                comment_phone_commentby,comment_phone_context,comment_phone_price_mark,
                comment_phone_screen_mark,comment_phone_fluency_mark,comment_phone_battery_mark,
                comment_phone_camera_mark);
        //插入数据库，注意 ： 评论表中的coment_phode_replyto_name不要了。
        comment2PhoneService.addPhoneComment(comment2Phone);

        Phone phone = phoneService.getPhoneByName(comment_phone_commentby);
        phone.getPics();
        //添加评论信息
        List<Comment2Phone> phoneComments = comment2PhoneService.getByName(comment_phone_commentby);
        //求出，评论里的评分的平均值，求完了放到model里
        double price_mark = comment2PhoneService.price_mark(comment_phone_commentby);
        double screen_mark = comment2PhoneService.screen_mark(comment_phone_commentby);
        double fluency_mark = comment2PhoneService.fluency_mark(comment_phone_commentby);
        double battery_mark = comment2PhoneService.battery_mark(comment_phone_commentby);
        double camera_mark = comment2PhoneService.camera_mark(comment_phone_commentby);
        model.addAttribute("phone",phone);
        model.addAttribute("phoneComments",phoneComments);
        model.addAttribute("price_mark",price_mark);
        model.addAttribute("screen_mark",screen_mark);
        model.addAttribute("fluency_mark",fluency_mark);
        model.addAttribute("battery_mark",battery_mark);
        model.addAttribute("camera_mark",camera_mark);
        return "/phoneDetails";
    }

}
