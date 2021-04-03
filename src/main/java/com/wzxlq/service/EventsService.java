package com.wzxlq.service;

import com.wzxlq.entity.Events;
import java.util.List;

/**
 * (Events)表服务接口
 *
 * @author makejava
 * @since 2021-04-03 16:08:50
 */
public interface EventsService {

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
    Events queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Events> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param events 实例对象
     * @return 实例对象
     */
    Events insert(Events events);

    /**
     * 修改数据
     *
     * @param events 实例对象
     * @return 实例对象
     */
    Events update(Events events);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Events> queryByIpAndPort(String ip, String port);
}