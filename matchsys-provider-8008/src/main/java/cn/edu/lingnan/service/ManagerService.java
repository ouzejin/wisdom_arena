package cn.edu.lingnan.service;

import cn.edu.lingnan.entity.Manager;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * (Manager)表服务接口
 *
 * @author makejava
 * @since 2020-06-12 15:13:31
 */
public interface ManagerService {

    /**
     * 通过ID查询单条数据
     *
     * @param managerId 主键
     * @return 实例对象
     */
    Manager queryById(Integer managerId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    IPage<Manager> queryAllByLimit(int offset, int limit, Manager bean);

    List<Manager> queryAll();

    /**
     * 新增数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    Manager insert(Manager manager);

    /**
     * 修改数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    int update(Manager manager);

    /**
     * 通过主键删除数据
     *
     * @param managerId 主键
     * @return 是否成功
     */
    boolean deleteById(List<Integer> managerId);

    Manager login(String username, String password);

}