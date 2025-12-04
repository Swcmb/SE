package com.example.se.service.impl;

import com.example.se.entity.Student;
import com.example.se.mapper.StudentMapper;
import com.example.se.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public Student selectById(Integer id) {
        return studentMapper.selectById(id);
    }

    @Override
    public PageInfo<Student> selectByPage(Integer pageNum, Integer pageSize, String name) {
        // 开启分页
        PageHelper.startPage(pageNum, pageSize);
        // 查询数据
        List<Student> students = studentMapper.selectByPage(name);
        // 封装分页结果
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        return pageInfo;
    }
    
    @Override
    public boolean insert(Student student) {
        // 不设置创建时间，因为我们不确定数据库是否有这个字段
        return studentMapper.insert(student) > 0;
    }
    
    @Override
    public boolean updateById(Student student) {
        return studentMapper.updateById(student) > 0;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        return studentMapper.deleteById(id) > 0;
    }
}