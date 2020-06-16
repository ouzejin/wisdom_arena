package cn.edu.lingnan.service.impl;

import cn.edu.lingnan.dao.RequestDao;
import cn.edu.lingnan.entity.Request;
import cn.edu.lingnan.service.RequestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Request)表服务实现类
 *
 * @author makejava
 * @since 2020-06-14 16:27:39
 */
@Service("requestService")
public class RequestServiceImpl implements RequestService {
    @Resource
    private RequestDao requestDao;

    /**
     * 通过ID查询单条数据
     *
     * @param requestId 主键
     * @return 实例对象
     */
    @Override
    public Request queryById(Integer requestId) {
        return this.requestDao.queryById(requestId);
    }

    @Override
    public Request queryByName(String requestNameTwo) {
        return requestDao.queryByName(requestNameTwo);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Request> queryAllByLimit(int offset, int limit) {
        return this.requestDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param request 实例对象
     * @return 实例对象
     */
    @Override
    public Request insert(Request request) {
        this.requestDao.insert(request);
        return request;
    }

    /**
     * 修改数据
     *
     * @param request 实例对象
     * @return 实例对象
     */
    @Override
    public Request update(Request request) {
        this.requestDao.update(request);
        return this.queryById(request.getRequestId());
    }

    /**
     * 通过主键删除数据
     *
     * @param requestId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer requestId) {
        return this.requestDao.deleteById(requestId) > 0;
    }
}