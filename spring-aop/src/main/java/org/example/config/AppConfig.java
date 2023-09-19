package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: 2023/9/19
 * @Author: Administrator
 * @ClassName: AppConfig
 * @Description: 配置类，用来替代xml文件配置的功能
 */

@Configuration
@ComponentScan({"org.example.config", "org.example.service"})   // 扫包
public class AppConfig {
}
