package com.lagou.pojo;

import java.io.Serializable;

/**
 * 引用对象应该去实现序列化接口，这样才能在远程调用的时候，实现序列化及反序列化，同时能在网络中传输
 */
public class User implements Serializable {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
