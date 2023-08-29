package org.example.Entity;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 * @Date: 2023/8/28
 * @Author: Administrator
 * @ClassName: A
 * @Description: comment here
 */

public class A {

    private B b;

    public A() {
    }

    public A(B b) {
        this.b = b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public void init() {
        System.out.println("xml initialize.");
    }

    public void destroy() {
        System.out.println("xml destroy.");
    }

    // 这两个注解都在JDK11后被移除，需要自行去Maven引入 jakarta.annotation-api
    // 然后再在xml文件中开启注解，才能使用该注解
    @PostConstruct
    public void init2() {
        System.out.println("annotation initialize.");
    }

    @PreDestroy
    public void destroy2() {
        System.out.println("annotation destroy.");
    }

    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                '}';
    }
}
