package org.example.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Date: 2023/9/19
 * @Author: Administrator
 * @ClassName: ProxyBeanPostProcessor
 * @Description: AOP就是面向切面编程，具体的将，就是将有相同性质的某一层前后做横切，来统一对这一层做方法增强的意思
 */

//@Component
public class ProxyBeanPostProcessor implements BeanPostProcessor {

    // 在所有初始化工作完成后，将对所有注入好了的Bean做一些统一的事务管理
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 通过后置处理器，将原始对象替换成代理对象
        Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                bean.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 加上了自定义的事务
                        System.out.println("开启事务");
                        Object invoke =null;
                        try {
                            invoke = method.invoke(bean, args);
                        } catch (RuntimeException e){
                            throw new RuntimeException("出异常了，开始回滚");
                        }
                        System.out.println("事务结束");
                        return invoke;
                    }
                });

        return proxy;
    }
}
