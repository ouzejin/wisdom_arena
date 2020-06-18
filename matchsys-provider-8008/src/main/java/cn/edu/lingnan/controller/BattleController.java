package cn.edu.lingnan.controller;

import cn.edu.lingnan.entity.Battle;
import cn.edu.lingnan.entity.common.CommonResult;
import cn.edu.lingnan.service.BattleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;


/**
 * (Battle)表控制层
 *
 * @author makejava
 * @since 2020-06-14 16:52:03
 */
@RestController
@RequestMapping("battle")
public class BattleController {
    /**
     * 服务对象
     */
    @Resource
    private BattleService battleService;


    @PostMapping("save")

    public Object save(Battle bean) {
        boolean result = false;
        if (bean.getBattleId() != null) {
            //编辑
            result = battleService.update(bean) > 0;
        } else {
            //添加
            result = battleService.insert(bean).getBattleId() != null;
        }

        return result;
    }

    @GetMapping("queryAll")

    public Object queryAll(Integer page, Integer limit, Battle bean) {
        System.out.println(bean);
        CommonResult<Battle> result = new CommonResult<>();
        IPage<Battle> iPage = battleService.queryAllByLimit(page, limit, bean);
        result.setCode(0);
        result.setCount(iPage.getTotal());
        result.setData(iPage.getRecords());
        return result;
    }


    @DeleteMapping("/{ids}")

    public boolean deleteById(@PathVariable Integer[] ids) {
        if (ids == null || ids.length == 0) {
            return false;
        }
       battleService.deleteById(Arrays.asList(ids));
        return true;
    }
}