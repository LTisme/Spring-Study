package org.example.Env;

import org.springframework.core.env.PropertySource;

import java.util.Properties;

/**
 * @Date: 2023/9/12
 * @Author: Administrator
 * @ClassName: MyPropertySource
 * @Description: comment here
 */

public class MyPropertySource extends PropertySource {
    private Properties properties = new Properties();

    public MyPropertySource(String name) {
        super(name);
        properties.put("hello", "MyPropertySource");
    }

    @Override
    public Object getProperty(String name) {
        return properties.get(name);
    }
}
