package cn.edu.lingnan.dao;

import cn.edu.lingnan.entity.Player;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Player)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-12 19:42:54
 */

@Mapper
@Repository
public interface PlayerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param playerId 主键
     * @return 实例对象
     */
    Player queryById(Integer playerId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Player> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param player 实例对象
     * @return 对象列表
     */
    List<Player> queryAll();

    /**
     * 新增数据
     *
     * @param player 实例对象
     * @return 影响行数
     */
    int insert(Player player);

    /**
     * 修改数据
     *
     * @param player 实例对象
     * @return 影响行数
     */
    int update(Player player);

    /**
     * 通过主键删除数据
     *
     * @param playerId 主键
     * @return 影响行数
     */
    int deleteById(Integer playerId);

}