# Spring Boot与MyBatis整合实验关键代码

## 1. Maven依赖配置 (pom.xml 关键部分)

```xml
<dependencies>
    <!-- Spring Boot Starter -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- MyBatis Spring Boot Starter -->
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>3.0.3</version>
    </dependency>

    <!-- MySQL驱动 -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- PageHelper分页插件 -->
    <dependency>
        <groupId>com.github.pagehelper</groupId>
        <artifactId>pagehelper-spring-boot-starter</artifactId>
        <version>1.4.6</version>
        <exclusions>
            <exclusion>
                <groupId>org.mybatis</groupId>
                <artifactId>mybatis</artifactId>
            </exclusion>
            <exclusion>
                <groupId>org.mybatis</groupId>
                <artifactId>mybatis-spring</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
</dependencies>
```

## 2. 数据库配置 (application-dev.yml)

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://182.92.157.62:3326/vue?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false&serverTimezone=GMT%2b8&allowPublicKeyRetrieval=true
    username: root
    password: root

mybatis:
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: com.example.se.entity
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
    map-underscore-to-camel-case: true
```

## 3. 实体类 (Student.java)

```java
package com.example.se.entity;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String email;
    private String className;
    private java.util.Date createTime;

    // Constructors
    public Student() {}

    public Student(Integer id, String name, Integer age, String gender, String email, String className, java.util.Date createTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.className = className;
        this.createTime = createTime;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", className='" + className + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
```

## 4. Mapper接口 (StudentMapper.java)

```java
package com.example.se.mapper;

import com.example.se.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
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
     * @return 学生列表
     */
    List<Student> selectByPage();
}
```

## 5. Mapper XML映射文件 (StudentMapper.xml)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.se.mapper.StudentMapper">

    <!-- 查询所有学生数据 -->
    <select id="selectAll" resultType="com.example.se.entity.Student">
        SELECT id, name, age, gender, email, create_time as createTime FROM student
    </select>

    <!-- 根据ID查询单个学生 -->
    <select id="selectById" parameterType="int" resultType="com.example.se.entity.Student">
        SELECT id, name, age, gender, email, create_time as createTime FROM student WHERE id = #{id}
    </select>

    <!-- 分页查询学生数据 -->
    <select id="selectByPage" resultType="com.example.se.entity.Student">
        SELECT id, name, age, gender, email, create_time as createTime FROM student
    </select>

</mapper>
```

## 6. Service层接口 (StudentService.java)

```java
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
     * @return 分页结果
     */
    PageInfo<Student> selectByPage(Integer pageNum, Integer pageSize);
}
```

## 7. Service层实现类 (StudentServiceImpl.java)

```java
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
    public PageInfo<Student> selectByPage(Integer pageNum, Integer pageSize) {
        // 开启分页
        PageHelper.startPage(pageNum, pageSize);
        // 查询数据
        List<Student> students = studentMapper.selectByPage();
        // 封装分页结果
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        return pageInfo;
    }
}
```

## 8. 控制器类 (StudentController.java)

```java
package com.example.se.controller;

import com.example.se.entity.Student;
import com.example.se.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

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
     * 分页查询学生数据
     * @param pageNum 页码（默认为1）
     * @param pageSize 每页条数（默认为5）
     * @return 分页结果
     */
    @GetMapping("/page")
    public PageInfo<Student> getStudentsByPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize) {
        return studentService.selectByPage(pageNum, pageSize);
    }
}
```

## 9. 主应用类 (SeApplication.java)

```java
package com.example.se;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.se.mapper")
public class SeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeApplication.class, args);
    }

}
```

## 10. 数据库表结构 (student_table.sql)

```sql
-- 创建数据库
CREATE DATABASE IF NOT EXISTS vue CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- 使用数据库
USE vue;

-- 创建学生表
CREATE TABLE IF NOT EXISTS student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    age INT,
    gender VARCHAR(10),
    email VARCHAR(100),
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 插入测试数据
INSERT INTO student (name, age, gender, email) VALUES
('张三', 20, '男', 'zhangsan@example.com'),
('李四', 19, '女', 'lisi@example.com'),
('王五', 21, '男', 'wangwu@example.com'),
('赵六', 20, '女', 'zhaoliu@example.com'),
('钱七', 22, '男', 'qianqi@example.com'),
('孙八', 19, '女', 'sunba@example.com'),
('周九', 21, '男', 'zhoujiu@example.com'),
('吴十', 20, '女', 'wushi@example.com'),
('郑十一', 22, '男', 'zhengshiyi@example.com'),
('王十二', 19, '女', 'wangshier@example.com');
```