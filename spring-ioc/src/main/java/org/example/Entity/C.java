package org.example.Entity;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @Date: 2023/8/29
 * @Author: Administrator
 * @ClassName: C
 * @Description: comment here
 */

public class C implements BeanNameAware {

    private String name;

    public void printName() {
        System.out.println(name);
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }
}
