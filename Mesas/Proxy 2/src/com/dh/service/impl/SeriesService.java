package com.dh.service.impl;

import com.dh.service.SeriesInterface;

public class SeriesService implements SeriesInterface {

    private String converted(String name) {
        return name.replaceAll(" ", "-");
    }

    @Override
    public String getSeries(String name) {
        return "www.vinnyflix.com.br/" + converted(name);
    }
}
