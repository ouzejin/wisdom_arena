package cn.edu.lingnan.service;

import cn.edu.lingnan.entity.Manager;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "MATCHSYS-PROVIDER-8008")
public interface ManagerFeignService {

    @PostMapping("/manager/login")
    Manager login(@RequestParam("username") String username, @RequestParam("password") String password);
}
