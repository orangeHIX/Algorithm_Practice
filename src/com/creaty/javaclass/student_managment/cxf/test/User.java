package com.creaty.javaclass.student_managment.cxf.test;

/**
 * Created by hyx on 2016/1/15.
 */
public class User {
    String name;
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
