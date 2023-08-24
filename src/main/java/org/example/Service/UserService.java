package org.example.Service;

import org.example.Dao.AddressDao;
import org.example.Dao.UserDao;

/**
 * @Date: 2023/8/22
 * @Author: LTisme
 * @ClassName: UserService
 * @Description: --->
 */

public class UserService {

    private UserDao userDao;

    private AddressDao addressDao;

    public UserService(){}

    public UserService(UserDao userDao, AddressDao addressDao){
        this.userDao = userDao;
        this.addressDao = addressDao;
    }

    // 采用单例模式
    private static final UserService userService = new UserService();

    public static UserService getService(){
        return userService;
    }

    public UserDao create(){
        return new UserDao();
    }
}
