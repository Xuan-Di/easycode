package com.wzxlq.controller;

import com.wzxlq.entity.Threshold;
import com.wzxlq.service.ThresholdService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Threshold)表控制层
 *
 * @author makejava
 * @since 2021-03-30 13:24:56
 */
@RestController
@RequestMapping("threshold")
public class ThresholdController {
    /**
     * 服务对象
     */
    @Resource
    private ThresholdService thresholdService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */

    @PostMapping("insert")
    public Threshold insertRule(@RequestBody Threshold threshold) {
        return thresholdService.insert(threshold);
    }

    @PostMapping("delete")
    public boolean deleteByIp(@RequestBody Threshold threshold) {
        return thresholdService.deleteByIp(threshold);
    }
}