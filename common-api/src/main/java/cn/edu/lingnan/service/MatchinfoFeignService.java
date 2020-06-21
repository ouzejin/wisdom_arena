package cn.edu.lingnan.service;


import cn.edu.lingnan.entity.Matchinfo;
import cn.edu.lingnan.entity.Matchinfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "MATCHSYS-PROVIDER-8008")
public interface MatchinfoFeignService {


    @PostMapping("/matchinfo/queryAll")
    Page<Matchinfo> queryAll(@RequestParam("page") Integer page, @RequestParam("limit")Integer limit, @SpringQueryMap Matchinfo bean);

    @PostMapping("/matchinfo/update")
    Integer update(@SpringQueryMap Matchinfo bean);

    @PostMapping("/matchinfo/insert")
    Matchinfo insert(@SpringQueryMap Matchinfo bean);

    @PostMapping("/matchinfo/queryById")
    Matchinfo queryById(@RequestParam("id") Integer id);

    @PostMapping("/matchinfo/deleteById")
    boolean deleteById(@RequestBody List<Integer> ids);
}
