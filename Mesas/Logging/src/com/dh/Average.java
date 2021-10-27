package com.dh;

import java.util.ArrayList;
import java.util.List;

public class Average {
    private List<Integer> integers = new ArrayList<>();
    private Double average = 0.0;

    public Average(Integer... integers) {
        if(integers.length > 0) {
            for(Integer integer : integers) {
                this.integers.add(integer);
                average += integer;
            }
            average = average / integers.length;
        }
    }

    public void addInteger(Integer integer) {
        this.integers.add(integer);
        setAverage();
    }

    private void setAverage() {
        average = 0.0;
        for(Integer integer : integers) {
            average += integer;
        }
        average = average / integers.size();
    }

    public Double getAverage() {
        return average;
    }

    public Integer getLength() {
        return integers.size();
    }

    @Override
    public String toString() {
        return "Average{" +
                "integers=" + integers +
                ", average=" + average +
                '}';
    }
}
