package com.creaty.javaclass.json;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;

/**
 * Created by hyx on 2015/12/8.
 */
class TestClass {

    byte a;
    short b;
    int c;
    long d;
    //@MySerialize
    float e;
    //@MySerialize
    double f;
    char g;
    boolean h;

    Byte a1;
    Short b2;
    Integer c3;
    Long d4;
    Float e5;
    //@MySerialize
    Double f6;
    //@MySerialize
    Character g7;
    Boolean h8;

    //@MySerialize
    String i9;

    //@MySerialize
    int[] array;
    @MySerialize
    TestClass testClass2;

    public TestClass(){

    }
    public TestClass(byte a, short b, int c, long d, float e,
                     double f, char g, boolean h,
                     Byte a1, Short b2, Integer c3, Long d4,
                     Float e5, Double f6, Character g7, Boolean h8, String i9) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.a1 = a1;
        this.b2 = b2;
        this.c3 = c3;
        this.d4 = d4;
        this.e5 = e5;
        this.f6 = f6;
        this.g7 = g7;
        this.h8 = h8;
        this.i9 = i9;
    }

    public TestClass(byte a, short b, int c, long d, float e,
                     double f, char g, boolean h,
                     Byte a1, Short b2, Integer c3, Long d4,
                     Float e5, Double f6, Character g7, Boolean h8, String i9,
                     int[] array) {
        this(a,b,c,d,e,f,g,h,a1,b2,c3,d4,e5,f6,g7,h8,i9);
        this.array = array;
    }

    public TestClass(byte a, short b, int c, long d, float e,
                     double f, char g, boolean h,
                     Byte a1, Short b2, Integer c3, Long d4,
                     Float e5, Double f6, Character g7, Boolean h8, String i9,
                     int[] array, TestClass testclass2) {
        this(a,b,c,d,e,f,g,h,a1,b2,c3,d4,e5,f6,g7,h8,i9,array);
        this.testClass2 = testclass2;
    }

    public byte getA() {
        return a;
    }

    public void setA(byte a) {
        this.a = a;
    }

    public short getB() {
        return b;
    }

    public void setB(short b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public long getD() {
        return d;
    }

    public void setD(long d) {
        this.d = d;
    }

    public float getE() {
        return e;
    }

    public void setE(float e) {
        this.e = e;
    }

    public double getF() {
        return f;
    }

    public void setF(double f) {
        this.f = f;
    }

    public char getG() {
        return g;
    }

    public void setG(char g) {
        this.g = g;
    }

    public boolean isH() {
        return h;
    }

    public void setH(boolean h) {
        this.h = h;
    }

    public Byte getA1() {
        return a1;
    }

    public void setA1(Byte a1) {
        this.a1 = a1;
    }

    public Short getB2() {
        return b2;
    }

    public void setB2(Short b2) {
        this.b2 = b2;
    }

    public Integer getC3() {
        return c3;
    }

    public void setC3(Integer c3) {
        this.c3 = c3;
    }

    public Long getD4() {
        return d4;
    }

    public void setD4(Long d4) {
        this.d4 = d4;
    }

    public Float getE5() {
        return e5;
    }

    public void setE5(Float e5) {
        this.e5 = e5;
    }

    public Double getF6() {
        return f6;
    }

    public void setF6(Double f6) {
        this.f6 = f6;
    }

    public Character getG7() {
        return g7;
    }

    public void setG7(Character g7) {
        this.g7 = g7;
    }

    public Boolean getH8() {
        return h8;
    }

    public void setH8(Boolean h8) {
        this.h8 = h8;
    }

    public String getI9() {
        return i9;
    }

    public void setI9(String i9) {
        this.i9 = i9;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public TestClass getTestClass2() {
        return testClass2;
    }

    public void setTestClass2(TestClass testClass2) {
        this.testClass2 = testClass2;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", e=" + e +
                ", f=" + f +
                ", g=" + g +
                ", h=" + h +
                ", a1=" + a1 +
                ", b2=" + b2 +
                ", c3=" + c3 +
                ", d4=" + d4 +
                ", e5=" + e5 +
                ", f6=" + f6 +
                ", g7=" + g7 +
                ", h8=" + h8 +
                ", i9='" + i9 + '\'' +
                ", array=" + Arrays.toString(array) +
                ", testClass2=" + testClass2 +
                '}';
    }

    public static void main(String[] args) {
        try {
            TestClass t = new TestClass((byte) 1, (short) 1, 1, 1, 1.0f, 1.0, 'a', true,
                    (byte) 1, (short) 1, 1, 1l, 1.0f, 1.0, 'a', true,
                    "str", new int[]{1, 2, 3});

            String josnString = MyJSONObject.toJSONString(t);
            System.out.println(josnString);


            TestClass t2 = (TestClass)MyJSONObject.toObject(TestClass.class, josnString);
            System.out.println(t2);

            TestClass t3 = new TestClass((byte) 1, (short) 1, 1, 1, 1.0f, 1.0, 'a', true,
                    (byte) 1, (short) 1, 1, 1l, 1.0f, 1.0, 'a', true,
                    "str", new int[]{1, 2, 3}, t);

            String jsonString2 = MyJSONObject.toJSONString(t3);
            System.out.println(jsonString2);


            TestClass t4 = (TestClass) MyJSONObject.toObject(TestClass.class, jsonString2);
            System.out.println(t4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
