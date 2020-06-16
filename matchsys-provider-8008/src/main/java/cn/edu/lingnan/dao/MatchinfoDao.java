package cn.edu.lingnan.dao;

import cn.edu.lingnan.entity.Matchinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Matchinfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-13 10:35:34
 */

@Mapper
@Repository
public interface MatchinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param matchinfoBattleId 主键
     * @return 实例对象
     */
    Matchinfo queryById(Integer matchinfoBattleId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Matchinfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
     List<Matchinfo> queryAll();

    /**
     * 新增数据
     *
     * @param matchinfo 实例对象
     * @return 影响行数
     */
    int insert(Matchinfo matchinfo);

    /**
     * 修改数据
     *
     * @param matchinfo 实例对象
     * @return 影响行数
     */
    int update(Matchinfo matchinfo);

    /**
     * 通过主键删除数据
     *
     * @param matchinfoBattleId 主键
     * @return 影响行数
     */
    int deleteById(Integer matchinfoBattleId);

}