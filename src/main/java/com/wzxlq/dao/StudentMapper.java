package com.wzxlq.dao;

import com.wzxlq.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Student)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-17 11:00:05
 */
@Mapper
public interface StudentMapper {
    
    /**
     * 分页查询后执行，获取总记录数
     *
     * @return 总记录数
     */
    int queryCountAfterLimit();

    /**
     * 通过ID查询单条数据
     *
     * @param stuno 主键
     * @return 实例对象
     */
    Student queryById(Integer stuno);

    /**
     * 查询指定行数据(分页)
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param student 实例对象
     * @return 对象列表
     */
    List<Student> queryAll(Student student);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param stuno 主键
     * @return 影响行数
     */
    int deleteById(Integer stuno);

}