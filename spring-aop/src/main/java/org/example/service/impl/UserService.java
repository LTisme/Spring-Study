package org.example.service.impl;

import org.example.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Date: 2023/9/19
 * @Author: Administrator
 * @ClassName: UserService
 * @Description: comment here
 */

@Service
public class UserService implements IUserService {
    @Override
    public void register() {
        System.out.println("这是register的方法");
    }
}
