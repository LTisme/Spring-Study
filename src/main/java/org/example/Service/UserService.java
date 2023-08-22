package org.example.Service;

import org.example.Dao.UserDao;

/**
 * @Date: 2023/8/22
 * @Author: LTisme
 * @ClassName: UserService
 * @Description: --->
 */

public class UserService {

    // 采用单例模式
    private static final UserService userService = new UserService();

    public static UserService getService(){
        return userService;
    }

    public UserDao create(){
        return new UserDao();
    }
}
