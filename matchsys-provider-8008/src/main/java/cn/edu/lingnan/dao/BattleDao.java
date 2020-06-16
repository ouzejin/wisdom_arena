package cn.edu.lingnan.dao;

import cn.edu.lingnan.entity.Battle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Battle)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-14 16:52:02
 */
@Mapper
@Repository
public interface BattleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param battleId 主键
     * @return 实例对象
     */
    Battle queryById(Integer battleId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Battle> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param battle 实例对象
     * @return 对象列表
     */
    List<Battle> queryAll(Battle battle);

    /**
     * 新增数据
     *
     * @param battle 实例对象
     * @return 影响行数
     */
    int insert(Battle battle);

    /**
     * 修改数据
     *
     * @param battle 实例对象
     * @return 影响行数
     */
    int update(Battle battle);

    /**
     * 通过主键删除数据
     *
     * @param battleId 主键
     * @return 影响行数
     */
    int deleteById(Integer battleId);

}