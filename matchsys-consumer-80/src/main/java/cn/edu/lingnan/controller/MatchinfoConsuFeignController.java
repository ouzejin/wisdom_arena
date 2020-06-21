package cn.edu.lingnan.controller;

import cn.edu.lingnan.entity.Matchinfo;
import cn.edu.lingnan.entity.common.CommonResult;
import cn.edu.lingnan.service.ManagerFeignService;
import cn.edu.lingnan.entity.Matchinfo;
import cn.edu.lingnan.service.MatchinfoFeignService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;

@Controller
@RequestMapping("matchinfo")
public class MatchinfoConsuFeignController {
    @Autowired
    private MatchinfoFeignService matchinfoFeignService;

    @RequestMapping("toList")
    public String toList() {
        return "matchinfo/info_list";
    }

    @PostMapping("queryAll")
    @ResponseBody
    public Object queryAll(Integer page, Integer limit, Matchinfo bean){
        CommonResult<Matchinfo> result = new CommonResult<>();
        IPage<Matchinfo> ipage = matchinfoFeignService.queryAll(page,limit,bean);
        result.setCode(0);
        result.setCount(ipage.getTotal());
        result.setData(ipage.getRecords());
        return result;
    }

    @GetMapping("toAdd")
    public String toAdd(Model model) {
        model.addAttribute("bean", new Matchinfo());
        return "matchinfo/info_add";
    }

    @GetMapping("toEdit")
    public String toEdit( Integer id, Model model) {
        System.out.println("id:::" + id);
        Matchinfo bean = matchinfoFeignService.queryById(id);
        model.addAttribute("bean", bean);
        return "matchinfo/info_add";
    }

    @PostMapping("/save")
    @ResponseBody
    public Object save(Matchinfo bean){
        System.out.println(bean);
        boolean result;
        //判断账号是否存在
        if(bean.getMatchinfoBattleId()!= null){
            //编辑
            result = matchinfoFeignService.update(bean) > 0;

        }else {

            result = matchinfoFeignService.insert(bean).getMatchinfoBattleId() != null;
        }
        return result;
    }

    @PostMapping("/deleteById")
    @ResponseBody
    public boolean deleteById(Integer[] ids){
        if(ids == null || ids.length == 0){
            return false;
        }
        System.out.println(ids[0]);
        matchinfoFeignService.deleteById(Arrays.asList(ids));
        return true;
    }




}
