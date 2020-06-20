package cn.edu.lingnan.controller;

import cn.edu.lingnan.entity.Manager;
import cn.edu.lingnan.entity.Player;
import cn.edu.lingnan.entity.common.CommonResult;
import cn.edu.lingnan.service.PlayerService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * (Player)表控制层
 *
 * @author makejava
 * @since 2020-06-12 19:42:54
 */
@RestController
@RequestMapping("player")
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
//    @DeleteMapping("/player")
//    public boolean delete(int id){
//        return playerService.deleteById(id);
//    }

    //查询
    @GetMapping("/player")
    public List<Player> queryAll(){
        System.out.println("111111");
        return playerService.queryAll();
    }

    //修改
//    @PutMapping("/player")
//    public Player update(Player player){
//        return playerService.update(player);
//    }


    @PostMapping("queryAll")
    public IPage<Player> queryAll(Integer page, Integer limit, Player bean){
        System.out.println("1111");
        return playerService.queryAllByLimit(page,limit,bean);
    }


    @PostMapping("/save")

    public Object save(Player bean){
        System.out.println(bean);
        boolean result;
        //判断账号是否存在
        if(bean.getPlayerId() != null){
            //编辑
            result = playerService.update(bean) > 0;

        }else {

            result = playerService.insert(bean).getPlayerId() != null;
        }
        return result;
    }

    @PostMapping("/deleteById")

    public boolean deleteById(Integer[] ids){
        if(ids == null || ids.length == 0){
            return false;
        }
        System.out.println(ids[0]);

        playerService.deleteById(Arrays.asList(ids));
        return true;
    }




    @PostMapping("queryAllbyName")
    public Object queryAllbyName(Integer page, Integer limit, Player bean){
        System.out.println("qqq");
        CommonResult<Player> result = new CommonResult<>();
        IPage<Player> ipage = playerService.queryAllByLimit(page,limit,bean);
        result.setCode(0);
        result.setCount(ipage.getTotal());
        result.setData(ipage.getRecords());
        return result;
    }
}