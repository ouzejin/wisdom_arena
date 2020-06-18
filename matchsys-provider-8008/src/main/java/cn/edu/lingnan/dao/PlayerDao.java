package cn.edu.lingnan.dao;

import cn.edu.lingnan.entity.Manager;
import cn.edu.lingnan.entity.Player;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Player)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-12 19:42:54
 */

@Mapper
@Repository
public interface PlayerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param playerId 主键
     * @return 实例对象
     */
    Player queryById(Integer playerId);


    List<Player> queryAllByLimit(@Param("page") Page<Player> page, @Param("bean") Player bean);



    List<Player> queryAll();

    /**
     * 新增数据
     *
     * @param player 实例对象
     * @return 影响行数
     */
    int insert(Player player);

    /**
     * 修改数据
     *
     * @param player 实例对象
     * @return 影响行数
     */
    int update(Player player);


    int deleteById(@Param("ids") List<Integer> ids);

}