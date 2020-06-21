package cn.edu.lingnan.service.impl;

import cn.edu.lingnan.entity.Manager;
import cn.edu.lingnan.dao.ManagerDao;
import cn.edu.lingnan.service.ManagerService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Manager)表服务实现类
 *
 * @author makejava
 * @since 2020-06-12 15:13:32
 */
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerDao managerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param managerId 主键
     * @return 实例对象
     */
    @Override
    public Manager queryById(Integer managerId) {
        return this.managerDao.queryById(managerId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public IPage<Manager> queryAllByLimit(int offset, int limit, Manager bean) {
        Page<Manager> page = new Page<>(offset,limit);
        page.setRecords(managerDao.queryAllByLimit(page,bean));
        return page;
    }

    @Override
    public List<Manager> queryAll() {
        return managerDao.queryAll();
    }


    /**
     * 新增数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    @Override
    public Manager insert(Manager manager) {
        this.managerDao.insert(manager);
        return manager;
    }

    /**
     * 修改数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Manager manager) {

        return  managerDao.update(manager);
    }

    /**
     * 通过主键删除数据
     *
     * @param managerId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(List<Integer> managerId) {
        return this.managerDao.deleteById(managerId) > 0;
    }

    @Override
    public Manager login(String username, String password) {
        return managerDao.login(username,password);
    }

}