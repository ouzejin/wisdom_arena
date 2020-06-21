package cn.edu.lingnan.service.impl;

import cn.edu.lingnan.dao.BattleDao;
import cn.edu.lingnan.entity.Battle;
import cn.edu.lingnan.entity.Manager;
import cn.edu.lingnan.service.BattleService;
import cn.edu.lingnan.util.StringUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
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


    @Override
    public Battle queryById(Integer id) {
        return this.battleDao.queryById(id);
    }


    @Override
    public IPage<Battle> queryAllByLimit(int offset, int limit, Battle bean) {
        Page<Battle> page = new Page<>(offset, limit);
        page.setRecords(battleDao.queryAllByLimit(page, bean));
        return page;
    }

    @Override
    public Battle insert(Battle battle) {
        this.battleDao.insert(battle);
        return battle;
    }

    @Override
    public int insert(List<Battle> battle) {
        return battleDao.insertBatch(battle);
    }

    @Override
    public List<Battle> queryAll() {
        return battleDao.queryAll();
    }

    @Override
    public int update(Battle battle) {
        return battleDao.update(battle);
    }

    @Override
    public boolean deleteById(List<Integer> ids) {
        return this.battleDao.deleteById(ids);
    }

}