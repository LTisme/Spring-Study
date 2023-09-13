package org.example.Listener;

import org.springframework.context.ApplicationEvent;

/**
 * @Date: 2023/9/12
 * @Author: Administrator
 * @ClassName: OderEvent
 * @Description: 用这个下单事件来了解下单机制
 */

public class OrderEvent extends ApplicationEvent {

    private String orderId;
    private String username;

    public OrderEvent(Object source) {
        super(source);
    }

    public OrderEvent(Object source, String orderId, String username) {
        super(source);
        this.orderId = orderId;
        this.username = username;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUsername() {
        return username;
    }
}
