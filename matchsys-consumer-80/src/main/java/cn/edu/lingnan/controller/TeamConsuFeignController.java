package cn.edu.lingnan.controller;

import cn.edu.lingnan.entity.Team;
import cn.edu.lingnan.entity.common.CommonResult;
import cn.edu.lingnan.service.TeamFeignService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @program: matchsystem
 * @description: TODO
 * @author: Ouzj
 * @create: 2020-06-19 17:05
 **/
@Controller
@RequestMapping("team")
public class TeamConsuFeignController {
    @Autowired
    private TeamFeignService teamFeignService;
    private Object List;

    @RequestMapping("toTeamList")
    public String toTeamList(){
        return "team/team_list";
    }

    @PostMapping("queryAll")
    @ResponseBody
     public Object queryAll(Integer page, Integer limit, Team bean){
        System.out.println("1111");
        CommonResult<Team> result = new CommonResult<>();
        IPage<Team> ipage = teamFeignService.queryAllByLimit(page,limit,bean);
        result.setCode(0);
        result.setCount(ipage.getTotal());
        result.setData(ipage.getRecords());
        return result;
    }

    @PostMapping("deleteByName")
    @ResponseBody
    public boolean deleteById(String[] names){
        if(names == null || names.length == 0){
            return false;
        }
        System.out.println("11"+names[0]);
        List<String> namess = Arrays.asList(names);
        teamFeignService.deleteByName(namess);
        return true;
    }

    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        model.addAttribute("bean",new Team());
        return "team/team_add";
    }

    @PostMapping("/save")
    @ResponseBody
    public Team insert(Team team){
        System.out.println("===add===");
        return teamFeignService.insert(team);
    }


}

