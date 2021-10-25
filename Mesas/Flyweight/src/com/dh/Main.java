package com.dh;

import com.dh.factory.TreeFactory;
import com.dh.model.TreeType;


public class Main {

    public static void main(String[] args) {

        for (Integer i = 0; i < 1000000; i++) {
            if (i % 2 == 0) {
                TreeFactory.plant(TreeType.ORNAMENTAL);
            } else {
                TreeFactory.plant(TreeType.FRUITBEARING);
            }
        }

        System.out.println(TreeFactory.getCounter());

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
    }
}
