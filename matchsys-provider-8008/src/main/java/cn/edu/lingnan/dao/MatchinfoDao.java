package cn.edu.lingnan.dao;

import cn.edu.lingnan.entity.Battle;
import cn.edu.lingnan.entity.Manager;
import cn.edu.lingnan.entity.Matchinfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
public interface MatchinfoDao extends BaseDao<Matchinfo> {


    Matchinfo queryById(Integer id);

    List<Matchinfo> queryAllByLimit(@Param("page") Page<Matchinfo> page, @Param("bean") Matchinfo bean);


    List<Matchinfo> queryAll();

    int insertBatch(@Param("list") List<Matchinfo> list);

    boolean deleteById(@Param("ids") List<Integer> ids);


}

