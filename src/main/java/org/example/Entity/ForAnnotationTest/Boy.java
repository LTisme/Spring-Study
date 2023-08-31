package org.example.Entity.ForAnnotationTest;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Date: 2023/8/30
 * @Author: Administrator
 * @ClassName: Boy
 * @Description: comment here
 */

public class Boy {

    /**
     * @Autowired 可以注解到构造器上，也可以注解到成员变量上
     */

    @Autowired
    private Pet pet;

    @Autowired
    private Girl girl;

//    public Boy(Pet pet) {
//        this.pet = pet;
//    }
//
//    @Autowired
//    public Boy(Pet pet, Girl girl) {
//        this.pet = pet;
//        this.girl = girl;
//    }
//
//    public Pet getPet() {
//        return pet;
//    }
//
//    public void setPet(Pet pet) {
//        this.pet = pet;
//    }

    @Override
    public String toString() {
        return "Boy{" +
                "pet=" + pet +
                ", girl=" + girl +
                '}';
    }
}
