package com.dh;

import java.math.BigDecimal;

public class Circle extends Polygon {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }


    @Override
    public double calculatePerimeter()  {
        return new BigDecimal(getRadius()).multiply(new BigDecimal(2)).multiply(new BigDecimal(Math.PI)).doubleValue();
    }
}
