package cn.edu.lingnan.controller;

import cn.edu.lingnan.entity.common.CommonResult;
import cn.edu.lingnan.service.ManagerFeignService;
import cn.edu.lingnan.entity.Manager;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;

@Controller
@RequestMapping("manager")
public class ManagerConsuFeignController {
    @Autowired
    private ManagerFeignService managerFeignService;

    @RequestMapping("Login")
    public  String toLogin(){
        return  "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model){
        Manager manager = managerFeignService.login(username,password);
        if(manager==null){
            model.addAttribute("msg","账户或密码错误");
            return "login";

        }else{
            return "index";
        }

    }

    @RequestMapping("toManagerList")
    public String toManagerList(){
        System.out.println("toManagerList");
        return "manager/manager_list";
    }

    @PostMapping("queryAll")
    @ResponseBody
    public Object queryAll(Integer page, Integer limit, Manager bean){
        CommonResult<Manager> result = new CommonResult<>();
        IPage<Manager> ipage = managerFeignService.queryAll(page,limit,bean);
        result.setCode(0);
        result.setCount(ipage.getTotal());
        result.setData(ipage.getRecords());
        return result;
    }

    @RequestMapping("toAdd")
    public String toAdd(Model model){
        System.out.println("ManagerAdd");
        model.addAttribute("bean",new Manager());
        return "manager/manager_add";
    }

    @RequestMapping("toEdit")
    public String toEdit(Integer id,Model model){
        Manager manager = managerFeignService.queryById(id);
        model.addAttribute("bean",manager);
        System.out.println("ManagerAdd");
        return "manager/manager_add";
    }

    @PostMapping("/save")
    @ResponseBody
    public Object save(Manager bean){
        System.out.println(bean);
        boolean result;
        //判断账号是否存在
        if(bean.getManagerId() != null){
            //编辑
            result = managerFeignService.update(bean) > 0;

        }else {
            //增加
            bean.setManagerRegDate(new Date());
            result = managerFeignService.insert(bean).getManagerId() != null;
        }
        return result;
    }

    @PostMapping("/deleteById")
    @ResponseBody
    public boolean deleteById(Integer[] ids){
        if(ids == null || ids.length == 0){
            return false;
        }
        System.out.println(ids[0]);

        managerFeignService.deleteById(Arrays.asList(ids));
        return true;
    }




}
