package cn.edu.lingnan.controller;

import cn.edu.lingnan.entity.Battle;
import cn.edu.lingnan.service.BattleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Battle selectOne(Integer id) {
        return this.battleService.queryById(id);
    }
}