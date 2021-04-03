package com.wzxlq.service.impl;

import com.wzxlq.entity.Events;
import com.wzxlq.dao.EventsMapper;
import com.wzxlq.service.EventsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Events)表服务实现类
 *
 * @author makejava
 * @since 2021-04-03 16:08:50
 */
@Service("eventsService")
public class EventsServiceImpl implements EventsService {
    @Resource
    private EventsMapper eventsMapper;

    /**
     * 分页查询后执行，获取总记录数
     *
     * @return 总记录数
     */
    @Override
    public int queryCountAfterLimit() {
        return this.eventsMapper.queryCountAfterLimit();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Events queryById(Integer id) {
        return this.eventsMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Events> queryAllByLimit(int offset, int limit) {
        return this.eventsMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param events 实例对象
     * @return 实例对象
     */
    @Override
    public Events insert(Events events) {
        this.eventsMapper.insert(events);
        return events;
    }

    /**
     * 修改数据
     *
     * @param events 实例对象
     * @return 实例对象
     */
    @Override
    public Events update(Events events) {
        this.eventsMapper.update(events);
        return this.queryById(events.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.eventsMapper.deleteById(id) > 0;
    }

    @Override
    public List<Events> queryByIpAndPort(String ip, String port) {
        return eventsMapper.queryByIpAndPort(ip,port);
    }
}