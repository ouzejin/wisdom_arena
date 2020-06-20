package cn.edu.lingnan.controller;

import cn.edu.lingnan.entity.Player;
import cn.edu.lingnan.entity.Team;
import cn.edu.lingnan.entity.common.CommonResult;
import cn.edu.lingnan.service.TeamFeignService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.text.PlainDocument;
import java.util.Arrays;
import java.util.List;

/**
 * @program: matchsystem
 * @description: TODO
 * @author: Ouzj
 * @create: 2020-06-20 16:12
 **/
@Controller
@RequestMapping("player")
public class TeamPlayerConsuFeignController {
    @Autowired
    private TeamFeignService teamFeignService;
    private Object List;


    @RequestMapping("toplayerList")
    public String toplayerList(){
        return "team/team_player_list";
    }

    @PostMapping("queryAll")
    @ResponseBody
    public Object queryAll(Integer page, Integer limit, Player bean){
        System.out.println("2222");
        CommonResult<Player> result = new CommonResult<>();
        IPage<Player> ipage = teamFeignService.queryAllByLimit(page,limit,bean);
        result.setCode(0);
        result.setCount(ipage.getTotal());
        result.setData(ipage.getRecords());
        return result;
    }

    @PostMapping("/deleteById")
    @ResponseBody
    public boolean deleteById(Integer[] ids){
        if(ids == null || ids.length == 0){
            return false;
        }
        System.out.println(ids[0]);
        teamFeignService.deleteById(Arrays.asList(ids));
        return true;
    }

    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        model.addAttribute("bean",new Player());
        return "player/player_add";
    }

    @PostMapping("/save")
    @ResponseBody
    public Player insert(Player player){
        System.out.println("###add###");
        return teamFeignService.insert(player);
    }

}

