package cn.edu.lingnan.dao;

import cn.edu.lingnan.entity.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Manager)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-12 15:13:31
 */
@Mapper
@Repository
public interface ManagerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param managerId 主键
     * @return 实例对象
     */
    Manager queryById(Integer managerId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Manager> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    List<Manager> queryAll();

    /**
     * 新增数据
     *
     * @param manager 实例对象
     * @return 影响行数
     */
    int insert(Manager manager);

    /**
     * 修改数据
     *
     * @param manager 实例对象
     * @return 影响行数
     */
    int update(Manager manager);

    /**
     * 通过主键删除数据
     *
     * @param managerId 主键
     * @return 影响行数
     */
    int deleteById(Integer managerId);

    Manager login(String username, String password);

}