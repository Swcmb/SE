package com.example.se.service;

import com.example.se.entity.Student;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StudentService {
    /**
     * 查询所有学生数据
     * @return 学生列表
     */
    List<Student> selectAll();

    /**
     * 根据ID查询单个学生
     * @param id 学生ID
     * @return 学生对象
     */
    Student selectById(Integer id);

    /**
     * 分页查询学生数据
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @param name 姓名查询条件（可选）
     * @return 分页结果
     */
    PageInfo<Student> selectByPage(Integer pageNum, Integer pageSize, String name);
    
    /**
     * 新增学生
     * @param student 学生对象
     * @return 是否成功
     */
    boolean insert(Student student);
    
    /**
     * 更新学生信息
     * @param student 学生对象
     * @return 是否成功
     */
    boolean updateById(Student student);
    
    /**
     * 根据ID删除学生
     * @param id 学生ID
     * @return 是否成功
     */
    boolean deleteById(Integer id);
}