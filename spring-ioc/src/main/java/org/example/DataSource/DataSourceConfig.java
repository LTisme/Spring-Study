package org.example.DataSource;

import org.example.Entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * @Date: 2023/9/7
 * @Author: Administrator
 * @ClassName: DataSourceConfig
 * @Description: comment here
 */

@Configuration
public class DataSourceConfig {

    @Bean
    @Profile("product")
    public DataSource getProductDataSource(){
        return new ProductDataSource();
    }

    @Bean
    @Profile("dev")
    public DataSource getDevDataSource(){
        return new DevDataSource();
    }

    @Bean
    public User getUser(){
        return new User();
    }
}
