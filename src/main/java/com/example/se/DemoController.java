package com.example.se;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String home() {
        return "Spring Boot运行成功 - 环境已正常启动！热部署测试1";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot with DevTools!";
    }
}