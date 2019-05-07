package com.tico.tico.controllers;


import com.tico.tico.entities.Comment2Peripheral;
import com.tico.tico.entities.Mouse;
import com.tico.tico.services.Comment2PeripheralService;
import com.tico.tico.services.MouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class MouseController {
    @Autowired
    MouseService mouseService;
    @Autowired
    Comment2PeripheralService comment2PeripheralService;
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
        List<Comment2Peripheral> panelComments = comment2PeripheralService.getByName(name);
        double mark = comment2PeripheralService.mark(name);
        model.addAttribute("mark",mark);
        model.addAttribute("comment2Peripheral",panelComments);
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

    //来到新增评论
    @GetMapping("/addMouseComment/{Mouse_name}")
    public String addMouseComment(@PathVariable("Mouse_name") String Mouse_name,Model model){
        //把要评论的手机先存起来
        model.addAttribute("Mouse_name",Mouse_name);
        //去填写评论信息页面
        return "/success";
    }
    //把评论信息打包发到数据库
    @PostMapping("/newMouseComment")
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
