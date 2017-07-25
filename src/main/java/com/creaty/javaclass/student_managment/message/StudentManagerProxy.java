package com.creaty.javaclass.student_managment.message;

import com.creaty.javaclass.student_managment.IStudentManager;
import com.creaty.javaclass.student_managment.Student;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by hyx on 2016/1/16.
 */
public class StudentManagerProxy implements IStudentManager {

    IStudentManager studentManager;

    public StudentManagerProxy(IStudentManager trueManager) {
        studentManager = trueManager;
    }

    @Override
    public boolean addStudent(Student student) throws RemoteException {
        if (studentManager.addStudent(student)) {
            try {
                MessageSender.send("added Student successfully: " + student);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean removeStudent(Student student) throws RemoteException {
        return studentManager.removeStudent(student);
    }

    @Override
    public boolean removeStudentByID(String ID) throws RemoteException {
        return studentManager.removeStudentByID(ID);
    }

    @Override
    public boolean removeStudentByTel(String tel) throws RemoteException {
        return studentManager.removeStudentByTel(tel);
    }

    @Override
    public boolean removeStudentByName(String name) throws RemoteException {
        return studentManager.removeStudentByName(name);
    }

    @Override
    public Student updateStudentID(String ID, String newID) throws RemoteException {
        return studentManager.updateStudentID(ID, newID);
    }

    @Override
    public Student updateStudentName(String ID, String newName) throws RemoteException {
        return studentManager.updateStudentName(ID, newName);
    }

    @Override
    public Student updateStudentTel(String ID, String newTel) throws RemoteException {
        return studentManager.updateStudentTel(ID, newTel);
    }

    @Override
    public Student findStudentByID(String id) throws RemoteException {
        return studentManager.findStudentByID(id);
    }

    @Override
    public List<Student> findStudentByTel(String tel) throws RemoteException {
        return studentManager.findStudentByTel(tel);
    }

    @Override
    public List<Student> findStudentByName(String name) throws RemoteException {
        return studentManager.findStudentByName(name);
    }

    @Override
    public String getStudentListString() throws RemoteException {
        return studentManager.getStudentListString();
    }
}
