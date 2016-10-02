package com.creaty.javaclass.server_client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by hyx on 2015/12/6.
 */
public class Server {

    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(30000);
            while (true){
                Socket s = ss.accept();
                PrintStream ps = new PrintStream(s.getOutputStream());
                SimpleDateFormat dateFormat = new SimpleDateFormat(("yyyy年MM月dd日 HH时mm分ss秒"));
                ps.println("服务器当前时间：" + dateFormat.format(new Date()));
                ps.close();
                s.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
