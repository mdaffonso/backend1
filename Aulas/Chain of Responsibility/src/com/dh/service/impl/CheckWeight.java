package com.dh.service.impl;

import com.dh.model.Product;
import com.dh.service.QualityChecker;

public class CheckWeight extends QualityChecker {

    private Integer minWeight = 1200;
    private Integer maxWeight = 1300;

    @Override
    public boolean check(Product product) {
        return product.getWeight() >= minWeight && product.getWeight() <= maxWeight;
    }
}
