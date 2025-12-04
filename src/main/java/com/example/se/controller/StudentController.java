package com.example.se.controller;

import com.example.se.entity.Student;
import com.example.se.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @Autowired
    private com.example.se.mapper.StudentMapper studentMapper;

    /**
     * 查询所有学生数据
     * @return 学生列表
     */
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.selectAll();
    }

    /**
     * 根据ID查询单个学生
     * @param id 学生ID
     * @return 学生对象
     */
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.selectById(id);
    }

    /**
     * 测试数据库连接
     * @return 简单的学生列表
     */
    @GetMapping("/test")
    public List<Student> testDatabase() {
        return studentMapper.selectAll();
    }

    /**
     * 分页查询学生数据（支持按姓名查询）
     * @param pageNum 页码（默认为1）
     * @param pageSize 每页条数（默认为5）
     * @param name 姓名查询条件（可选）
     * @return 分页结果
     */
    @GetMapping("/selectPage")
    public PageInfo<Student> getStudentsByPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(required = false) String name) {
        return studentService.selectByPage(pageNum, pageSize, name);
    }
    
    /**
     * 新增学生
     * @param student 学生对象
     * @return 操作结果
     */
    @PostMapping
    public Map<String, Object> addStudent(@RequestBody Student student) {
        Map<String, Object> result = new HashMap<>();
        try {
            boolean success = studentService.insert(student);
            result.put("success", success);
            result.put("message", success ? "新增成功" : "新增失败");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "新增失败：" + e.getMessage());
        }
        return result;
    }
    
    /**
     * 更新学生信息
     * @param student 学生对象
     * @return 操作结果
     */
    @PutMapping
    public Map<String, Object> updateStudent(@RequestBody Student student) {
        Map<String, Object> result = new HashMap<>();
        try {
            boolean success = studentService.updateById(student);
            result.put("success", success);
            result.put("message", success ? "更新成功" : "更新失败");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "更新失败：" + e.getMessage());
        }
        return result;
    }
    
    /**
     * 根据ID删除学生
     * @param id 学生ID
     * @return 操作结果
     */
    @DeleteMapping("/{id}")
    public Map<String, Object> deleteStudent(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        try {
            boolean success = studentService.deleteById(id);
            result.put("success", success);
            result.put("message", success ? "删除成功" : "删除失败");
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "删除失败：" + e.getMessage());
        }
        return result;
    }
}