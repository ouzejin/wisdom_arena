package cn.edu.lingnan.service.impl;

import cn.edu.lingnan.dao.BattleDao;
import cn.edu.lingnan.entity.Battle;
import cn.edu.lingnan.service.BattleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Battle)表服务实现类
 *
 * @author makejava
 * @since 2020-06-14 16:52:03
 */
@Service("battleService")
public class BattleServiceImpl implements BattleService {
    @Resource
    private BattleDao battleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param battleId 主键
     * @return 实例对象
     */
    @Override
    public Battle queryById(Integer battleId) {
        return this.battleDao.queryById(battleId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Battle> queryAllByLimit(int offset, int limit) {
        return this.battleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param battle 实例对象
     * @return 实例对象
     */
    @Override
    public Battle insert(Battle battle) {
        this.battleDao.insert(battle);
        return battle;
    }

    /**
     * 修改数据
     *
     * @param battle 实例对象
     * @return 实例对象
     */
    @Override
    public Battle update(Battle battle) {
        this.battleDao.update(battle);
        return this.queryById(battle.getBattleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param battleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer battleId) {
        return this.battleDao.deleteById(battleId) > 0;
    }
}