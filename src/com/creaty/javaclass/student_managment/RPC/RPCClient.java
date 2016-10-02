package com.creaty.javaclass.student_managment.RPC;

import com.creaty.javaclass.student_managment.Console;

/**
 * Created by hyx on 2016/1/15.
 */
public class RPCClient {

    public static void main(String[] args) {
        Console console = new Console(new StudentManagerRPC());
        console.start();
    }
}
