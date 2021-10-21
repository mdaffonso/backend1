package com.dh.service.impl;

import com.dh.model.Product;
import com.dh.service.QualityChecker;

public class CheckLot extends QualityChecker {

    private Integer minLot = 1000;
    private Integer maxLot = 2000;

    @Override
    public boolean check(Product product) {
        return product.getLot() >= minLot && product.getLot() <= maxLot;
    }
}
