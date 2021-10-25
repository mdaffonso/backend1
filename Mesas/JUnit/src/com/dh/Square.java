package com.dh;

import java.math.BigDecimal;

public class Square extends Polygon {

    private double edge;

    public Square(double edge) {
        this.edge = edge;
    }

    public double getEdge() {
        return edge;
    }

    @Override
    public double calculatePerimeter() {
        return getEdge() * 4;
    }
}
