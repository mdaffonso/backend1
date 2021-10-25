package com.dh;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CircleTest {
    static List<Polygon> circles = new ArrayList<>();

    @BeforeAll
    public static void doBefore() {
        Collections.addAll(circles,
                new Circle(1),
                new Circle(2),
                new Circle(155));
    }

    @Test
    public void circlePerimeter() {
        Assertions.assertEquals(2 * Math.PI, circles.get(0).calculatePerimeter());
        Assertions.assertEquals(4 * Math.PI, circles.get(1).calculatePerimeter());
        Assertions.assertEquals(310 * Math.PI, circles.get(2).calculatePerimeter());
    }
}
