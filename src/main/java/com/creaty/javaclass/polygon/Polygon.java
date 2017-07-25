package com.creaty.javaclass.polygon;

import java.util.ArrayList;

/**
 * Created by hyx on 2015/11/8.
 */
abstract public class Polygon {
    protected ArrayList<Double> sideLengths;

    protected Polygon(double... sideLength) {
        sideLengths = new ArrayList<>();
        for (double side : sideLength) {
            if (side < 0) {
                throw new IllegalArgumentException("" + side);
            } else {
                sideLengths.add(side);
            }
        }
    }

    public abstract double getArea();

    public double getPerimeter() {
        return sideLengths.stream().reduce(0.0, Double::sum);
    }
}
