package cn.edu.lingnan.controller;

import cn.edu.lingnan.entity.Battle;
import cn.edu.lingnan.entity.Battle;
import cn.edu.lingnan.entity.common.CommonResult;
import cn.edu.lingnan.service.BattleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;


/**
 * (Battle)表控制层
 *
 * @author makejava
 * @since 2020-06-14 16:52:03
 */
@RestController
@RequestMapping("battle")
public class BattleController {
    /**
     * 服务对象
     */
    @Resource
    private BattleService battleService;


    @PostMapping("queryAll")
    public IPage<Battle> queryAll(Integer page, Integer limit,Battle bean){
        System.out.println("bean:::"+bean);
        return battleService.queryAllByLimit(page,limit,bean);
    }

    @PostMapping("update")
    public Integer update(Battle bean){
        return battleService.update(bean);
    }

    @PostMapping("insert")
    public Battle save(Battle bean){
        return battleService.insert(bean);

    }

    @PostMapping("queryById")
    public Battle queryById(Integer id){
        return battleService.queryById(id);

    }

    @PostMapping ("deleteById")
    public boolean deleteById(@RequestBody Integer[] ids){
        System.out.println("controller:ids:::"+ids);
        System.out.println(battleService.deleteById(Arrays.asList(ids)));
        return battleService.deleteById(Arrays.asList(ids));

    }


}