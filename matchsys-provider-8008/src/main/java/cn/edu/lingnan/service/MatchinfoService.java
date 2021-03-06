package cn.edu.lingnan.service;

import cn.edu.lingnan.entity.Manager;
import cn.edu.lingnan.entity.Matchinfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Matchinfo)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 10:35:34
 */
public interface MatchinfoService {


    Matchinfo queryById(Integer id);

    IPage<Matchinfo> queryAllByLimit(int offset, int limit, Matchinfo bean);


    Matchinfo insert(Matchinfo matchinfo);

    int insert(List<Matchinfo> matchinfo);

    int update(Matchinfo matchinfo);

    boolean deleteById(@Param("ids") List<Integer> ids);

    List<Matchinfo> queryAll();
}