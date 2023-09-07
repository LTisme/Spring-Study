package org.example.Config;

import org.example.Entity.Address;
import org.example.Entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Date: 2023/9/6
 * @Author: Administrator
 * @ClassName: MyConfiguration
 * @Description: comment here
 */

@Component
public class MyConfiguration {

    @Bean
    @Qualifier("addr")
    public Address address(){
        return new Address();
    }

    //
    @Bean
    public User user(@Qualifier("addr") Address address){
        User user = new User();
        user.setAddress(address);
        return user;
    }
}
