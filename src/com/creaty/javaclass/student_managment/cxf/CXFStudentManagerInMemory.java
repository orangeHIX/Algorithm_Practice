package com.creaty.javaclass.student_managment.cxf;

import com.creaty.javaclass.student_managment.StudentManagerInMemory;

import javax.jws.WebService;

/**
 * Created by hyx on 2016/1/15.
 */
@WebService(endpointInterface="com.creaty.javaclass.student_managment.IStudentManager", serviceName="IStudentManager")
public class CXFStudentManagerInMemory extends StudentManagerInMemory {
}
