package com.wzxlq.service;

import com.wzxlq.entity.Threshold;
import java.util.List;

/**
 * (Threshold)表服务接口
 *
 * @author makejava
 * @since 2021-03-30 13:24:56
 */
public interface ThresholdService {

    /**
     * 分页查询后执行，获取总记录数
     *
     * @return 总记录数
     */
    int queryCountAfterLimit();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Threshold queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Threshold> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param threshold 实例对象
     * @return 实例对象
     */
    Threshold insert(Threshold threshold);

    /**
     * 修改数据
     *
     * @param threshold 实例对象
     * @return 实例对象
     */
    Threshold update(Threshold threshold);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    Threshold queryByName(String ip, String interfaceName);

    List<Threshold> queryAllByIp(String ip);

    boolean deleteByIp(Threshold threshold);
}