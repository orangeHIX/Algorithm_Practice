package com.creaty.javaclass.student_managment.RPC;

import com.creaty.javaclass.student_managment.IStudentManager;
import com.creaty.javaclass.student_managment.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.List;

/**
 * Created by hyx on 2016/1/15.
 */
public class StudentManagerRPC implements IStudentManager {

    public static final String IP_ADDRESS = "127.0.0.1";
    public static final int SOCKET_PORT = 1234;

    public static void main(String[] args) {
        StudentManagerRPC sm = new StudentManagerRPC();
        sm.addStudent(new Student("张三", "001", "123"));
        sm.addStudent(new Student("张三", "001", "123"));
        sm.addStudent(new Student("李四", "002", "124"));
        sm.addStudent(new Student("王五", "003", "125"));
        sm.addStudent(new Student("赵六", "004", "126"));
        sm.addStudent(new Student("张三", "005", "126"));
        sm.printStudentList();

        System.out.println("============findtest========================");

        System.out.println(sm.findStudentByID("000"));
        System.out.println(sm.findStudentByID("001"));
        System.out.println(sm.findStudentByID("005"));

        System.out.println(sm.findStudentByName("Micheal"));
        System.out.println(sm.findStudentByName("张三"));
        System.out.println(sm.findStudentByName("赵六"));

        System.out.println(sm.findStudentByTel("123"));
        System.out.println(sm.findStudentByTel("126"));
        System.out.println(sm.findStudentByTel("122"));

        System.out.println("============removetest========================");

        sm.removeStudentByID("001");
        sm.printStudentList();

        sm.removeStudentByID("000");
        sm.printStudentList();


        sm.removeStudentByTel("126");
        sm.printStudentList();

        sm.removeStudentByName("张三");
        sm.printStudentList();
    }

    @Override
    public boolean addStudent(Student student) {
        return (boolean) invoke("addStudent", new Class[]{Student.class}, student);
    }

    @Override
    public boolean removeStudent(Student student) {
        return (boolean) invoke("removeStudent", new Class[]{Student.class}, student);
    }

    @Override
    public boolean removeStudentByID(String ID) {
        return (boolean) invoke("removeStudentByID", new Class[]{String.class}, ID);
    }

    @Override
    public boolean removeStudentByTel(String tel) {
        return (boolean) invoke("removeStudentByTel", new Class[]{String.class}, tel);
    }

    @Override
    public boolean removeStudentByName(String name) {
        return (boolean) invoke("removeStudentByName", new Class[]{String.class}, name);
    }

    @Override
    public Student updateStudentID(String ID, String newID) {
        return (Student) invoke("updateStudentID", new Class[]{String.class, String.class}, ID, newID);
    }

    @Override
    public Student updateStudentName(String ID, String newName) {
        return (Student) invoke("updateStudentName", new Class[]{String.class, String.class}, ID, newName);
    }

    @Override
    public Student updateStudentTel(String ID, String newTel) {
        return (Student) invoke("updateStudentTel", new Class[]{String.class, String.class}, ID, newTel);
    }

    @Override
    public Student findStudentByID(String id) {
        return (Student) invoke("findStudentByID", new Class[]{String.class}, id);
    }

    @Override
    public List<Student> findStudentByTel(String tel) {
        return (List<Student>) invoke("findStudentByTel", new Class[]{String.class}, tel);
    }

    @Override
    public List<Student> findStudentByName(String name) {
        return (List<Student>) invoke("findStudentByName", new Class[]{String.class}, name);
    }

    @Override
    public String getStudentListString() {
        return (String) invoke("getStudentListString", null, null);
    }

    private Object invoke(String name, Class[] parameterTypes, Object... parameters) {
        Method method = null;
        try {
            method = IStudentManager.class.getMethod(name, parameterTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Object result = null;
        if (method != null) {
            try (Socket socket = new Socket(IP_ADDRESS, SOCKET_PORT);
                 ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream input = new ObjectInputStream(socket.getInputStream())
            ) {
                output.writeUTF(IStudentManager.class.getName());
                output.writeUTF(method.getName());
                output.writeObject(method.getParameterTypes());
                output.writeObject(parameters);

                result = input.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void printStudentList() {
        System.out.println(getStudentListString());
    }
}
