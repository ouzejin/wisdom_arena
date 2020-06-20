package cn.edu.lingnan.controller;

import cn.edu.lingnan.entity.Player;
import cn.edu.lingnan.entity.common.CommonResult;
import cn.edu.lingnan.service.PlayerFeignService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
@RequestMapping("player")
public class PlayerConsuFeignController {
    @Autowired
    private PlayerFeignService playerFeignService;

    @RequestMapping("toPlayerList")
    public String toManagerList(){
        System.out.println("toPlayerList");
        return "player/player_list";
    }

    @PostMapping("queryAll")
    @ResponseBody
    public Object queryAll(Integer page, Integer limit, Player bean){
        System.out.println("11111");

        System.out.println(page);
        System.out.println(limit);
        System.out.println(bean);
        CommonResult<Player> result = new CommonResult<>();
        IPage<Player> ipage = playerFeignService.queryAll(page,limit,bean);
        result.setCode(0);
        result.setCount(ipage.getTotal());
        result.setData(ipage.getRecords());
        return result;
    }

    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        model.addAttribute("bean",new Player());
        return "player/player_add";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Integer id,Model model){
        model.addAttribute("bean",playerFeignService.queryById(id));
        return "player/player_add";
    }

    @PostMapping("/save")
    @ResponseBody
    public Object save(Player bean){
        System.out.println(bean);
        boolean result;
        //判断账号是否存在
        if(bean.getPlayerId() != null){
            //编辑
            result = playerFeignService.update(bean) > 0;

        }else {

            result = playerFeignService.insert(bean).getPlayerId() != null;
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

        playerFeignService.deleteById(Arrays.asList(ids));
        return true;
    }

}
