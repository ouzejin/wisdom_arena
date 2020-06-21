package cn.edu.lingnan.controller;

import cn.edu.lingnan.entity.Battle;
import cn.edu.lingnan.entity.common.CommonResult;
import cn.edu.lingnan.service.BattleFeignService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;

@Controller
@RequestMapping("battle")
public class BattleConsuFeignController {
    @Autowired
    private BattleFeignService battleFeignService;



    @RequestMapping("toList")
    public String toList(){
        System.out.println("toBattleList");
        return "battle/battle_list";
    }

    @RequestMapping("toEdit")
    public String toEdit(Integer id,Model model){
        Battle battle = battleFeignService.queryById(id);
        model.addAttribute("bean",battle);
        System.out.println("BattleAdd");
        return "battle/battle_add";
    }

    @PostMapping("queryAll")
    @ResponseBody
    public Object queryAll(Integer page, Integer limit, Battle bean){
        System.out.println(bean);
        CommonResult<Battle> result = new CommonResult<>();
        IPage<Battle> ipage = battleFeignService.queryAll(page,limit,bean);
        result.setCode(0);
        result.setCount(ipage.getTotal());
        result.setData(ipage.getRecords());
        return result;
    }




    @PostMapping("/save")
    @ResponseBody
    public Object save(Battle bean){
        System.out.println(bean);
        boolean result;
        //判断账号是否存在
        if(bean.getBattleId() != null){
            //编辑
            result = battleFeignService.update(bean) > 0;

        }else {
            //增加
            result = battleFeignService.insert(bean).getBattleId() != null;
        }
        return result;
    }

    @PostMapping ("deleteById")
    @ResponseBody
    public boolean deleteById(Integer[] ids){
        System.out.println("delete");
        if(ids == null || ids.length == 0){
            System.out.println("ids:::"+ids);
            return false;
        }
        System.out.println(ids[0]);
        System.out.println(ids);
        battleFeignService.deleteById(Arrays.asList(ids));
        System.out.println("deletesuccess");
        return true;
    }

}