package com.creaty.javaclass.student_managment.RMI;

import com.creaty.javaclass.student_managment.IStudentManager;
import com.creaty.javaclass.student_managment.Console;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by hyx on 2016/1/15.
 */
public class PMIClient {

    public static void main(String[] args){
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }
        try {
            String name = IStudentManager.class.getName();
            Registry registry = LocateRegistry.getRegistry();
            IStudentManager studentManager = (IStudentManager)registry.lookup(name);

            Console studentManagementConsole = new Console(studentManager);
            studentManagementConsole.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
