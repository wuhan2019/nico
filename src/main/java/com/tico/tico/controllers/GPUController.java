package com.tico.tico.controllers;

import com.tico.tico.entities.Comment2Peripheral;
import com.tico.tico.entities.GPU;
import com.tico.tico.services.Comment2PeripheralService;
import com.tico.tico.services.GPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class GPUController {
    @Autowired
    GPUService gpuService;
    @Autowired
    Comment2PeripheralService comment2PeripheralService;
    @ResponseBody
    @RequestMapping("/gpu")
    public List<GPU> gpu(){
        return gpuService.getAll();
    }

    @GetMapping("/getGpuByName/{gpu_name}")
    public String getGpuByName(@PathVariable("gpu_name") String name,
                                 Model model)
    {
        GPU gpu = gpuService.getGpuByName(name);
        List<Comment2Peripheral> panelComments = comment2PeripheralService.getByName(name);
        double mark = comment2PeripheralService.mark(name);
        model.addAttribute("mark",mark);
        model.addAttribute("comment2Peripheral",panelComments);
        model.addAttribute("gpu",gpu);
        return "/success";
    }

    @GetMapping("/ getGPULikeBrand/{key}")
    public String getGPULikeBrand(@PathVariable("key")String key,
                                  Model model)
    {
        List<GPU> gpus = gpuService.getGPULikeBrand(key);
        if(gpus!=null)
            model.addAttribute("gpusByBrand",gpus);
        else
            model.addAttribute("gpusByBrand"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getGPULikeType/{key}")
    public String getGPULikeType(@PathVariable("key")String key,
                                  Model model)
    {
        List<GPU> gpus = gpuService.getGPULikeType(key);
        if(gpus!=null)
            model.addAttribute("gpusByType",gpus);
        else
            model.addAttribute("gpusByType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/getGPULikeBrandAndType/{brand}/{type}")
    public String getGPULikeBrandAndType(@PathVariable("brand") String brand,
                                            @PathVariable("type") String type,
                                            Model model)
    {
        List<GPU> gpus = gpuService.getGPULikeBrandAndType(brand,type);
        if(gpus!=null)
            model.addAttribute("gpusByBrandAndType",gpus);
        else
            model.addAttribute("gpusByBrandAndType"
                    ,"对不起！没有符合您条件的产品！");
        return "/success";
    }

    @GetMapping("/searchGPU/{key}")
    public String searchGPU(@PathVariable("key") String key,
                              Model model){
        List<GPU> gpus = gpuService.searchGPU(key);
        if(gpus!=null){
            model.addAttribute("searchGPU",gpus);
        }else{
            model.addAttribute("searchGPU"
                    ,"找不到您要的商品！");
        }
        return "/success";
    }


    //来到新增评论
    @GetMapping("/addGPUComment/{GPU_name}")
    public String addGPUComment(@PathVariable("GPU_name") String GPU_name,Model model){
        //把要评论的手机先存起来
        model.addAttribute("GPU_name",GPU_name);
        //去填写评论信息页面
        return "/success";
    }
    //把评论信息打包发到数据库
    @PostMapping("/newGPUComment")
    public String newGPUComment(@RequestParam("comment_peripheral_context") String comment_peripheral_context,
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
