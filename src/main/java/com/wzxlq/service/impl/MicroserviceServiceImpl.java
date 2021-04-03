package com.wzxlq.service.impl;

import com.wzxlq.entity.Microservice;
import com.wzxlq.dao.MicroserviceMapper;
import com.wzxlq.service.MicroserviceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Microservice)表服务实现类
 *
 * @author makejava
 * @since 2021-03-31 15:21:30
 */
@Service("microserviceService")
public class MicroserviceServiceImpl implements MicroserviceService {
    @Resource
    private MicroserviceMapper microserviceMapper;

    /**
     * 分页查询后执行，获取总记录数
     *
     * @return 总记录数
     */
    @Override
    public int queryCountAfterLimit() {
        return this.microserviceMapper.queryCountAfterLimit();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param ip 主键
     * @return 实例对象
     */
    @Override
    public Microservice queryById(String ip) {
        return this.microserviceMapper.queryById(ip);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Microservice> queryAllByLimit(int offset, int limit) {
        return this.microserviceMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param microservice 实例对象
     * @return 实例对象
     */
    @Override
    public Microservice insert(Microservice microservice) {
        this.microserviceMapper.insert(microservice);
        return microservice;
    }

    /**
     * 修改数据
     *
     * @param microservice 实例对象
     * @return 实例对象
     */
    @Override
    public Microservice update(Microservice microservice) {
        this.microserviceMapper.update(microservice);
        return this.queryById(microservice.getIp());
    }

    /**
     * 通过主键删除数据
     *
     * @param ip 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String ip) {
        return this.microserviceMapper.deleteById(ip) > 0;
    }
}