package cn.edu.lingnan.service;


import cn.edu.lingnan.entity.SystemMenu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient(value = "MATCHSYS-PROVIDER-8008")
public interface MenuFeignService {

    @GetMapping("systemMenu/menus")
    List<SystemMenu> queryAll();
}
