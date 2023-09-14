package org.example;

/**
 * @Date: 2023/9/14
 * @Author: Administrator
 * @ClassName: Company
 * @Description: comment here
 */

public class Company {

    private String name;
    private Employee managingDirector;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManagingDirector() {
        return this.managingDirector;
    }

    public void setManagingDirector(Employee managingDirector) {
        this.managingDirector = managingDirector;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", managingDirector=" + managingDirector +
                '}';
    }
}
