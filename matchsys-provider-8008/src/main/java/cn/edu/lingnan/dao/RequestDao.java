package cn.edu.lingnan.dao;

import cn.edu.lingnan.entity.Request;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Request)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-14 16:27:39
 */
@Mapper
@Repository
public interface RequestDao {

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    Request queryById(Integer requestId);

    Request queryByName(String requestNameTwo);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Request> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param request 实例对象
     * @return 对象列表
     */
    List<Request> queryAll(Request request);

    /**
     * 新增数据
     *
     * @param request 实例对象
     * @return 影响行数
     */
    int insert(Request request);

    /**
     * 修改数据
     *
     * @param request 实例对象
     * @return 影响行数
     */
    int update(Request request);

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 影响行数
     */
    int deleteById(Integer requestId);

}