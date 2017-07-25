package com.creaty.javaclass.student_managment;

import java.io.Serializable;

/**
 * ����JAVA���Ͽ�ܣ���дһ���򵥵�ѧ������ϵͳ������ѧ����������ѧ�š��绰����Ȼ�����Ϣ��ʵ�ֻ�������/ɾ/��/��ȹ���
 * Created by hyx on 2015/11/12.
 */
public class Student implements Serializable {
    String name;
    String ID;
    String tel;

    public Student() {
    }

    public Student(String name, String ID, String tel) {
        this.name = name;
        this.ID = ID;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
