package org.example.Config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Date: 2023/9/12
 * @Author: Administrator
 * @ClassName: whateverConfig
 * @Description: 随便什么类，都可以用@Value注解
 */

public class whateverConfig {
    @Value("${basePath}")
    private String basePath;

    @Override
    public String toString() {
        return "whateverConfig{" +
                "basePath='" + basePath + '\'' +
                '}';
    }
}
