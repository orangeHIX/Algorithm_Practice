package com.creaty.javaclass.student_managment.cxf.test;

import javax.xml.ws.Endpoint;

/**
 * Created by hyx on 2016/1/15.
 */
public class webServiceApp {
    public static void main(String[] args) {
        System.out.println("web service start");
        HelloWorldImpl implementor = new HelloWorldImpl();
        String address = "http://localhost:8080/helloWorld";
        Endpoint.publish(address, implementor);
        System.out.println("web service started");
    }
}
