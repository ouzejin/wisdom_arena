package cn.edu.lingnan.controller;

import cn.edu.lingnan.entity.Manager;
import cn.edu.lingnan.entity.Team;
import cn.edu.lingnan.entity.common.CommonResult;
import cn.edu.lingnan.service.ManagerService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (Manager)表控制层
 *
 * @author makejava
 * @since 2020-06-12 15:13:32
 */
@RestController
@RequestMapping("manager")
public class ManagerController {
    /**
     * 服务对象
     */
    @Resource
    private ManagerService managerService;

    @PostMapping("/login")
    public Manager login(String username, String password){
        Manager manager = managerService.login(username,password);
        return manager;
    }


    @GetMapping("/selectOne")
    public Manager selectOne(Integer id) {
        return this.managerService.queryById(id);
    }

    @PostMapping("/manager")
    public Manager insert(Manager manager){
        return managerService.insert(manager);

    }

//    @PutMapping("/manager")
//    public Manager update(Manager manager){
//        return  managerService.update(manager);
//
//    }

    @DeleteMapping("/manager")
    public boolean delete(Integer[] ids){
        if(ids == null || ids.length == 0){
            return false;
        }
        System.out.println(ids[0]);

        managerService.deleteById(Arrays.asList(ids));
        return true;

    }

    @GetMapping("/manager")
    public List<Manager> queryAll(){
        return managerService.queryAll();

    }



    @PostMapping("queryAll")
    public IPage<Manager> queryAll(Integer page, Integer limit, Manager bean){
        return managerService.queryAllByLimit(page,limit,bean);
    }


    @PostMapping("update")
    public Integer update(Manager bean){
        return managerService.update(bean);
    }

    @PostMapping("insert")
    public Manager save(Manager bean){
         return managerService.insert(bean);

    }

    @PostMapping("queryById")
    public Manager queryById(Integer managerId){
        return managerService.queryById(managerId);

    }

    @DeleteMapping("deleteById")
    public boolean deleteById(@RequestBody Integer[] ids){
        return managerService.deleteById(Arrays.asList(ids));
    }



}