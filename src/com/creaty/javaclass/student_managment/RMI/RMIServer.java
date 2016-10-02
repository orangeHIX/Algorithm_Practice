package com.creaty.javaclass.student_managment.RMI;

import com.creaty.javaclass.student_managment.IStudentManager;
import com.creaty.javaclass.student_managment.StudentManagerInMemory;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by hyx on 2016/1/15.
 */
public class RMIServer {

    public static void main(String[] args) {
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }
        try {
            String name = IStudentManager.class.getName();
            IStudentManager studentManager = new StudentManagerInMemory();
            IStudentManager stub = (IStudentManager) UnicastRemoteObject
                    .exportObject(studentManager, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind(name, stub);
            System.out.println("StudentManager bound");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
