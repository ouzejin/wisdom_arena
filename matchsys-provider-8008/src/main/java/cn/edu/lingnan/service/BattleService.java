package cn.edu.lingnan.service;

import cn.edu.lingnan.entity.Battle;

import java.util.List;

/**
 * (Battle)表服务接口
 *
 * @author makejava
 * @since 2020-06-14 16:52:03
 */
public interface BattleService {

    /**
     * 通过ID查询单条数据
     *
     * @param battleId 主键
     * @return 实例对象
     */
    Battle queryById(Integer battleId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Battle> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param battle 实例对象
     * @return 实例对象
     */
    Battle insert(Battle battle);

    /**
     * 修改数据
     *
     * @param battle 实例对象
     * @return 实例对象
     */
    Battle update(Battle battle);

    /**
     * 通过主键删除数据
     *
     * @param battleId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer battleId);

}