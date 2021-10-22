package com.dh;

import com.dh.exceptions.SeriesUnavailable;
import com.dh.service.impl.Series;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws SeriesUnavailable {
        ArrayList<String> series = new ArrayList<>();
        Collections.addAll(series,
                "Breaking Bad",
                "House",
                "The Good Place",
                "Breaking Bad",
                "Breaking Bad",
                "The Good Place",
                "Breaking Bad",
                "Breaking Bad",
                "Breaking Bad");
        for(String title : series) {
            System.out.println(Series.watch(title));
        }
    }
}
