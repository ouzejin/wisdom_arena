package cn.edu.lingnan.controller;

import cn.edu.lingnan.entity.Manager;
import cn.edu.lingnan.entity.Matchinfo;
import cn.edu.lingnan.service.MatchinfoService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * (Matchinfo)表控制层
 *
 * @author makejava
 * @since 2020-06-13 10:35:34
 */
@RestController
@RequestMapping("matchinfo")
public class MatchinfoController {
    /**
     * 服务对象
     */
    @Resource
    private MatchinfoService matchinfoService;


    @PostMapping("update")
    public Integer update(Matchinfo bean){
        return matchinfoService.update(bean);
    }

    @PostMapping("insert")
    public Matchinfo save(Matchinfo bean){
        return matchinfoService.insert(bean);
    }

    @PostMapping("queryAll")
    public IPage<Matchinfo> queryAll(Integer page, Integer limit, Matchinfo bean){
        return matchinfoService.queryAllByLimit(page,limit,bean);
    }

    @PostMapping("queryById")
    public Matchinfo queryById(Integer id){
        return matchinfoService.queryById(id);

    }

    @PostMapping("/deleteById")
    public boolean deleteById(@RequestBody Integer[] ids){
        return matchinfoService.deleteById(Arrays.asList(ids));
    }

}
