package org.example.Listener;

import org.springframework.context.ApplicationEvent;

/**
 * @Date: 2023/9/12
 * @Author: Administrator
 * @ClassName: OderEvent
 * @Description: 如果另外建立一个数据源，就可以不用在事件上写繁琐操作了
 */

public class OrderEvent2 extends ApplicationEvent {

    public OrderEvent2(Order source) {
        super(source);
    }
}
