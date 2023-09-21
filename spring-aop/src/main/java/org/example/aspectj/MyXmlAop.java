package org.example.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Date: 2023/9/21
 * @Author: Administrator
 * @ClassName: MyXMLAop
 * @Description: comment here
 */

public class MyXmlAop {

    private void beforeAdvice(JoinPoint jp) throws InvocationTargetException, IllegalAccessException {
        // 通过方法签名拿到方法
        MethodSignature signature = (MethodSignature)jp.getSignature();
        Method method = signature.getMethod();
        // 调用方法的过程
        System.out.println("------------开始调用------------");
//        method.invoke(jp.getTarget(), jp.getArgs());
        System.out.println("This is before advice...");
    }

    private void afterAdvice(){
        System.out.println("This is after advice...");
    }
}
