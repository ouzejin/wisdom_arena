package cn.edu.lingnan.service;

import cn.edu.lingnan.entity.Request;
import java.util.List;

/**
 * (Request)表服务接口
 *
 * @author makejava
 * @since 2020-06-14 16:27:39
 */
public interface RequestService {

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    Request queryById(Integer requestId);

    Request queryByName(String requestNameTwo);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Request> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param request 实例对象
     * @return 实例对象
     */
    Request insert(Request request);

    /**
     * 修改数据
     *
     * @param request 实例对象
     * @return 实例对象
     */
    Request update(Request request);

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer requestId);

}