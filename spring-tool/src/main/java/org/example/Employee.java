package org.example;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * @Date: 2023/9/14
 * @Author: Administrator
 * @ClassName: Employee
 * @Description: comment here
 */

public class Employee {
//    @Value("#{'lucy_fromAnnotation'}")
    @Value("#{systemProperties['java.home']}")
    private String name;

    private float salary;

    private Date birthday;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }
}
