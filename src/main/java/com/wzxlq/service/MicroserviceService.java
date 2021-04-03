package com.wzxlq.service;

import com.wzxlq.entity.Microservice;
import java.util.List;

/**
 * (Microservice)表服务接口
 *
 * @author makejava
 * @since 2021-03-31 15:21:30
 */
public interface MicroserviceService {

    /**
     * 分页查询后执行，获取总记录数
     *
     * @return 总记录数
     */
    int queryCountAfterLimit();

    /**
     * 通过ID查询单条数据
     *
     * @param ip 主键
     * @return 实例对象
     */
    Microservice queryById(String ip);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Microservice> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param microservice 实例对象
     * @return 实例对象
     */
    Microservice insert(Microservice microservice);

    /**
     * 修改数据
     *
     * @param microservice 实例对象
     * @return 实例对象
     */
    Microservice update(Microservice microservice);

    /**
     * 通过主键删除数据
     *
     * @param ip 主键
     * @return 是否成功
     */
    boolean deleteById(String ip);

}