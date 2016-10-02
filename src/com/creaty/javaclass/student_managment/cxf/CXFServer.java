package com.creaty.javaclass.student_managment.cxf;

import com.creaty.javaclass.student_managment.IStudentManager;

import javax.xml.ws.Endpoint;

/**
 * Created by hyx on 2016/1/15.
 */
public class CXFServer {
    public static void main(String[] args) {
        System.out.println("web service start");
        IStudentManager implementor= new CXFStudentManagerInMemory();
        String address="http://localhost:8080/student_manager";
        Endpoint.publish(address, implementor);
        System.out.println("web service started");
    }
}
