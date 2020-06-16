package cn.edu.lingnan.service;

import cn.edu.lingnan.entity.Player;

import java.util.List;

/**
 * (Player)表服务接口
 *
 * @author makejava
 * @since 2020-06-12 19:42:54
 */
public interface PlayerService {

    /**
     * 通过ID查询单条数据
     *
     * @param playerId 主键
     * @return 实例对象
     */
    Player queryById(Integer playerId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Player> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param player 实例对象
     * @return 实例对象
     */

    List<Player> queryAll();


    Player insert(Player player);

    /**
     * 修改数据
     *
     * @param player 实例对象
     * @return 实例对象
     */
    Player update(Player player);

    /**
     * 通过主键删除数据
     *
     * @param playerId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer playerId);

}