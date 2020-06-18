package cn.edu.lingnan.service;

import cn.edu.lingnan.entity.Battle;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * (Battle)表服务接口
 *
 * @author makejava
 * @since 2020-06-14 16:52:03
 */
public interface BattleService {

    Battle queryById(Integer id);

    List<Battle> queryAllByLimit(int offset, int limit);

    IPage<Battle> queryAllByLimit(int offset, int limit, Battle bean);

    int insert(List<Battle> battle);

    Battle insert(Battle battle);

    int update(Battle Battle);

    boolean deleteById(List<Integer> ids);

}