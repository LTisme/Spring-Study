package org.example.service.impl;

import org.example.service.IActivityService;

/**
 * @Date: 2023/9/21
 * @Author: Administrator
 * @ClassName: ActivityService
 * @Description: comment here
 */

public class ActivityService implements IActivityService {
    @Override
    public void sendGift() {
        System.out.println("送出了礼物");
    }
}
