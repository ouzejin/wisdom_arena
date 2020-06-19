package cn.edu.lingnan.controller;

import cn.edu.lingnan.entity.MenuVo;
import cn.edu.lingnan.entity.SystemMenu;
import cn.edu.lingnan.service.MenuFeignService;
import cn.edu.lingnan.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("systemMenu")
public class MenuConsuFeignController {
    @Autowired
    private MenuFeignService menuFeignService;

    @GetMapping("menus")
    @ResponseBody
    public Map<String, Object> menus() {
        System.out.println("MenuConsuFeignController");
        Map<String, Object> map = new HashMap<>(16);
        Map<String,Object> home = new HashMap<>(16);
        Map<String,Object> logo = new HashMap<>(16);
        List<SystemMenu> menuList = menuFeignService.queryAll();
        List<MenuVo> menuInfo = new ArrayList<>();
        for (SystemMenu e : menuList) {
            MenuVo menuVO = new MenuVo();
            menuVO.setId(e.getId());
            menuVO.setPid(e.getPid());
            menuVO.setHref(e.getHref());
            menuVO.setTitle(e.getTitle());
            menuVO.setIcon(e.getIcon());
            menuVO.setTarget(e.getTarget());
            menuInfo.add(menuVO);
        }
        map.put("menuInfo", TreeUtil.toTree(menuInfo, 0));
        home.put("title","首页");
        home.put("href","/page/welcome-1"); //控制器路由,自行定义
        logo.put("title","后台管理系统");
        logo.put("image","/static/images/back.jpg"); //静态资源文件路径,可使用默认的logo.png
        map.put("homeInfo", "{title: '首页',href: '/ruge-web-admin/page/welcome.html'}}");
        map.put("logoInfo", "{title: 'RUGE ADMIN',image: 'images/logo.png'}");
        return map;
    }
}
