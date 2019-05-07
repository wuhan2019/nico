package com.tico.tico.controllers;

import com.tico.tico.entities.Comment2Peripheral;
import com.tico.tico.entities.Keyboard;
import com.tico.tico.services.Comment2PeripheralService;
import com.tico.tico.services.KeyboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class KeyboardController {
    @Autowired
    KeyboardService keyboardService;
    @Autowired
    Comment2PeripheralService comment2PeripheralService;
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
        List<Comment2Peripheral> panelComments = comment2PeripheralService.getByName(name);
        double mark = comment2PeripheralService.mark(name);
        model.addAttribute("mark",mark);
        model.addAttribute("comment2Peripheral",panelComments);
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

    //来到新增评论
    @GetMapping("/addKeyboardComment/{Keyboard_name}")
    public String addKeyboardComment(@PathVariable("Keyboard_name") String Keyboard_name,Model model){
        //把要评论的手机先存起来
        model.addAttribute("Keyboard_name",Keyboard_name);
        //去填写评论信息页面
        return "/success";
    }
    //把评论信息打包发到数据库
    @PostMapping("/newKeyboardComment")
    public String newKeyboardComment(@RequestParam("comment_peripheral_context") String comment_peripheral_context,
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
