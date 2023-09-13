package org.example.Listener;

import org.springframework.context.ApplicationEvent;

/**
 * @Date: 2023/9/12
 * @Author: Administrator
 * @ClassName: OderEvent
 * @Description: 用这个下单事件来了解下单机制
 */

public class Order{

    private String orderId;
    private String username;

    public Order(String orderId, String username) {
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
