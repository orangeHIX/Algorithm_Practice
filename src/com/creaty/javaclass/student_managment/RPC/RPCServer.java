package com.creaty.javaclass.student_managment.RPC;

import com.creaty.javaclass.student_managment.IStudentManager;
import com.creaty.javaclass.student_managment.RPC.test.SayHelloService;
import com.creaty.javaclass.student_managment.RPC.test.SayHelloServiceImpl;
import com.creaty.javaclass.student_managment.StudentManagerInMemory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hyx on 2015/12/23.
 */
public class RPCServer {
    private static Map<String, Object> services;

    public RPCServer() {
        services = new HashMap<String, Object>();
        services.put(SayHelloService.class.getName(), new SayHelloServiceImpl());
        services.put(IStudentManager.class.getName(), new StudentManagerInMemory());    //服务器的StudentManager服务在内存中操作
    }

    public static Map getServices() {
        return services;
    }

    public void runServer() {
        ServerSocket server = null;
        try {
            server = new ServerSocket(1234);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Socket socket = null;
        ObjectInputStream input = null;
        ObjectOutputStream output = null;

        while (true) {
            try {
                socket = server.accept();
                System.out.println("accept socket:" + socket);
                new Thread(new RPCServerThread(socket)).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new RPCServer().runServer();
    }

}
