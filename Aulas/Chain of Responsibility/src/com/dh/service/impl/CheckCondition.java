package com.dh.service.impl;

import com.dh.model.Condition;
import com.dh.model.Product;
import com.dh.service.QualityChecker;

import java.util.Arrays;
import java.util.List;

public class CheckCondition extends QualityChecker {

    private List<Condition> passing = Arrays.asList(Condition.SAUDAVEL, Condition.QUASE_SAUDAVEL);

    @Override
    public boolean check(Product product) {
        return passing.contains(product.getCondition());
    }
}
