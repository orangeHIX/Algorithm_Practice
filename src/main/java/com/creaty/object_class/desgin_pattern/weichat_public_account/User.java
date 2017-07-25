package com.creaty.object_class.desgin_pattern.weichat_public_account;

/**
 * Created by hyx on 2015/11/22.
 */
public abstract class User {

    String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
