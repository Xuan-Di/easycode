package com.wzxlq.service.impl;

import com.wzxlq.entity.Student;
import com.wzxlq.dao.StudentMapper;
import com.wzxlq.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2020-10-17 11:00:05
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    /**
     * 分页查询后执行，获取总记录数
     *
     * @return 总记录数
     */
    @Override
    public int queryCountAfterLimit() {
        return this.studentMapper.queryCountAfterLimit();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param stuno 主键
     * @return 实例对象
     */
    @Override
    public Student queryById(Integer stuno) {
        return this.studentMapper.queryById(stuno);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Student> queryAllByLimit(int offset, int limit) {
        return this.studentMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student insert(Student student) {
        this.studentMapper.insert(student);
        return student;
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student update(Student student) {
        this.studentMapper.update(student);
        return this.queryById(student.getStuno());
    }

    /**
     * 通过主键删除数据
     *
     * @param stuno 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer stuno) {
        return this.studentMapper.deleteById(stuno) > 0;
    }
}