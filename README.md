# 学生管理系统 (Student Management System)

这是一个基于Spring Boot和Vue.js开发的学生管理系统，提供学生信息的增删改查功能以及分页查询和搜索功能。

## 功能特性

- 学生信息的增删改查操作
- 分页查询学生数据
- 按姓名搜索学生
- 响应式前端界面
- RESTful API设计

## 技术栈

### 后端技术
- Spring Boot 3.1.0
- MyBatis
- MySQL数据库
- PageHelper分页插件

### 前端技术
- Vue 3
- Element Plus UI框架
- Axios HTTP客户端

## 系统架构

本项目采用前后端分离架构：
- 后端：提供RESTful API接口
- 前端：通过Ajax调用后端API并渲染页面

## 快速开始

### 环境要求
- JDK 17+
- Maven 3.6+
- MySQL 8.0+

### 配置说明

#### 数据库配置
在 `src/main/resources/application-dev.yml` 文件中配置数据库连接：



### 安装与运行

1. 克隆项目到本地
```bash
git clone <repository-url>
```

2. 进入项目目录
```bash
cd SE
```

3. 使用Maven编译项目
```bash
mvn clean install
```

4. 运行项目
```bash
mvn spring-boot:run
```

或者打包后运行：
```bash
mvn package
java -jar target/se-0.0.1-SNAPSHOT.jar
```

### 访问应用

启动成功后，在浏览器中访问以下地址：
- 主界面：http://localhost:8080/
- API根路径：http://localhost:8080/

## API接口文档

| 接口 | 方法 | 描述 |
|------|------|------|
| `/student` | GET | 获取所有学生 |
| `/student/{id}` | GET | 根据ID获取学生 |
| `/student/selectPage` | GET | 分页查询学生（支持姓名搜索） |
| `/student/test` | GET | 测试数据库连接 |
| `/student` | POST | 新增学生 |
| `/student` | PUT | 更新学生信息 |
| `/student/{id}` | DELETE | 根据ID删除学生 |

### 分页查询参数
- `pageNum`: 页码（默认为1）
- `pageSize`: 每页条数（默认为5）
- `name`: 姓名搜索条件（可选）

## 目录结构

```
src/
├── main/
│   ├── java/com/example/se/
│   │   ├── controller/      # 控制器层
│   │   ├── entity/          # 实体类
│   │   ├── mapper/          # MyBatis映射接口
│   │   ├── service/         # 服务层
│   │   └── SeApplication.java # 应用启动类
│   └── resources/
│       ├── mapper/          # MyBatis XML映射文件
│       ├── static/          # 静态资源文件
│       └── application.yml  # 配置文件
└── test/                    # 测试代码
```

## 开发指南

1. 后端代码位于 `src/main/java/com/example/se/` 目录下
2. 前端页面位于 `src/main/resources/static/` 目录下
3. 数据库表结构定义在 `src/main/resources/sql/student_table.sql`

## 注意事项

1. 确保数据库连接配置正确
2. 确保MySQL服务正常运行
3. 如果需要修改端口号，可以在 `application-dev.yml` 中修改 `server.port` 配置项

## 许可证

本项目仅供学习交流使用。