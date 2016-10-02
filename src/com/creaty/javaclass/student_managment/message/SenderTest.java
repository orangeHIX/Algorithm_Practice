package com.creaty.javaclass.student_managment.message;

import com.creaty.javaclass.student_managment.Console;
import com.creaty.javaclass.student_managment.StudentManagerInMemory;

/**
 * Created by hyx on 2016/1/16.
 */
public class SenderTest {

    public static void main(String[] args){
        Console console = new Console(new StudentManagerProxy(new StudentManagerInMemory()));
        console.start();
    }
}
