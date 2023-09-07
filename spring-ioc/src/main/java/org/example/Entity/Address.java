package org.example.Entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Date: 2023/8/28
 * @Author: Administrator
 * @ClassName: Address
 * @Description: comment here
 */

public class Address implements InitializingBean, DisposableBean {

    private String address_name;

    public void setAddress_name(String address_name) {
        System.out.println("Now address is setting address_name...");
        this.address_name = address_name;
    }

    public Address() {
        System.out.println("Address is initialized!");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Address is destroyed!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("这个方法会在属性填充完毕之后调用...");
    }
}
