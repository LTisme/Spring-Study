package org.example.service.impl;

import org.example.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * @Date: 2023/9/19
 * @Author: Administrator
 * @ClassName: OrderService
 * @Description: comment here
 */

@Service
public class OrderService implements IOrderService {
    @Override
    public void order() {
        System.out.println("这是order的方法");
    }
}
