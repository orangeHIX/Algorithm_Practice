package com.creaty.javaclass.polygon;

/**
 * Created by hyx on 2015/11/8.
 */
public class Rectangle extends Polygon {

    private double width;
    private double length;

    public Rectangle(double width, double length) {
        super(width, length, width, length);
        this.width = width;
        this.length = length;
    }

    public Rectangle(double length) {
        this(length, length);
    }

    @Override
    public double getArea() {
        return width * length;
    }

    public static void main(String[] args){
        Polygon p = new Rectangle(3,4);
        System.out.println(""+p.getArea()+", "+p.getPerimeter());
    }
}
