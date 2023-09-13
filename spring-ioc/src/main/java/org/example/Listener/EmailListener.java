package org.example.Listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Date: 2023/9/12
 * @Author: Administrator
 * @ClassName: EmailListener
 * @Description: comment here
 */

//@Component
public class EmailListener implements ApplicationListener<OrderEvent> {
    @Override
    public void onApplicationEvent(OrderEvent event) {
        System.out.println("send an email to " + event.getUsername() + " whose orderId is " + event.getOrderId());
    }
}
