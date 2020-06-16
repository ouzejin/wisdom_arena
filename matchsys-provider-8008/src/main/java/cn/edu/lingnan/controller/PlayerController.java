package cn.edu.lingnan.controller;

import cn.edu.lingnan.entity.Player;
import cn.edu.lingnan.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Player)表控制层
 *
 * @author makejava
 * @since 2020-06-12 19:42:54
 */
@RestController
@RequestMapping("")
public class PlayerController {
    /**
     * 服务对象
     */
    @Resource
    private PlayerService playerService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */

    //增加
    @PostMapping("/player")
    public Player insert(Player player){
        return playerService.insert(player);
    }

    //删除
    @DeleteMapping("/player")
    public boolean delete(int id){
        return playerService.deleteById(id);
    }

    //查询
    @GetMapping("/player")
    public List<Player> queryAll(){
        System.out.println("111111");
        return playerService.queryAll();
    }

    //修改
    @PutMapping("/player")
    public Player update(Player player){
        return playerService.update(player);
    }
}