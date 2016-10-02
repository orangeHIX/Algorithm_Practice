package com.creaty.javaclass.student_managment.cxf.test;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by hyx on 2016/1/15.
 */
@WebService
public interface HelloWorld {
    String sayHi(/*@WebParam(name="text")*/String text);

    User sayHiToUser(User user);

    String[] SayHiToUserList(List<User> userList);
}
