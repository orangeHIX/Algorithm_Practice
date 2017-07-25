package com.creaty.javaclass.student_managment.RPC.test;

/**
 * Created by hyx on 2015/12/23.
 */
public class SayHelloServiceImpl implements SayHelloService {
    @Override
    public String sayHello(String helloArg) {
        if (helloArg.equals("hello")) {
            return "hello";
        } else {
            return "bye bye";
        }

    }
}
