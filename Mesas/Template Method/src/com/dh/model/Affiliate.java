package com.dh.model;

public class Affiliate extends Salesperson {
    @Override
    protected void addPointsForSales() {
        addPoints(10*getSales());
    }

    @Override
    protected void addPointsForTime() {
        return;
    }

    @Override
    protected void addPointsForAffiliations() {
        return;
    }
}
