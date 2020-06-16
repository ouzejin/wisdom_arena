package cn.edu.lingnan.dao;

import cn.edu.lingnan.entity.Team;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Team)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-13 08:29:52
 */

@Mapper
@Repository
public interface TeamDao extends BaseDao<Team> {

   Team queryById(String teamName);

    Team login(String teamName, String teamPassword);


    List<Team> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit, Team bean);


    List<Team> queryAll(IPage<Team> page, Team bean);

}