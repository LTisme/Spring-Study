package org.example.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.service.IActivityService;
import org.example.service.impl.ActivityService;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Date: 2023/9/19
 * @Author: Administrator
 * @ClassName: MyAspect
 * @Description: 切面是一种规定，规定了往哪里去切
 */

@Component
@Aspect     // 这个注解能够将这个类定义成切面
public class MyAspect {
    // 这个就申明了一个切入点规则，将来要拿到切入点的引用，拿到这个方法签名即可
    // execution（常用）用于匹配方法执行的连接点，这是在使用Spring AOP时使用的主要切入点指示符。（匹配方法）
    // within 用于匹配指定类型内的方法执行。（匹配整个类）
    // this 用于匹配当前【AOP代理对象】类型的执行方法；注意是AOP代理对象的类型匹配，这样就可能【包括引入接口】也进行类型匹配。（配置整个类）
    // target 用于匹配当前目标对象类型的执行方法；注意是目标对象的类型匹配，这样就【不包括引入接口】也进行类型匹配。（配置整个类）
    @Pointcut("execution(public * org.example..*(..))") // 这里的意思是切所有public修饰的、任意类型返回值的、这个包及其子包下的任意个参数的任意方法
    private void beforePointcut() {} // 切入点方法签名

    @Before("org.example.aspectj.MyAspect.beforePointcut()")
    private void beforeAdvice(JoinPoint jp) throws InvocationTargetException, IllegalAccessException {
        // 通过方法签名拿到方法
        MethodSignature signature = (MethodSignature)jp.getSignature();
        Method method = signature.getMethod();
        // 调用方法的过程
        System.out.println("------------开始调用------------");
        method.invoke(jp.getTarget(), jp.getArgs());
        System.out.println("This is before advice...");
    }

    // 即便是你用finally，或者抛出异常了，这个afterReturning仍然能生效
    @AfterReturning("execution(public * org.example..order(..))")
    private void afterAdvice(){
        System.out.println("This is after advice...");
    }

    // 环绕通知，在Spring官方文档中不推荐使用——如果前置通知也可以完成需求的话，就不要使用环绕通知
    @Around("execution(public * org.example..order(..))")
    private void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("this is aroundAdvice1");
        // 这里相当于调用了方法
        Object proceed = pjp.proceed();
        System.out.println("this is aroundAdvice2");
    }

    // 这个声明的作用是：让代理对象实现新的接口，是让某个或某些类（比如这里是OrderService类）实现 某个具体实现类的接口（比如这里是实现 ActivityService 这个实现类的接口）
    // 因为是要让某些类实现你想指定的实现类实现的接口，所以定义范围只能是类，不能是方法
    @DeclareParents(value = "org.example.service.impl.OrderService", defaultImpl = ActivityService.class)
    private static IActivityService activityService;
}
