package com.creaty.javaclass.student_managment.RPC;

import com.creaty.javaclass.student_managment.RPC.RPCServer;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Created by hyx on 2016/1/15.
 */
public class RPCServerThread implements Runnable{

    Socket socket;

    public RPCServerThread(Socket socket) throws IOException{
        this.socket = socket;
    }

    @Override
    public void run() {

        try (ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream())
        ){

            String interfacename = input.readUTF();
            String methodName = input.readUTF();

            Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
            Object[] arguments = (Object[])input.readObject();

            Class serviceinterfaceclass = Class.forName(interfacename);

            Object service = RPCServer.getServices().get(interfacename);

            Method method = null;
            method = serviceinterfaceclass.getMethod(methodName, parameterTypes);
            Object result = method.invoke(service, arguments);

            output.writeObject(result);
        } catch (Exception e){
            e.printStackTrace();
        }

        if(socket != null){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
