package cn.edu.lingnan.dao;

import cn.edu.lingnan.entity.Manager;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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


    List<Manager> queryAllByLimit(@Param("page") Page<Manager> page, @Param("bean") Manager bean);


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

    int deleteById(@Param("ids") List<Integer> ids);

    Manager login(String username, String password);

}