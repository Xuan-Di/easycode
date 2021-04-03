package com.wzxlq.service;

import com.wzxlq.entity.Student;
import java.util.List;

/**
 * (Student)表服务接口
 *
 * @author makejava
 * @since 2020-10-17 11:00:05
 */
public interface StudentService {

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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param stuno 主键
     * @return 是否成功
     */
    boolean deleteById(Integer stuno);

}