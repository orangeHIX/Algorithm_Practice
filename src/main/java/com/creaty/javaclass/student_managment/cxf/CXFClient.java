package com.creaty.javaclass.student_managment.cxf;

import com.creaty.javaclass.student_managment.Console;
import com.creaty.javaclass.student_managment.IStudentManager;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hyx on 2016/1/15.
 */
public class CXFClient {
    public static void main(String args[]) {

        URL wsdlURL = null;
        try {
            wsdlURL = new URL("http://localhost:8080/student_manager?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        QName SERVICE_NAME = new QName("http://cxf.student_managment.javaclass.creaty.com/", "IStudentManager");
        Service service = Service.create(wsdlURL, SERVICE_NAME);
        IStudentManager hw = service.getPort(IStudentManager.class);
        Console console = new Console(hw);
        console.start();
    }
}
