package com.creaty.practice;

import java.util.ArrayList;

class A {
    public int i;

    @Override
    public String toString() {
        return "A{" +
                "i=" + i +
                '}';
    }
}

public class ArrayListConfuse {

    public static void main(String[] args) {

        A a = new A();
        a.i = 3;

        ArrayList<A> list1 = new ArrayList<>();
        list1.add(a);

        ArrayList<A> list2 = new ArrayList<>();
        list2.addAll(list1);

        System.out.println("before:");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list1);

        a.i = 5;

        System.out.println("after:");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list1);
    }
}
