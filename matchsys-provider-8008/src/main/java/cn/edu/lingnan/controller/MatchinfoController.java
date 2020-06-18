package cn.edu.lingnan.controller;

import cn.edu.lingnan.entity.Matchinfo;
import cn.edu.lingnan.entity.common.CommonResult;
import cn.edu.lingnan.service.MatchinfoService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * (Matchinfo)表控制层
 *
 * @author makejava
 * @since 2020-06-13 10:35:34
 */
@RestController
@RequestMapping("matchinfo")
public class MatchinfoController {
    /**
     * 服务对象
     */
    @Resource
    private MatchinfoService matchinfoService;


    @PostMapping("save")

    public Object save(Matchinfo bean) {
        boolean result = false;
        if (bean.getMatchinfoBattleId() != null) {
            //编辑
            result = matchinfoService.update(bean) > 0;
        } else {
            //添加
            result = matchinfoService.insert(bean).getMatchinfoBattleId() != null;
        }
        return result;
    }

    @PostMapping("queryAll")

    public Object queryAll(Integer page, Integer limit, Matchinfo bean) {
        System.out.println(bean);
        CommonResult<Matchinfo> result = new CommonResult<>();
        IPage<Matchinfo> iPage = matchinfoService.queryAllByLimit(page, limit, bean);
        result.setCode(0);
        result.setCount(iPage.getTotal());
        result.setData(iPage.getRecords());
        System.out.println(bean);
        return result;
    }

    /**
     * 文件上传
     * @param
     * @return
     */
//    @PostMapping("upload")
//
//    public Object upload(MultipartFile file) {
//        CommonResult<String> result = new CommonResult<>();
//        try {
//            EasyExcel.read(file.getInputStream(), Matchinfo.class, new StudentExcelLisener(studentService)).sheet().doRead();
//        } catch (IOException e) {
//            e.printStackTrace();
//            result.setMsg("Excel上传出错");
//        }
//        result.setData(file.getOriginalFilename());
//        return result;
//    }

    @DeleteMapping("/{ids}")

    public boolean deleteById(@PathVariable Integer[] ids) {
        if (ids == null || ids.length == 0) {
            return false;
        }
       matchinfoService.deleteById(Arrays.asList(ids));
        System.out.println("ids:::"+ids);
        return true;

    }
}
