package cn.edu.lingnan.service;

import cn.edu.lingnan.entity.Matchinfo;

import java.util.List;

/**
 * (Matchinfo)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 10:35:34
 */
public interface MatchinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param matchinfoBattleId 主键
     * @return 实例对象
     */
    Matchinfo queryById(Integer matchinfoBattleId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Matchinfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param matchinfo 实例对象
     * @return 实例对象
     */
    List<Matchinfo> queryAll();

    Matchinfo insert(Matchinfo matchinfo);

    /**
     * 修改数据
     *
     * @param matchinfo 实例对象
     * @return 实例对象
     */
    Matchinfo update(Matchinfo matchinfo);

    /**
     * 通过主键删除数据
     *
     * @param matchinfoBattleId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer matchinfoBattleId);

}