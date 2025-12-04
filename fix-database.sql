-- 检查并修复数据库表结构
-- 首先查看当前表结构
DESCRIBE student;

-- 如果class_name字段不存在，添加该字段
ALTER TABLE student ADD COLUMN IF NOT EXISTS class_name VARCHAR(50) COMMENT '班级名称';

-- 如果create_time字段不存在，添加该字段  
ALTER TABLE student ADD COLUMN IF NOT EXISTS create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间';

-- 更新现有数据的班级信息（如果为空的话）
UPDATE student SET class_name = '默认班级' WHERE class_name IS NULL OR class_name = '';

-- 查看修复后的表结构
DESCRIBE student;

-- 查看数据
SELECT * FROM student LIMIT 5;