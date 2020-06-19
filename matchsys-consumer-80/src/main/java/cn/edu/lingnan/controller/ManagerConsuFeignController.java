package cn.edu.lingnan.controller;

import cn.edu.lingnan.service.ManagerFeignService;
import cn.edu.lingnan.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("manager")
public class ManagerConsuFeignController {
    @Autowired
    private ManagerFeignService managerFeignService;

    @RequestMapping("Login")
    public  String toLogin(){
        System.out.println("tologin");
        return  "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model){
        System.out.println(username + password);
        System.out.println(managerFeignService);
        Manager manager = managerFeignService.login(username,password);
        if(manager==null){
            model.addAttribute("msg","账户或密码错误");
            return "login";

        }else{
            return "index";
        }

    }





}
