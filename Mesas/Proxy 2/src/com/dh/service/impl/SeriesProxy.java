package com.dh.service.impl;

import com.dh.exceptions.SeriesUnavailable;
import com.dh.service.SeriesInterface;

import java.util.HashMap;

public class SeriesProxy implements SeriesInterface {

    private HashMap<String, Integer> numViews = new HashMap<>();
    private SeriesService service;

    public SeriesProxy(SeriesService s) {
        service = s;
    }

    private void addView(String series) {

        if (numViews.get(series) == null) {
            numViews.put(series, 1);
            return;
        }

        Integer updatedViewCount = numViews.get(series) + 1;
        numViews.put(series, updatedViewCount);
    }

    private Integer getViews(String series) {
        return numViews.get(series);
    }

    @Override
    public String getSeries(String series) throws SeriesUnavailable {

        addView(series);

        if(getViews(series) > 5) {
            throw new SeriesUnavailable();
        }

        return service.getSeries(series);
    }
}
