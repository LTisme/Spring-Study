package org.example.FactoryBean;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.FactoryBean;

import javax.sql.DataSource;

/**
 * @Date: 2023/9/7
 * @Author: Administrator
 * @ClassName: DataSourceFactoryBean
 * @Description: 在这里说明一下BeanFactory和FactoryBean的区别
 */

// BeanFactory是Bean的工厂，容器会有很多Bean的工厂来创建一些Bean
// 而FactoryBean通常用来帮助我们创建一个复杂对象（比如创建对象过程很复杂用了很多反射，你都不知道返回的什么类型，就有用武之地了）
// 你可以在这里使用@Component来将工厂Bean注入到容器让这个工厂Bean创建复杂对象
// 你也可以在xml文件中将这个工厂Bean注入容器都行，都可以在测试中拿到目标对象的
public class DataSourceFactoryBean implements FactoryBean<DataSource> {
    @Override
    public DataSource getObject() throws Exception {
        // 实例化一个bean，然后交给容器管理，这个创建过程是复杂的，甚至我们连它是什么类都不知道
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername("root");

        return druidDataSource;
    }

    @Override
    public Class<?> getObjectType() {
        return DataSource.class;
    }
}
