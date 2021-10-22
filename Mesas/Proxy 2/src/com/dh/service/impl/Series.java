package com.dh.service.impl;

import com.dh.exceptions.SeriesUnavailable;

public class Series {

    static SeriesService service = new SeriesService();
    static SeriesProxy proxy = new SeriesProxy(service);

    public static String watch(String name) throws SeriesUnavailable {
        return proxy.getSeries(name);
    }

}
