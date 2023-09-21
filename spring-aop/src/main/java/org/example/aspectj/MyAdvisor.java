package org.example.aspectj;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Date: 2023/9/21
 * @Author: Administrator
 * @ClassName: MyAdvisor
 * @Description: comment here
 */

public class MyAdvisor implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("This is from MethodBeforeAdvice");
    }
}
