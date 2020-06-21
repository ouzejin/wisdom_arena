package cn.edu.lingnan.dao;

import cn.edu.lingnan.entity.Battle;
import cn.edu.lingnan.entity.Manager;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Battle)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-14 16:52:02
 */
@Mapper
@Repository
public interface BattleDao extends  BaseDao<Battle> {

    Battle queryById(Integer id);


    List<Battle> queryAllByLimit(@Param("page") Page<Battle> page, @Param("bean") Battle bean);

    List<Battle> queryAll();

    int insertBatch(@Param("list") List<Battle> list);

    boolean deleteById(@Param("ids") List<Integer> ids);


}