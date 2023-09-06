package org.example;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Date: 2023/9/5
 * @Author: Administrator
 * @ClassName: AppConfig
 * @Description: comment here
 */

// 使用了@ComponentScan("org.example")就和使用了配置文件中开启扫包模式等价，用了这个就可以完全抛弃配置文件
@Configurable
@ComponentScan("org.example")
public class AppConfig {
}
