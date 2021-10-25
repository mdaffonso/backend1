package com.dh;

public class Calculator {
    public static double sum(double... numbers) {
        double result = 0;

        if(numbers.length > 0) {
            for (double number : numbers) {
                result += number;
            }
        }

        return result;
    }
}
