package cn.edu.lingnan.service.impl;

import cn.edu.lingnan.entity.AdminQuery;
import cn.edu.lingnan.entity.Player;
import cn.edu.lingnan.entity.Team;
import cn.edu.lingnan.dao.TeamDao;
import cn.edu.lingnan.service.TeamService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Team)表服务实现类
 *
 * @author makejava
 * @since 2020-06-12 16:46:34
 */
@Service("teamService")
public class TeamServiceImpl implements TeamService {
    @Resource
    private TeamDao teamDao;




    /**
     * 通过ID查询单条数据
     *
     * @param teamName 主键
     * @return 实例对象
     */
    @Override
    public Team queryByName(String teamName) {
        return teamDao.queryByName(teamName);
    }

    @Override
    public List<Team> queryAll(AdminQuery bean) {
        return null;
    }

//    @Override
//    public List<Team> queryAll() {
//        return teamDao.queryAll();
//    }

    @Override
    public IPage<Team> queryAllByLimit(int offset, int limit, Team bean) {
        Page<Team> page = new Page<>(offset,limit);

        System.out.println("impl");

        page.setRecords(teamDao.queryAllByLimit(page,bean));
        return page;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
//    @Override
//    public IPage<Team> queryAllByLimit(int offset, int limit, Team bean) {
//        Page<Team> page = new Page<>(offset, limit);
//        page.setRecords(teamDao.queryAllByLimit(page, bean));
//        return page;
//    }

    /**
     * 新增数据
     *
     * @param team 实例对象
     * @return 实例对象
     */
    @Override
    public Team insert(Team team) {
        this.teamDao.insert(team);
        return team;
    }

    @Override
    public int update(Team team) {
        return teamDao.update(team);

    }

    @Override
    public boolean deleteByName(List<String> names) {
        return teamDao.deleteByName(names);
    }

    /**
     * 修改数据
     *
     * @param team 实例对象
     * @return 实例对象
     */
//    @Override
//    public boolean update(Team team) {
//        return teamDao.update(team);
//    }

    /**
     * 通过主键删除数据
     *
     * @param teamName 主键
     * @return 是否成功
     */
//    @Override
//    public boolean deleteById(String teamName) {
//
//       return teamDao.deleteById(teamName);
//    }

    @Override
    public Team login(String teamName, String teamPassword) {
        return teamDao.login(teamName,teamPassword);
    }

}