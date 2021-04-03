package com.wzxlq.service.impl;

import com.wzxlq.entity.Threshold;
import com.wzxlq.dao.ThresholdMapper;
import com.wzxlq.service.ThresholdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Threshold)表服务实现类
 *
 * @author makejava
 * @since 2021-03-30 13:24:56
 */
@Service("thresholdService")
public class ThresholdServiceImpl implements ThresholdService {
    @Resource
    private ThresholdMapper thresholdMapper;

    /**
     * 分页查询后执行，获取总记录数
     *
     * @return 总记录数
     */
    @Override
    public int queryCountAfterLimit() {
        return this.thresholdMapper.queryCountAfterLimit();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Threshold queryById(Integer id) {
        return this.thresholdMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Threshold> queryAllByLimit(int offset, int limit) {
        return this.thresholdMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param threshold 实例对象
     * @return 实例对象
     */
    @Override
    public Threshold insert(Threshold threshold) {
        this.thresholdMapper.insert(threshold);
        return threshold;
    }

    /**
     * 修改数据
     *
     * @param threshold 实例对象
     * @return 实例对象
     */
    @Override
    public Threshold update(Threshold threshold) {
        this.thresholdMapper.update(threshold);
        return this.queryById(threshold.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.thresholdMapper.deleteById(id) > 0;
    }

    @Override
    public Threshold queryByName(String ip, String interfaceName) {
       return thresholdMapper.queryByName(ip, interfaceName);
    }

    @Override
    public List<Threshold> queryAllByIp(String ip) {
       return thresholdMapper.queryByIp(ip);
    }

    @Override
    public boolean deleteByIp(Threshold threshold) {
        return thresholdMapper.deleteByIp(threshold);
    }


}