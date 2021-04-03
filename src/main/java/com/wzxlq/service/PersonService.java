package com.wzxlq.service;

import com.wzxlq.entity.Person;
import java.util.List;

/**
 * (Person)表服务接口
 *
 * @author makejava
 * @since 2020-10-17 10:32:42
 */
public interface PersonService {

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
    Person queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Person> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param person 实例对象
     * @return 实例对象
     */
    Person insert(Person person);

    /**
     * 修改数据
     *
     * @param person 实例对象
     * @return 实例对象
     */
    Person update(Person person);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}