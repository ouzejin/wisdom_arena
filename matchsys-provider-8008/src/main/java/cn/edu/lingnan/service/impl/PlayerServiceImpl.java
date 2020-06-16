package cn.edu.lingnan.service.impl;

import cn.edu.lingnan.dao.PlayerDao;
import cn.edu.lingnan.entity.Player;
import cn.edu.lingnan.service.PlayerService;
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
    public List<Player> queryAllByLimit(int offset, int limit) {
        return this.playerDao.queryAllByLimit(offset, limit);
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
    public Player update(Player player) {
        this.playerDao.update(player);
        return this.queryById(player.getPlayerId());
    }

    /**
     * 通过主键删除数据
     *
     * @param playerId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer playerId) {
        return this.playerDao.deleteById(playerId) > 0;
    }
}