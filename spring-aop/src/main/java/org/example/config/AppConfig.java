package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Date: 2023/9/19
 * @Author: Administrator
 * @ClassName: AppConfig
 * @Description: 配置类，用来替代xml文件配置的功能
 */

@Configuration
@ComponentScan({"org.example.config", "org.example.service", "org.example.aspectj"})   // 扫包
@EnableAspectJAutoProxy
public class AppConfig {
}
