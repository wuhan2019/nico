package com.tico.tico.controllers;

import com.tico.tico.entities.User;
import com.tico.tico.services.UserService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
           return "redirect:/success";
        }
        //登录失败处理，回到登录页面，显示错误信息
        model.put("msg","用户名密码错误");
        return "fail";
    }

    @PostMapping("/user/signup")
    public String login(User user){
        System.out.print(user.getUser_password());
        userService.putUser(user);
        return "redirect:/login";
    }
}
