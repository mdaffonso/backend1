package com.dh;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SquareTest {

    static List<Polygon> squares = new ArrayList<>();

    @BeforeAll
    public static void doBefore() {
        Collections.addAll(squares,
                new Square(1),
                new Square(2),
                new Square(155));
    }

    @Test
    public void squarePerimeter() {
        Assertions.assertEquals(4, squares.get(0).calculatePerimeter());
        Assertions.assertEquals(8, squares.get(1).calculatePerimeter());
        Assertions.assertEquals(620, squares.get(2).calculatePerimeter());
    }
}
