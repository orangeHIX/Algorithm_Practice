package com.creaty.javaclass.polygon;

/**
 * Created by hyx on 2015/11/8.
 */
public class Triangle extends Polygon {

    private double a;
    private double b;
    private double c;

    public Triangle(double sideA, double sideB, double sideC) {
        super(sideA, sideB, sideC);
        double maxSideLen = Math.max(Math.max(sideA, sideB), sideC);
        if (2 * maxSideLen - sideA - sideB - sideC > 0) {
            throw new IllegalArgumentException("can not construct a triangle");
        } else {
            a = sideA;
            b = sideB;
            c = sideC;
        }
    }

    @Override
    public double getArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }


    public static void main(String[] args){
        Polygon p = new Triangle(3,1,2);
        System.out.println(""+p.getArea()+", "+p.getPerimeter());
    }
}
