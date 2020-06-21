package cn.edu.lingnan.service;

import cn.edu.lingnan.entity.Battle;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(value = "MATCHSYS-PROVIDER-8008")
public interface BattleFeignService {

    

    @PostMapping("/battle/queryAll")
    Page<Battle> queryAll(@RequestParam("page") Integer page, @RequestParam("limit")Integer limit, @SpringQueryMap Battle bean);

    @PostMapping("/battle/update")
    Integer update(@SpringQueryMap Battle bean);

    @PostMapping("/battle/insert")
    Battle insert(@SpringQueryMap Battle bean);

    @PostMapping("/battle/queryById")
    Battle queryById(@RequestParam("id") Integer id);

    @PostMapping (value = "battle/deleteById")
    boolean deleteById(@RequestBody List<Integer> ids);
}
