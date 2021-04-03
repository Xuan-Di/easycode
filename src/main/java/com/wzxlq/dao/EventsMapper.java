package com.wzxlq.dao;

import com.wzxlq.entity.Events;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Events)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-03 16:08:49
 */
@Mapper
public interface EventsMapper {
    
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
     * 查询指定行数据(分页)
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Events> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param events 实例对象
     * @return 对象列表
     */
    List<Events> queryAll(Events events);

    /**
     * 新增数据
     *
     * @param events 实例对象
     * @return 影响行数
     */
    int insert(Events events);

    /**
     * 修改数据
     *
     * @param events 实例对象
     * @return 影响行数
     */
    int update(Events events);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Events> queryByIpAndPort(@Param("ip") String ip, @Param("port") String port);
}