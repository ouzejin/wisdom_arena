package cn.edu.lingnan.service.impl;

import cn.edu.lingnan.entity.Manager;
import cn.edu.lingnan.entity.Player;
import cn.edu.lingnan.dao.PlayerDao;
import cn.edu.lingnan.service.PlayerService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Player)表服务实现类
 *
 * @author makejava
 * @since 2020-06-12 19:42:54
 */
@Service("playerService")
public class PlayerServiceImpl implements PlayerService {
    @Resource
    private PlayerDao playerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param playerId 主键
     * @return 实例对象
     */
    @Override
    public Player queryById(Integer playerId) {
        return this.playerDao.queryById(playerId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */

    @Override
    public IPage<Player> queryAllByLimit(int offset, int limit, Player bean) {
        Page<Player> page = new Page<>(offset,limit);

        System.out.println("impl");

        page.setRecords(playerDao.queryAllByLimit(page,bean));
        return page;
    }

    /**
     * 新增数据
     *
     * @return 实例对象
     */

    @Override
    public List<Player> queryAll(){
        return playerDao.queryAll();
    }

    @Override
    public Player insert(Player player) {
        this.playerDao.insert(player);
        return player;
    }

    /**
     * 修改数据
     *
     * @param player 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Player player) {
        return playerDao.update(player);
    }


    @Override
    public boolean deleteById(List<Integer> ids) {
        return this.playerDao.deleteById(ids) > 0;
    }
}