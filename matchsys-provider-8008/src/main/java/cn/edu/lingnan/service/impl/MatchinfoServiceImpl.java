package cn.edu.lingnan.service.impl;

import cn.edu.lingnan.dao.MatchinfoDao;
import cn.edu.lingnan.entity.Matchinfo;
import cn.edu.lingnan.service.MatchinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Matchinfo)表服务实现类
 *
 * @author makejava
 * @since 2020-06-13 10:35:34
 */
@Service("matchinfoService")
public class MatchinfoServiceImpl implements MatchinfoService {
    @Resource
    private MatchinfoDao matchinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param matchinfoBattleId 主键
     * @return 实例对象
     */
    @Override
    public Matchinfo queryById(Integer matchinfoBattleId) {
        return this.matchinfoDao.queryById(matchinfoBattleId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Matchinfo> queryAllByLimit(int offset, int limit) {
        return this.matchinfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据

     * @return 实例对象
     */
    @Override
    public List<Matchinfo> queryAll(){
        return matchinfoDao.queryAll();
    }

    @Override
    public Matchinfo insert(Matchinfo matchinfo) {
        this.matchinfoDao.insert(matchinfo);
        return matchinfo;
    }

    /**
     * 修改数据
     *
     * @param matchinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Matchinfo update(Matchinfo matchinfo) {
        this.matchinfoDao.update(matchinfo);
        return this.queryById(matchinfo.getMatchinfoBattleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param matchinfoBattleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer matchinfoBattleId) {
        return this.matchinfoDao.deleteById(matchinfoBattleId) > 0;
    }
}