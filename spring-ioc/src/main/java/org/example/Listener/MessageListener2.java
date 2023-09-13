package org.example.Listener;

import org.springframework.context.ApplicationListener;

/**
 * @Date: 2023/9/12
 * @Author: Administrator
 * @ClassName: MessageListener
 * @Description: comment here
 */

//@Component
public class MessageListener2 implements ApplicationListener<OrderEvent2> {
    @Override
    public void onApplicationEvent(OrderEvent2 event) {
        System.out.println("send an message to " + ((Order)event.getSource()).getUsername() + " whose orderId is " + ((Order)event.getSource()).getOrderId());
    }
}
