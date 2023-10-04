package org.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * @Date: 2023/10/4
 * @Author: Administrator
 * @ClassName: AppConfig
 * @Description: comment here
 */

@Configuration  // 说明这是配置类，需要被容器导入
@EnableTransactionManagement    // 这个注解使得bean具有事务性质（就是配合@Transactional注解，若是出错能回滚）
@PropertySource("classpath:jdbc.properties")   // 注入数据源，让它去类路径下去找对应名字的数据源
@ComponentScan("org.example")   // 配置类当然要开启扫包
public class AppConfig {

    // 数据源
    @Bean   // Bean 是要去实例化对象的，所以构造器不能是private
    public DataSource dataSource(@Value("${user_name}") String username,
                                  @Value("${password}") String password,
                                  @Value("${url}") String url,
                                  @Value("${driverName}") String driverName
                                  ){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(username);
        dataSource.setUsername(password);
        dataSource.setUsername(url);
        dataSource.setUsername(driverName);
        return dataSource;
    }

    // template是用来具体执行具体数据库相关的操作
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource);
        return template;
    }

    // 事务管理器，它用来防止发生意外，比如转帐前扣完一方的钱发生异常了，那么这次扣钱应该失效而不是生效
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    @Bean
    public TransactionTemplate transactionTemplate(DataSourceTransactionManager transactionManager){
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(transactionManager);
        return transactionTemplate;
    }
}
