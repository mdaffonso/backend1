package com.dh.factory;

import com.dh.model.Tree;
import com.dh.model.TreeType;

import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    private static Map<TreeType, Tree> trees = new HashMap<>();
    private static Integer counter = 0;

    public static Tree plant(TreeType treeType) {

        Integer height, width;
        String color;

        switch (treeType) {
            case ORNAMENTAL:
                height = 200;
                width = 400;
                color = "green";
                break;

            case FRUITBEARING:
                height = 500;
                width = 300;
                color = "red";
                break;

            case FLORAL:
                height = 100;
                width = 200;
                color = "blue";
                break;

            default:
                height = 0;
                width = 0;
                color = "";
        }

        if(!trees.containsKey(treeType)) {
            trees.put(treeType, new Tree(height, width, color));
        }

        counter++;
        return trees.get(treeType);
    }

    public static Integer getCounter() {
        return counter;
    }
}
