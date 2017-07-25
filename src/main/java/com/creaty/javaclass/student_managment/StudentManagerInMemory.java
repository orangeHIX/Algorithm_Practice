package com.creaty.javaclass.student_managment;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by hyx on 2015/11/12.
 */
public class StudentManagerInMemory implements IStudentManager {
    protected ArrayList<Student> studentArrayList;

    public StudentManagerInMemory() {
        super();
        studentArrayList = new ArrayList<>();
    }

    @Override
    public boolean addStudent(Student student) {
        if (findStudentByID(student.ID) == null) {
            return studentArrayList.add(student);
        }
        return false;
    }

    @Override
    public boolean removeStudent(Student student) {
        return studentArrayList.remove(student);
    }

    @Override
    public boolean removeStudentByID(String ID) {
        return studentArrayList.removeIf(s -> s.ID.compareTo(ID) == 0);
    }

    @Override
    public boolean removeStudentByTel(String tel) {
        return studentArrayList.removeIf(s -> s.tel.compareTo(tel) == 0);
    }

    @Override
    public boolean removeStudentByName(String name) {
        return studentArrayList.removeIf(s -> s.name.compareTo(name) == 0);
    }

    @Override
    public Student updateStudentID(String ID, String newID) {
        Student s = findStudentByID(ID);
        if (s != null) {
            s.ID = newID;
        }
        return s;
    }

    @Override
    public Student updateStudentName(String ID, String newName) {
        Student s = findStudentByID(ID);
        if (s != null) {
            s.name = newName;
        }
        return s;
    }

    @Override
    public Student updateStudentTel(String ID, String newTel) {
        Student s = findStudentByID(ID);
        if (s != null) {
            s.tel = newTel;
        }
        return s;
    }

    @Override
    public Student findStudentByID(String id) {
        try {
            return studentArrayList.stream().filter(s -> s.ID.compareTo(id) == 0).findFirst().get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public List<Student> findStudentByTel(String tel) {
        ArrayList<Student> list = new ArrayList<>();
        studentArrayList.stream().filter(s -> s.tel.compareTo(tel) == 0).forEach(list::add);
        return list;
    }

    @Override
    public List<Student> findStudentByName(String name) {
        ArrayList<Student> list = new ArrayList<>();
        studentArrayList.stream().filter(s -> s.name.compareTo(name) == 0).forEach(list::add);
        return list;
    }

    @Override
    public String getStudentListString() {
        return this.toString();
    }

    public void printStudentList() {
        System.out.println(getStudentListString());
    }


    @Override
    public String toString() {
        return "studentList=" + studentArrayList;
    }

    public static void main(String[] args) throws RemoteException {
        StudentManagerInMemory sm = new StudentManagerInMemory();
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
}
