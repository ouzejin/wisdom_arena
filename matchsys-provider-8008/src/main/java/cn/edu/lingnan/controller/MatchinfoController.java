package cn.edu.lingnan.controller;

import cn.edu.lingnan.entity.Matchinfo;
import cn.edu.lingnan.service.MatchinfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Matchinfo)表控制层
 *
 * @author makejava
 * @since 2020-06-13 10:35:34
 */
@RestController
@RequestMapping("")
public class MatchinfoController {
    /**
     * 服务对象
     */
    @Resource
    private MatchinfoService matchinfoService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */

    //增加
    @PostMapping("/matchinfo")
    public Matchinfo insert(Matchinfo matchinfo){
        return matchinfoService.insert(matchinfo);
    }

    //删除
    @DeleteMapping("/matchinfo")
    public boolean delete(int id){
        return matchinfoService.deleteById(id);
    }

    //查询
    @GetMapping("/matchinfo")
    public List<Matchinfo> queryAll(){
        System.out.println("111111");
        return matchinfoService.queryAll();
    }

    //修改
    @PutMapping("/matchinfo")
    public Matchinfo update(Matchinfo matchinfo){
        return matchinfoService.update(matchinfo);
    }

}