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
        System.out.println(username+password);
        Manager manager = managerService.login(username,password);
        System.out.println(manager);
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

    public Object queryAll(Integer page, Integer limit, Manager bean){
        System.out.println();
        CommonResult<Manager> result = new CommonResult<>();
        IPage<Manager> ipage = managerService.queryAllByLimit(page,limit,bean);
        result.setCode(0);
        result.setCount(ipage.getTotal());
        result.setData(ipage.getRecords());
        return result;
    }


    @PostMapping("/save")

    public Object save(Manager bean){
        System.out.println(bean);
        boolean result;
        //判断账号是否存在
        if(bean.getManagerId() != null){
            //编辑
            result = managerService.update(bean) > 0;

        }else {
            //增加
            bean.setManagerRegDate(new Date());
            result = managerService.insert(bean).getManagerId() != null;
        }
        return result;
    }

    @PostMapping("/deleteById")

    public boolean deleteById(Integer[] ids){
        if(ids == null || ids.length == 0){
            return false;
        }
        System.out.println(ids[0]);

        managerService.deleteById(Arrays.asList(ids));
        return true;
    }



}