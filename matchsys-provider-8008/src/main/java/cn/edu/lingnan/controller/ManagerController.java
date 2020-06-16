package cn.edu.lingnan.controller;

import cn.edu.lingnan.entity.Manager;
import cn.edu.lingnan.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Manager)表控制层
 *
 * @author makejava
 * @since 2020-06-12 15:13:32
 */
@Controller
@RequestMapping("")
public class ManagerController {
    /**
     * 服务对象
     */
    @Resource
    private ManagerService managerService;


    @RequestMapping("Login")
    public  String toLogin(){
        return  "login";
    }

    @GetMapping("/selectOne")
    public Manager selectOne(Integer id) {
        return this.managerService.queryById(id);
    }

    @PostMapping("/manager")
    public Manager insert(Manager manager){
        return managerService.insert(manager);

    }

    @PutMapping("/manager")
    public Manager update(Manager manager){
        return  managerService.update(manager);

    }

    @DeleteMapping("/manager")
    public boolean delete(int id){
        return managerService.deleteById(id);

    }

    @GetMapping("/manager")
    public List<Manager> queryAll(){
        return managerService.queryAll();

    }

    @PostMapping("/login")
    public String login(String username, String password, Model model){
        Manager manager = managerService.login(username,password);
        System.out.println(manager);
        if(manager==null){
            model.addAttribute("msg","账户或密码错误");
            return "login";

        }else{
            return "index";
        }

    }


}