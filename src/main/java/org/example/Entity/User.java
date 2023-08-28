package org.example.Entity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2023/8/28
 * @Author: Administrator
 * @ClassName: User
 * @Description: comment here
 */

public class User {

    private String name;
    private int age;
    private String[] hobbies;
    private List<String> friends;
    private Map<String, String> parents;
    private Address address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public void setParents(Map<String, String> parents) {
        this.parents = parents;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", friends=" + friends +
                ", parents=" + parents +
                ", address=" + address +
                '}';
    }
}
