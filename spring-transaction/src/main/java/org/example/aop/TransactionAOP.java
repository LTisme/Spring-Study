package org.example.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Date: 2023/9/28
 * @Author: Administrator
 * @ClassName: TransactionAOP
 * @Description: 使用了xml配置AOP
 */

public class TransactionAOP implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("This is from TransactionAOP````````````");
    }
}
