package cn.edu.lingnan.dao;

import cn.edu.lingnan.entity.Battle;
import com.baomidou.mybatisplus.core.metadata.IPage;
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

    List<Battle> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Battle> queryAll(IPage<Battle> page, Battle bean);

    int insertBatch(@Param("list") List<Battle> list);


}