@echo off
echo 正在启动学生管理系统（使用8081端口）...
echo.

echo 1. 检查Java环境...
java -version
if %errorlevel% neq 0 (
    echo 错误: 未找到Java环境，请确保已安装JDK 17+
    pause
    exit /b 1
)

echo.
echo 2. 启动Spring Boot应用...
echo 应用将在 http://localhost:8081 启动
echo 前端页面访问地址: http://localhost:8081/student.html
echo.
echo 按 Ctrl+C 停止应用
echo.

mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"