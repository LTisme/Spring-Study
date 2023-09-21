package org.example;

import org.example.service.IOrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Date: 2023/9/21
 * @Author: Administrator
 * @ClassName: appByXml
 * @Description: comment here
 */

public class appByXml {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        IOrderService orderService = context.getBean(IOrderService.class);
        orderService.order();
    }
}
