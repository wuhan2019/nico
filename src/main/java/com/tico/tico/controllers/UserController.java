package com.tico.tico.controllers;

import com.tico.tico.entities.*;
import com.tico.tico.services.UserService;
//import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/user")
    public List<User> user(){
        System.out.println(userService.getAll());
        return userService.getAll();
    }


    @PostMapping("/user/login")
    public String login(@RequestParam("user_name") String user_name,
                      @RequestParam("user_password") String user_password,
                      HttpSession session, Map<String,Object> model){
        if(userService.getPasswordByName(user_name)!=null
                && userService.getPasswordByName(user_name).equals(user_password)){
            //登录成功处理，会话保存user_name
            session.setAttribute("user_name",user_name);
            //登录后，我们用一个会话保存九个产品需要对比的产品
            List<String> phoneList = new ArrayList<>();session.setAttribute("phoneList",phoneList);
            List<String> ssdList = new ArrayList<>();session.setAttribute("ssdList",ssdList);
            List<String> panelList = new ArrayList<>();session.setAttribute("panelList",panelList);
            List<String> mouseList = new ArrayList<>();session.setAttribute("mouseList",mouseList);
            List<String> memmoryList = new ArrayList<>();session.setAttribute("memmoryList",memmoryList);
            List<String> laptopList = new ArrayList<>();session.setAttribute("laptopList",laptopList);
            List<String> keyboardList = new ArrayList<>();session.setAttribute("keyboardList",keyboardList);
            List<String> headsetList = new ArrayList<>();session.setAttribute("headsetList",headsetList);
            List<String> gpuList = new ArrayList<>();session.setAttribute("gpuList",gpuList);

            return "redirect:/success";
        }
        //登录失败处理，回到登录页面，显示错误信息
        model.put("msg","用户名密码错误");
        return "fail";
    }

    @PostMapping("/user/signup")
    public String signup(User user,Map<String,Object> map){
        if(userService.getPasswordByName(user.getUser_name())!=null){//用户已经存在
            map.put("userExist","该名字已经被使用，请更换！");
            return "signup";
        }
        System.out.print(user.getUser_password());
        userService.putUser(user);
        return "redirect:/login";
    }
}
