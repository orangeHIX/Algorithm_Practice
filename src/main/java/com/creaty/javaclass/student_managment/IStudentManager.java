package com.creaty.javaclass.student_managment;

import javax.jws.WebService;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by hyx on 2015/12/6.
 */
@WebService
public interface IStudentManager extends Remote {

    boolean addStudent(Student student) throws RemoteException;

    boolean removeStudent(Student student) throws RemoteException;

    boolean removeStudentByID(String ID) throws RemoteException;

    boolean removeStudentByTel(String tel) throws RemoteException;

    boolean removeStudentByName(String name) throws RemoteException;

    Student updateStudentID(String ID, String newID) throws RemoteException;

    Student updateStudentName(String ID, String newName) throws RemoteException;

    Student updateStudentTel(String ID, String newTel) throws RemoteException;

    Student findStudentByID(String id) throws RemoteException;

    List<Student> findStudentByTel(String tel) throws RemoteException;

    List<Student> findStudentByName(String name) throws RemoteException;

    String getStudentListString() throws RemoteException;
}
