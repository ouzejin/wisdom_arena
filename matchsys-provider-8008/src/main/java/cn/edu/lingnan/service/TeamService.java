package cn.edu.lingnan.service;


import cn.edu.lingnan.entity.AdminQuery;
import cn.edu.lingnan.entity.Team;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * (Team)表服务接口
 *
 * @author makejava
 * @since 2020-06-12 16:46:34
 */
public interface TeamService {


    Team queryById(String teamName);

    List<Team> queryAll(AdminQuery bean);


    IPage<Team> queryAllByLimit(int offset, int limit, Team bean);

    Team insert(Team team);

    boolean update(Team team);

    boolean deleteById(String teamName);

    Team login(String teamName, String teamPassword);


    }
