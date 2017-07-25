package com.creaty.javaclass.serializable;

import java.io.Serializable;

/**
 * Created by hyx on 2015/12/7.
 */
public class Dog implements Serializable {
    private String name;
    private int age;

    public Dog() {
    }

    public Dog(String name, int age) {
        this();
        this.name = name;
        this.age = age;
    }

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
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
