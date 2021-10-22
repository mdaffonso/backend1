package com.dh.service;

import com.dh.exceptions.SeriesUnavailable;

import java.io.UnsupportedEncodingException;

public interface SeriesInterface {
    public String getSeries(String name) throws UnsupportedEncodingException, SeriesUnavailable;
}
