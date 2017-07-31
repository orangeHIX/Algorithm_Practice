package com.creaty.javaclass.student_managment;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by hyx on 2015/11/12.
 */
public class Console {

    public static final String DESCIPTION = "Welcome!\nYou can use this student management system by command:\n" +
            "1. \"add\" command: add one student.  e.g.\"add Micheal 20150299 13658996591\"\n" +
            "2. \"remove\" command: remove one student by some means, such as \"name(-n)\", \"id(-i)\" and \"tel(-t)\"" +
            "  e.g.\"remove -i 20150295\"\n" +
            "3. \"update\" command: update one student information using ID. these information could be \"name(-n)\", \"id(-i)\" and \"tel(-t)\"" +
            "  e.g.\"update 20152365 -n June\"\n" +
            "4. \"find\" command: find one student by some means, such as \"name(-n)\", \"id(-i)\" and \"tel(-t)\"" +
            "  e.g.\"find -i 20150295\"\n" +
            "5. \"print\" command: print all students information in system\n" +
            "6. \"exit\" command: exit from this system";
    public static final String ADD = "add";
    public static final String REMOVE = "remove";
    public static final String UPDATE = "update";
    public static final String FIND = "find";
    public static final String PRINT = "print";
    public static final String EXIT = "exit";
    public static final String BY = "-";
    public static final String BY_ID = BY + "i";
    public static final String BY_NAME = BY + "n";
    public static final String BY_TEL = BY + "t";
    public static final String[] options;
    public static final String[] commands;

    static {
        commands = new String[]{ADD, REMOVE, UPDATE, FIND, PRINT, EXIT};
        options = new String[]{BY_ID, BY_NAME, BY_TEL};
    }

    Scanner scanner;
    PrintStream printStream;
    private IStudentManager studentManager;
    private List<Student> curr;

    public Console() {
        this(new StudentManagerInMemory(), System.in, System.out);
    }

    public Console(IStudentManager iStudentManager) {
        this(iStudentManager, System.in, System.out);
    }

    public Console(IStudentManager studentManager, InputStream inputStream, OutputStream outputStream) {
        this.studentManager = studentManager;
        scanner = new Scanner(inputStream);
        if (outputStream instanceof PrintStream) {
            printStream = (PrintStream) outputStream;
        } else {
            printStream = new PrintStream(outputStream);
        }
    }

    public static void main(String[] args) {
        Console console = new Console(new StudentManagerInMemory());
        console.start();
    }

    public void start() {
        if (scanner != null) {
            log(DESCIPTION);
            try {
                handleInputArgs();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            scanner.close();
            log("exit!");
        } else {
            logError("scanner is null!");
        }
    }

    private void addStudent(String... args) throws RemoteException {
        if (args.length > 1) {
            Student s = new Student(args[1], args[2], args[3]);
            curr = new ArrayList<>();
            curr.add(s);
            if (studentManager.addStudent(s)) {
                logHint("successfully add the student: " + s);
            } else {
                logHint("fail to add the student" + s);
            }
        } else {
            logError("missing argument..." + Arrays.toString(args) + " e.g.\"add Micheal 20150299 13658996591\"");
        }

    }

    private void removeStudent(String... args) throws RemoteException {
        if (args.length > 2) {
            boolean isSucceed = false;
            switch (args[1]) {
                case BY_ID:
                    isSucceed = studentManager.removeStudentByID(args[2]);
                    break;
                case BY_NAME:
                    isSucceed = studentManager.removeStudentByName(args[2]);
                    break;
                case BY_TEL:
                    isSucceed = studentManager.removeStudentByTel(args[2]);
                    break;
                default:
                    logError("missing valid option argument like " + Arrays.toString(options) + "..." + Arrays.toString(args));
            }
            if (isSucceed) {
                logHint("successfully removed the student!");
            } else {
                logHint("fail to remove student by " + args[1] + " with " + args[2]);
            }
        } else {
            logError("missing necessary arguments..." + Arrays.toString(args) + " e.g.\"remove -i 20150295\"");
        }
    }

    private void updateStudent(String... args) throws RemoteException {
        if (args.length > 3) {
            Student stu = null;
            switch (args[2]) {
                case BY_ID:
                    stu = studentManager.updateStudentID(args[1], args[3]);
                    break;
                case BY_NAME:
                    stu = studentManager.updateStudentName(args[1], args[3]);
                    break;
                case BY_TEL:
                    stu = studentManager.updateStudentTel(args[1], args[3]);
                    break;
                default:
                    logError("missing valid option argument like " + Arrays.toString(options) + "..." + Arrays.toString(args));
            }
            if (stu != null) {
                curr = new ArrayList<>();
                curr.add(stu);
                logHint("successfully update the student(id:" + args[1] + "):" + stu);
            } else {
                logHint("fail to update student by " + args[2] + " with " + args[3]);
            }
        } else {
            logError("missing necessary arguments..." + Arrays.toString(args) + " e.g.\"update 20090266 -n Jack\"");
        }
    }

    private void findStudent(String... args) throws RemoteException {
        if (args.length > 2) {
            boolean isSucceed = false;
            Student s;
            switch (args[1]) {
                case BY_ID:
                    if ((s = studentManager.findStudentByID(args[2])) != null) {
                        isSucceed = true;
                        curr = new ArrayList<>();
                        curr.add(s);
                    }
                    break;
                case BY_NAME:
                    curr = studentManager.findStudentByName(args[2]);
                    if (curr != null && !curr.isEmpty()) {
                        isSucceed = true;
                    }
                    break;
                case BY_TEL:
                    curr = studentManager.findStudentByTel(args[2]);
                    if (curr != null && !curr.isEmpty()) {
                        isSucceed = true;
                    }
                    break;
                default:
                    logError("missing valid option argument like " + Arrays.toString(options) + "..." + Arrays.toString(args));
            }
            if (isSucceed) {
                logHint("successfully find the student!" + curr);
            } else {
                logHint("fail to find the student by " + args[1] + " with " + args[2]);
            }
        } else {
            logError("missing necessary arguments..." + Arrays.toString(args) + " e.g.\"find -i 20150295\"");
        }
    }
//
//    private boolean checkArguments(String[] args, String expectCommand) {
//        if (args.length > 0 && args[0] == expectCommand) {
//            return true;
//        }
//        return false;
//    }

    private void printStudent(String... args) throws RemoteException {
        log("student list: ");
        log(studentManager.getStudentListString());
    }

    private void handleInputArgs() throws RemoteException {
        String command;
        String[] tokens;
        log("You can input command (like " + Arrays.toString(commands) + ") now:");
        command = scanner.nextLine();
        //System.out.println(""+command.compareTo(EXIT));
        while (command.compareTo(EXIT) != 0) {
            tokens = command.split("\\s+");
            if (tokens.length > 0) {
                switch (tokens[0]) {
                    case ADD:
                        addStudent(tokens);
                        break;
                    case REMOVE:
                        removeStudent(tokens);
                        break;
                    case UPDATE:
                        updateStudent(tokens);
                        break;
                    case FIND:
                        findStudent(tokens);
                        break;
                    case PRINT:
                        printStudent(tokens);
                        break;
                    default:
                        logError("unknown command... \"" + tokens[0] + "\"");
                }
            }
            command = scanner.nextLine();
        }
    }

    public void log(String info) {
        if (printStream != null) {
            printStream.println(info);
        }
    }

    public void logHint(String info) {
        log("hint: " + info);
    }

    public void logError(String info) {
        log("error: " + info);
    }
}
