package cn.edu.lingnan.service.impl;

import cn.edu.lingnan.entity.Manager;
import cn.edu.lingnan.entity.Matchinfo;
import cn.edu.lingnan.dao.MatchinfoDao;
import cn.edu.lingnan.service.MatchinfoService;
import cn.edu.lingnan.util.StringUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Matchinfo)表服务实现类
 *
 * @author makejava
 * @since 2020-06-13 10:35:34
 */
@Service("matchinfoService")
public class MatchinfoServiceImpl implements MatchinfoService {
    @Resource
    private MatchinfoDao matchinfoDao;

    @Override
    public Matchinfo queryById(Integer id) {
        return this.matchinfoDao.queryById(id);
    }


    @Override
    public IPage<Matchinfo> queryAllByLimit(int offset, int limit, Matchinfo bean) {
        Page<Matchinfo> page = new Page<>(offset, limit);
        page.setRecords(matchinfoDao.queryAllByLimit(page,bean));
        return page;
    }



    /**
     * 新增数据
     *
     * @param matchinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Matchinfo insert(Matchinfo matchinfo) {
        this.matchinfoDao.insert(matchinfo);
        return matchinfo;
    }



    @Override
    public int insert(List<Matchinfo> list) {
        return matchinfoDao.insertBatch(list);
    }

    /**
     * 修改数据
     *
     * @param matchinfo 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Matchinfo matchinfo) {
        return this.matchinfoDao.update(matchinfo);
    }


    /**
     * 通过主键删除数据
     *
     * @return 是否成功
     */
    @Override
    public boolean deleteById(List<Integer> ids) {
        System.out.println(ids);
        return matchinfoDao.delete("matchsys.matchinfo", StringUtil.listToString(ids)) > 0;
    }

    @Override
    public List<Matchinfo> queryAll() {
        return  matchinfoDao.queryAll();
    }
}