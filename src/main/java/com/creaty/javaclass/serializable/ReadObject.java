package com.creaty.javaclass.serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Created by hyx on 2015/12/7.
 */
public class ReadObject {

    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"))) {
            Person per1 = (Person) ois.readObject();
            Person per2 = (Person) ois.readObject();
            Dog dog = (Dog) ois.readObject();
            Person per3 = (Person) ois.readObject();
            System.out.println(per1.getDog() == dog);
            System.out.println(per2.getDog() == dog);
            System.out.println(per2 == per3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
