package org.example.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Date: 2023/9/12
 * @Author: Administrator
 * @ClassName: atValueConfig
 * @Description: comment here
 */

//@Configuration
// 这句话的意思就是从类路径下找到目标的配置文件，注入到环境当中
@PropertySource("classpath:config.properties")
public class atValueConfig {

    @Value("${basePath}")
    private String basePath;

    @Override
    public String toString() {
        return "atValueConfig{" +
                "basePath='" + basePath + '\'' +
                '}';
    }
}
