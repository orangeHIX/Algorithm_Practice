package com.creaty.javaclass.student_managment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyx on 2015/12/6.
 */
public class StudentManagerWithMySQL implements IStudentManager {

    public static final String TABLE_NAME = "students";

    Connection connection;

    PreparedStatement addStatement;

    PreparedStatement removeStatement;
    PreparedStatement removeByIDStatement;
    PreparedStatement removeByNameStatement;
    PreparedStatement removeByTelStatement;

    PreparedStatement updateIDStatement;
    PreparedStatement updateNameStatement;
    PreparedStatement updateTelStatement;

    PreparedStatement findAllStatement;
    PreparedStatement findByIDStatement;
    PreparedStatement findByNameStatement;
    PreparedStatement findByTelStatement;


    static {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StudentManagerWithMySQL() {
        super();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/student?" +
                    "user=root&password=123456");
            addStatement = connection.prepareStatement(
                    "INSERT INTO students (id, name, tel) VALUES (?,?,?)");
            removeStatement = connection.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE id = ? AND name = ? AND tel = ?");
            removeByIDStatement = connection.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE id = ?");
            removeByNameStatement = connection.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE name = ?");
            removeByTelStatement = connection.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE tel = ?");
            updateIDStatement = connection.prepareStatement("UPDATE " + TABLE_NAME + " SET id = ? WHERE id = ?");
            updateNameStatement = connection.prepareStatement("UPDATE " + TABLE_NAME + " SET name = ? WHERE id = ?");
            updateTelStatement = connection.prepareStatement("UPDATE " + TABLE_NAME + " SET tel = ? WHERE id = ?");
            findAllStatement = connection.prepareStatement("SELECT id, name, tel FROM " + TABLE_NAME);
            findByIDStatement = connection.prepareStatement("SELECT id, name, tel FROM " + TABLE_NAME + " WHERE id =?");
            findByNameStatement = connection.prepareStatement("SELECT id, name, tel FROM " + TABLE_NAME + " WHERE name =?");
            findByTelStatement = connection.prepareStatement("SELECT id, name, tel FROM " + TABLE_NAME + " WHERE tel =?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addStudent(Student student) {
        if (addStatement != null && student != null) {
            try {
                addStatement.setString(1, student.ID);
                addStatement.setString(2, student.name);
                addStatement.setString(3, student.tel);
                return addStatement.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean removeStudent(Student student) {
        if (removeStatement != null && student != null) {
            try {
                removeStatement.setString(1, student.ID);
                removeStatement.setString(2, student.name);
                removeStatement.setString(3, student.tel);
                return removeStatement.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean removeStudentByID(String ID) {
        if (removeByIDStatement != null && ID != null) {
            try {
                removeByIDStatement.setString(1, ID);
                return removeByIDStatement.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean removeStudentByTel(String tel) {
        if (removeByTelStatement != null && tel != null) {
            try {
                removeByTelStatement.setString(1, tel);
                return removeByTelStatement.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean removeStudentByName(String name) {
        if (removeByNameStatement != null && name != null) {
            try {
                removeByNameStatement.setString(1, name);
                return removeByNameStatement.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    private Student updateStudentField(PreparedStatement statement, String ID, String field) {
        if (statement != null && ID != null && field != null) {
            try {
                statement.setString(1, field);
                statement.setString(2, ID);
                if (statement.executeUpdate() > 0) {
                    return findStudentByID(ID);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Student updateStudentID(String ID, String newID) {
        return updateStudentField(updateIDStatement, ID, newID);
    }

    @Override
    public Student updateStudentName(String ID, String newName) {
        return updateStudentField(updateNameStatement, ID, newName);
    }

    @Override
    public Student updateStudentTel(String ID, String newTel) {
        return updateStudentField(updateTelStatement, ID, newTel);
    }

    /**
     * @param field 如果 field == null ，将会找到所有结果
     */
    private List<Student> findStudent(PreparedStatement statement, String field) {
        List<Student> list = new ArrayList<>();
        if (statement != null) {
            try {
                if (field != null) {
                    statement.setString(1, field);
                }
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    list.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3)));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public Student findStudentByID(String id) {
        List<Student> list = findStudent(findByIDStatement, id);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Student> findStudentByTel(String tel) {
        return findStudent(findByTelStatement, tel);
    }

    @Override
    public List<Student> findStudentByName(String name) {
        return findStudent(findByNameStatement, name);
    }

    @Override
    public String getStudentListString() {
        return "studentList=" + findStudent(findAllStatement, null);
    }

    public void printStudentList() {
        System.out.println(getStudentListString());
    }

    @Override
    public String toString() {
        return getStudentListString();
    }

    public static void main(String[] args) {
        StudentManagerWithMySQL sm = new StudentManagerWithMySQL();
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

        sm.removeStudentByName("李四");
        sm.printStudentList();
    }
}
