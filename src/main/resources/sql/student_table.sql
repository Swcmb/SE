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
    class_name VARCHAR(50),
    email VARCHAR(100),
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 插入测试数据
INSERT INTO student (name, age, gender, class_name, email, create_time) VALUES
('张三', 20, '男', '计算机科学与技术1班', 'zhangsan@example.com', NOW()),
('李四', 19, '女', '软件工程2班', 'lisi@example.com', NOW()),
('王五', 21, '男', '网络工程3班', 'wangwu@example.com', NOW()),
('赵六', 20, '女', '信息安全1班', 'zhaoliu@example.com', NOW()),
('钱七', 22, '男', '数据科学与大数据技术2班', 'qianqi@example.com', NOW()),
('孙八', 19, '女', '人工智能3班', 'sunba@example.com', NOW()),
('周九', 21, '男', '计算机科学与技术1班', 'zhoujiu@example.com', NOW()),
('吴十', 20, '女', '软件工程2班', 'wushi@example.com', NOW()),
('郑十一', 22, '男', '网络工程3班', 'zhengshiyi@example.com', NOW()),
('王十二', 19, '女', '信息安全1班', 'wangshier@example.com', NOW());