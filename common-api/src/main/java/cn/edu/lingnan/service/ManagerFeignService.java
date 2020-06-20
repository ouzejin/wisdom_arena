package cn.edu.lingnan.service;

import cn.edu.lingnan.entity.Manager;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "MATCHSYS-PROVIDER-8008")
public interface ManagerFeignService {

    @PostMapping("/manager/login")
    Manager login(@RequestParam("username") String username, @RequestParam("password") String password);

    @PostMapping("/manager/queryAll")
    Page<Manager> queryAll(@RequestParam("page") Integer page, @RequestParam("limit")Integer limit, @SpringQueryMap Manager bean);

    @PostMapping("/manager/update")
    Integer update(@SpringQueryMap Manager bean);

    @PostMapping("/manager/insert")
    Manager insert(@SpringQueryMap Manager bean);

    @PostMapping("/manager/queryById")
    Manager queryById(@RequestParam("managerId") Integer managerId);

    @PostMapping("/manager/deleteById")
    boolean deleteById(@RequestBody List<Integer> ids);
}
