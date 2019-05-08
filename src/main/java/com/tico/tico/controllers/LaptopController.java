package com.tico.tico.controllers;


import com.tico.tico.entities.Comment2Laptop;
import com.tico.tico.entities.Laptop;
import com.tico.tico.services.Comment2LaptopService;
import com.tico.tico.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class LaptopController {
    @Autowired
    LaptopService laptopService;
    @Autowired
    Comment2LaptopService comment2LaptopService;
    @ResponseBody
    @RequestMapping("/laptop")
    public List<Laptop> laptop(){
        return laptopService.getAll();
    }


    @GetMapping("/getLaptopByName/{laptop_name}")
    public String getLaptopByName(@PathVariable("laptop_name") String name,
                               Model model)
    {
        Laptop laptop = laptopService.getLaptopByName(name);
        List<Comment2Laptop> comment2Laptops = comment2LaptopService.getByName(name);
        double price_mark = comment2LaptopService.price_mark(name);
        double screen_mark = comment2LaptopService.screen_mark(name);
        double workspeed_mark = comment2LaptopService.workspeed_mark(name);
        double battery_mark = comment2LaptopService.battery_mark(name);
        double appearance_mark = comment2LaptopService .appearance_mark(name);
        double radiation_mark = comment2LaptopService.screen_mark(name);
        model.addAttribute("comment2Laptops",comment2Laptops);
        model.addAttribute("radiation",radiation_mark);
        model.addAttribute("workspeed_mark",workspeed_mark);
        model.addAttribute("price_mark",price_mark);
        model.addAttribute("screen_mark",screen_mark);
        model.addAttribute("fluency_mark",appearance_mark);
        model.addAttribute("battery_mark",battery_mark);
        model.addAttribute("laptop",laptop);
        return "/success";
    }

    @GetMapping("/ getLaptopLikeBrand/{key}")
    public String getLaptopLikeBrand(@PathVariable("key")String key,
                                  Model model)
    {
       List<Laptop> laptops = laptopService.getLaptopLikeBrand(key);
        if(laptops!=null)
            model.addAttribute("laptopsByBrand",laptops);
        else
            model.addAttribute("laptopsByBrand"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getLaptopLikeType/{key}")
    public String getLaptopLikeType(@PathVariable("key")String key,
                                 Model model)
    {
        List<Laptop> laptops = laptopService.getLaptopLikeType(key);
        if(laptops!=null)
            model.addAttribute("laptopsByType",laptops);
        else
            model.addAttribute("laptopsByType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getLaptopLikeBrandAndType/{brand}/{type}")
    public String getLaptopLikeBrandAndType(@PathVariable("brand") String brand,
                                         @PathVariable("type") String type,
                                         Model model)
    {
        List<Laptop> laptops = laptopService.getLaptopLikeBrandAndType(brand, type);
        if(laptops!=null)
            model.addAttribute("laptopsByBrandAndType",laptops);
        else
            model.addAttribute("laptopsByBrandAndType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/searchLaptop/{key}")
    public String searchLaptop(@PathVariable("key") String key,
                            Model model){
        List<Laptop> laptops = laptopService.searchLaptop(key);
        if(laptops!=null){
            model.addAttribute("searchLaptop",laptops);
        }else{
            model.addAttribute("searchLaptop"
                    ,"找不到您要的商品！");
        }
        return "/success";
    }

    //来到新增评论
    @GetMapping("/addLaptopComment/{laptop_name}")
    public String addLaptopComment(@PathVariable("laptop_name") String laptop_name,Model model){
        //把要评论的手机先存起来
        model.addAttribute("laptop_name",laptop_name);
        //去填写评论信息页面
        return "/success";
    }
    //把评论信息打包发到数据库
    @PostMapping("/newLaptopComment")
    public String newLaptopComment(@RequestParam("comment_laptop_context") String comment_laptop_context,
                                  @RequestParam("comment_laptop_price_mark") Double comment_laptop_price_mark,
                                  @RequestParam("comment_laptop_screen_mark") Double comment_laptop_screen_mark,
                                  @RequestParam("comment_laptop_workspeed_mark") Double comment_laptop_workspeed_mark,
                                  @RequestParam("comment_laptop_battery_mark") Double comment_laptop_battery_mark,
                                  @RequestParam("comment_laptop_radiation_mark") Double comment_laptop_radiation_mark,
                                  @RequestParam("comment_laptop_appearance_mark") Double comment_laptop_appearance_mark,
                                  @RequestParam("comment_laptop_commentby") String comment_laptop_commentby,
                                  HttpServletRequest request){

        String comment_laptop_commentor = (String) request.getSession().getAttribute("user_name");
        Date comment_laptop_time = new Date();
        Comment2Laptop comment2Laptop = new Comment2Laptop(comment_laptop_commentor,comment_laptop_commentby,comment_laptop_time,comment_laptop_context,comment_laptop_price_mark,comment_laptop_screen_mark,comment_laptop_workspeed_mark,comment_laptop_battery_mark, comment_laptop_radiation_mark, comment_laptop_appearance_mark);
        //插入数据库，注意 ： 评论表中的coment_phode_replyto_name不要了。
        comment2LaptopService.addLaptopComment(comment2Laptop);
        return "/success";
    }
}
