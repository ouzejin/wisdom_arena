package cn.edu.lingnan.service;

import cn.edu.lingnan.entity.Battle;
import cn.edu.lingnan.entity.Manager;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Battle)表服务接口
 *
 * @author makejava
 * @since 2020-06-14 16:52:03
 */
public interface BattleService {

    Battle queryById(Integer id);



    IPage<Battle> queryAllByLimit(int offset, int limit, Battle bean);

    List<Battle> queryAll();

    int insert(List<Battle> battle);

    Battle insert(Battle battle);

    int update(Battle Battle);

    boolean deleteById(@Param("ids") List<Integer> ids);

}