package cn.edu.lingnan.controller;

import cn.edu.lingnan.entity.MenuVo;
import cn.edu.lingnan.entity.SystemMenu;
import cn.edu.lingnan.entity.common.CommonResult;
import cn.edu.lingnan.service.SystemMenuService;
import cn.edu.lingnan.util.TreeUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * 系统菜单表(SystemMenu)表控制层
 *
 * @author makejava
 * @since 2020-06-14 16:01:59
 */
@RestController
@RequestMapping("systemMenu")
public class SystemMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SystemMenuService systemMenuService;

    @GetMapping("menus")
    public List<SystemMenu> menus() {
        System.out.println("SystemMenuController");

        return systemMenuService.queryAll();

    }

    @GetMapping("getAuths")

    public Object getAuths() {
        CommonResult<SystemMenu> result = new CommonResult<>();
        List<SystemMenu> list = systemMenuService.queryAll();
        result.setCode(0);
        result.setCount((long) list.size());
        result.setData(list);
        return result;
    }

    @PostMapping("save")

    public Object save(SystemMenu bean) {
        boolean result = false;
        //判断账号是否存在

        //判断是添加还是编辑
        if (bean.getId() != null) {
            //编辑
            result = systemMenuService.update(bean);
        } else {
            //添加
            result = systemMenuService.insert(bean).getId() != null;
        }

        return result;
    }

    @PostMapping("queryAll")

    public Object queryAll(Integer page, Integer limit, SystemMenu bean) {
        System.out.println(bean);
        CommonResult<SystemMenu> result = new CommonResult<>();
        IPage<SystemMenu> iPage = systemMenuService.queryAllByLimit(page, limit, bean);
        result.setCode(0);
        result.setCount(iPage.getTotal());
        result.setData(iPage.getRecords());
        return result;
    }

    @DeleteMapping("/{ids}")

    public boolean deleteById(@PathVariable Integer[] ids) {
        if (ids == null || ids.length == 0) {
            return false;
        }
        return systemMenuService.deleteById(Arrays.asList(ids));
    }
}