package com.creaty.javaclass.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by hyx on 2015/12/7.
 */
public class WriteObject {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"))) {
            Dog dog = new Dog("DuDu", 3);
            Person per = new Person("Lee", 23, dog);
            Person per2 = new Person("Kitty", 20, dog);
            oos.writeObject(per);
            oos.writeObject(per2);
            oos.writeObject(dog);
            oos.writeObject(per2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
