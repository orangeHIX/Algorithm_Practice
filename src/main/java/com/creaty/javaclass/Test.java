package com.creaty.javaclass;

/**
 * Created by hyx on 2016/3/14.
 */

import java.util.Date;

public class Test extends Date {
    public static void main(String[] args) {
        new Test().test();
    }

    public void test() {
        System.out.println(super.getClass().getName());
    }
}
