package org.example;

import org.example.config.AppConfig;
import org.example.service.IActivityService;
import org.example.service.IOrderService;
import org.example.service.IUserService;
import org.example.service.impl.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Date: 2023/9/19
 * @Author: Administrator
 * @ClassName: app
 * @Description: comment here
 */

public class app {
    public static void main(String[] args) {
        // 用了配置类的话，需要导入配置类而不是配置文件
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        UserService userService = context.getBean(UserService.class);
        // 必须是用接口类型去获得这个Bean，目前的我无法理解
        IUserService userService = context.getBean(IUserService.class);
        IOrderService orderService = context.getBean(IOrderService.class);
        userService.register();
        orderService.order();

        // 引入Introduction
        IActivityService activityService = context.getBean(IActivityService.class);
        activityService.sendGift();
    }
}
