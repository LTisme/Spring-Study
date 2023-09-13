package org.example.Listener;

import org.springframework.context.event.EventListener;

/**
 * @Date: 2023/9/12
 * @Author: Administrator
 * @ClassName: EmailListener
 * @Description: comment here
 */

//@Component
public class EmailListener3{
    @EventListener
    public void onApplicationEvent(OrderEvent2 event) {
        System.out.println("send an email to " + ((Order)event.getSource()).getUsername() + " whose orderId is " + ((Order)event.getSource()).getOrderId());
    }
}
