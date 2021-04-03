package com.wzxlq.dao;

import com.wzxlq.entity.Threshold;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Threshold)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-30 13:24:56
 */
@Mapper
public interface ThresholdMapper {
    
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
     * 查询指定行数据(分页)
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Threshold> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param threshold 实例对象
     * @return 对象列表
     */
    List<Threshold> queryAll(Threshold threshold);

    /**
     * 新增数据
     *
     * @param threshold 实例对象
     * @return 影响行数
     */
    int insert(Threshold threshold);

    /**
     * 修改数据
     *
     * @param threshold 实例对象
     * @return 影响行数
     */
    int update(Threshold threshold);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Threshold queryByName(@Param("ip") String ip, @Param("interfaceName") String interfaceName);

    List<Threshold> queryByIp(String ip);

    boolean deleteByIp(Threshold threshold);
}