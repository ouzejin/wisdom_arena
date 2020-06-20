package cn.edu.lingnan.service;

import cn.edu.lingnan.entity.Player;
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
public interface PlayerFeignService {
    @PostMapping("/player/queryAll")
    Page<Player> queryAll(@RequestParam("page") Integer page, @RequestParam("limit")Integer limit,@SpringQueryMap Player bean);

    @PostMapping("/player/update")
    Integer update(@SpringQueryMap Player bean);

    @PostMapping("/player/insert")
    Player insert(@SpringQueryMap Player bean);

    @PostMapping("/player/queryById")
    Player queryById(@RequestParam("playerId") Integer playerId);

    @PostMapping("/player/deleteById")
    boolean deleteById(@RequestBody List<Integer> ids);


}
