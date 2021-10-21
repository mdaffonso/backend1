package com.dh.service.impl;

import com.dh.model.Product;
import com.dh.service.QualityChecker;

public class CheckName extends QualityChecker {
    @Override
    protected boolean check(Product product) {
        System.out.println("PRODUTO " + product.getName());
        return true;
    }
}
