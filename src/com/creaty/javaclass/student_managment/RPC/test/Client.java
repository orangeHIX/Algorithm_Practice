package com.creaty.javaclass.student_managment.RPC.test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Created by hyx on 2015/12/23.
 */
public class Client {

    public static void main(String[] args){

        String interfacename = SayHelloService.class.getName();
        Socket socket = null;
        try {
            Method method = SayHelloService.class.getMethod("sayHello", java.lang.String.class);
            //Object[] arguments = {"hello"};
            socket = new Socket("127.0.0.1", 1234);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            output.writeUTF(interfacename);
            output.writeUTF(method.getName());
            output.writeObject(method.getParameterTypes());
            output.writeObject(new Object[]{"hello"});

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            Object result = input.readObject();
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
