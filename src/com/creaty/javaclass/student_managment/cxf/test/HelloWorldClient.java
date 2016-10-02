package com.creaty.javaclass.student_managment.cxf.test;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * Created by hyx on 2016/1/15.
 */
public class HelloWorldClient {

    public static void main(String[] args) {
        URL wsdlURL = null;
        try {
            wsdlURL = new URL("http://localhost:8080/helloWorld?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        QName SERVICE_NAME = new QName("http://cxf.student_managment.javaclass.creaty.com/", "HelloWorld");
        Service service = Service.create(wsdlURL, SERVICE_NAME);
        HelloWorld hw = service.getPort(HelloWorld.class);
        User user = new User();
        user.setName("Tony");
        user.setDescription("test");
        System.out.println(hw.sayHiToUser(user));
        //String result = client.greetMe("test");
    }

}
