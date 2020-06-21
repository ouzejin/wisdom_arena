package cn.edu.lingnan.service;

import cn.edu.lingnan.entity.Player;
import cn.edu.lingnan.entity.Team;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Component
@FeignClient(value = "MATCHSYS-PROVIDER-8008")
public interface TeamFeignService {

    @PostMapping("team/queryAll")
    Page<Team> queryAllByLimit(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit")Integer limit, @SpringQueryMap Team bean);

    @PostMapping(value = "team/deleteByName")
    boolean deleteByName(@RequestBody List<String> names);

    @PostMapping("team/save")
    Team insert(@RequestBody Team team);

    @PostMapping("player/queryAll")
    Page<Player> queryAllByLimit(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit")Integer limit, @SpringQueryMap Player bean);

    @PostMapping(value = "player/deleteById")
    boolean deleteById(@RequestBody List<Integer> ids);

    @PostMapping("player/save")
    Player insert(@RequestBody Player player);


}
