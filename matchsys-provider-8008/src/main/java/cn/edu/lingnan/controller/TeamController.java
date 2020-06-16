package cn.edu.lingnan.controller;


import cn.edu.lingnan.entity.AdminQuery;
import cn.edu.lingnan.entity.Battle;
import cn.edu.lingnan.entity.Request;
import cn.edu.lingnan.entity.Team;
import cn.edu.lingnan.service.BattleService;
import cn.edu.lingnan.service.RequestService;
import cn.edu.lingnan.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Team)表控制层
 *
 * @author makejava
 * @since 2020-06-12 16:46:34
 */
@Controller
@RequestMapping("team")
public class TeamController {
    /**
     * 服务对象
     */
    @Resource
    private TeamService teamService;

    @Resource
    private RequestService requestService;

    @Resource
    private BattleService battleService;

    /**
     * 通过主键查询单条数据
     *
     * @param teamName 主键
     * @return 单条数据
     */
    @GetMapping("/team")
    public Team selectOne(String teamName) {
        return teamService.queryById(teamName);
    }

    @PostMapping("/team")
    public Team insert(Team team){
        return teamService.insert(team);

    }

    @PutMapping("/team")
    public boolean update(Team team){
        return  teamService.update(team) ;

    }


    @GetMapping("/teams")
    public List<Team> queryAll(AdminQuery bean){
        return teamService.queryAll(bean);
    }


    @DeleteMapping("/team")
    public boolean deleteById(@PathVariable String teamName) {
        return teamService.deleteById(teamName);
    }

    @PostMapping("/login")
    public String login(String teamName, String teamPassword, Model model){
        Team team = teamService.login(teamName,teamPassword);
        System.out.println(team);
        if(team==null){
            model.addAttribute("msg","账户或密码错误");

            return   "login"  ;
        }else{

            return"index";
        }

    }

    @PostMapping("challenge")
    public Request challenge(Request request){
         return requestService.insert(request);
    }

    @PostMapping("serachRequest")
    public Request searchRequest(String Teamname){
        return requestService.queryByName(Teamname);
    }

    @PostMapping("dealRequest")
    public boolean dealRequest(int flag,int requestId){
        if(flag==1){
            //不同意请求，删除request记录
            requestService.deleteById(requestId);
        }else{
            //同意请求，往battle表增加一条数据，同时删除request表记录
            Request request = requestService.queryById(requestId);
            Battle battle = new Battle();
            battle.setBattleNameOne(request.getRequestNameOne());
            battle.setBattleNameTwo(request.getRequestNameTwo());
            battle.setBattleTime(request.getRequestTime());
            battle.setBattleStatus(0);//0代表还未开始比赛，1代表比赛结束
            Battle battle1 = battleService.insert(battle);
            if (battle1 != null){
                requestService.deleteById(requestId);
            }
        }
        return true;
    }
}