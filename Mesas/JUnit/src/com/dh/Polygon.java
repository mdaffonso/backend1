package com.dh;

import java.math.BigDecimal;

public abstract class Polygon {

    private double perimeter;

    public abstract double calculatePerimeter();

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
}
